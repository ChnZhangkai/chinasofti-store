package com.chinasofti.mall.goodsorder.service.impl;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorderExample;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.goodsorder.handler.MyException;
import com.chinasofti.mall.goodsorder.service.BigGoodsorderService;
import com.chinasofti.mall.goodsorder.service.ChildGoodsorderService;
import com.chinasofti.mall.goodsorder.service.MainGoodsorderService;
import com.chinasofti.mall.goodsorder.service.OrderService;

/**
 * 调用多个订单服务处理用户订单信息
 * @ClassName: OrderServiceImpl.java
 * @Description: TODO
 * @author 黄佳喜
 * @Date: 2017年11月24日 下午2:30:27
 * @parma <T>
 */
@Service
public class OrderServiceImpl implements OrderService {

	private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

	@Autowired
	private MainGoodsorderService mainGoodsorderService;

	@Autowired
	private ChildGoodsorderService childGoodsorderService;

	@Autowired
	private BigGoodsorderService bigGoodsorderService;
	
	private List<PyMainGoodsorder> mainList = new LinkedList<PyMainGoodsorder>() ;//主订单集合

	@Override
	public ResponseInfo queryOrderListByUserId(String userId) {
		ResponseInfo info = new ResponseInfo();
		// 用户的全部订单
		// 分类1.付款（付款未发货，已发货运输 已到货 已签收） 2.未付款
		PyBigGoodsorderExample example = new PyBigGoodsorderExample();
		example.createCriteria().andUserIdsEqualTo(userId);
		Map<String, Object> data = new HashMap<String, Object>();
		List<PyBigGoodsorder> list = bigGoodsorderService.selectByExample(example);
		List<PyMainGoodsorder> pyMainGoodsorders = mainGoodsorderService.selectByUserIds(userId);
		Map<String, Object> map = null;
		List<Object> array0 = new ArrayList<Object>();
		List<Object> array1 = new ArrayList<Object>();
		List<Object> array2 = new ArrayList<Object>();
		//只查询出用户下单后未付款和已付款的订单，被删除或者被取消的订单不做展示
		if (list.size() != 0 && pyMainGoodsorders.size() != 0) {
			for (PyBigGoodsorder pyBigGoodsorder : list) {
				// 支付状态 未付款
				map = new HashMap<String, Object>();
				if (PyBigGoodsorder.PAY_STATUS_NOT.equals(pyBigGoodsorder.getPayStatus())) {
					array0.add(getMap(pyMainGoodsorders, map, pyBigGoodsorder));
				}
				// 已付款
				if (PyBigGoodsorder.PAY_STATUS_OK.equals(pyBigGoodsorder.getPayStatus())) {
					array1.add(getMap(pyMainGoodsorders, map, pyBigGoodsorder));
				}
				// 被取消
				if (PyBigGoodsorder.PAY_STATUS_CANCLE.equals(pyBigGoodsorder.getPayStatus())) {
					array2.add(getMap(pyMainGoodsorders, map, pyBigGoodsorder));
				}
			}
			data.put("未付款订单", array0);
			data.put("已付款订单", array1);
			data.put("被取消订单", array2);
			
			info.setData(data);
			info.setRetMsg(MsgEnum.SUCCESS.getMsg());
			info.setRetCode(MsgEnum.SUCCESS.getCode());
		}else {
			data.put("msg", "暂无您的订单信息");
			info.setData(data);
			info.setRetCode(MsgEnum.ERROR.getCode());
			info.setRetMsg(MsgEnum.ERROR.getMsg());
		}
		return info;
	}

	private Map<String, Object> getMap(List<PyMainGoodsorder> pyMainGoodsorders, Map<String, Object> map, PyBigGoodsorder pyBigGoodsorder) {
		for (PyMainGoodsorder pyMainGoodsorder : pyMainGoodsorders) {
			if (pyMainGoodsorder.getBigorderId().equals(pyBigGoodsorder.getTransactionid())) {
				map.put("pyBigGoodsorder", pyBigGoodsorder);
				map.put("pyMainGoodsorder", pyMainGoodsorder);
				List<PyChildGoodsorder> pyChildGoodsorders = childGoodsorderService.selectByMainorderIds(pyMainGoodsorder.getTransactionid());
				BigDecimal sum = new BigDecimal(0);
				for (PyChildGoodsorder pyChildGoodsorder : pyChildGoodsorders) {
					sum = pyChildGoodsorder.getGoodsNum().add(sum);
				}
				map.put("pyChildGoodsorders", pyChildGoodsorders);
				map.put("sum", sum);
			}
		}
		return map;
	}
	
	
	@Override
	@Transactional(readOnly=false,rollbackFor={RuntimeException.class, Exception.class})//启动事务
	public ResponseInfo saveOrder(JSONObject json) {
		ResponseInfo responseInfo = new ResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try{
			String orderCreateTime = mathNum();//订单生成时间 yyyyMMddhhmmss
			PyBigGoodsorder pyBigGoodsorder = new PyBigGoodsorder();
			pyBigGoodsorder.setIds(UUIDUtils.getUuid());
			String transactionid = orderCreateTime.concat(getFixLenthString(4));//生成随机数yyyyMMddhhmmss+0000+4位随机数
			pyBigGoodsorder.setTransactionid(transactionid);//大订单编号，流水号
			pyBigGoodsorder.setOrderRealAmt(json.getBigDecimal("orderRealAmt"));//实付总额
			pyBigGoodsorder.setUserIds(json.getString("userId"));//用户ID
			pyBigGoodsorder.setOrderDate(orderCreateTime);//订单生成时间
			
			
			List<PyChildGoodsorder> childList = new LinkedList<PyChildGoodsorder>();//子订单集合
			childList = getOrderInfo(orderCreateTime,transactionid,json);
			if(childList !=null){
				int child=childGoodsorderService.insertChildGoodsorderList(childList);//保存子订单
				logger.info("***子订单插入成功***="+child);
				int main=mainGoodsorderService.insertMainGoodsorderList(mainList);//保存主订单
				logger.info("***主订单插入成功***="+main);
				int big=bigGoodsorderService.save(pyBigGoodsorder);//保存大订单
				logger.info("***大订单插入成功***="+big);
				
			}
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
			data.put("pyMainGoodsorder", mainList);
			data.put("pyChildGoodsorder", childList);
			data.put("pyBigGoodsorder", pyBigGoodsorder);
			responseInfo.setData(data);
		}catch(Exception e){
			System.out.println(e);
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("提交订单失败");
		}
		return responseInfo;
	}

	@Override
	public ResponseInfo cancelOrder(String orderId) {
		ResponseInfo responseInfo = new ResponseInfo();
		PyBigGoodsorder pyBigGoodsorder = new PyBigGoodsorder();
		pyBigGoodsorder.setIds(orderId);
		pyBigGoodsorder.setPayStatus(PyBigGoodsorder.PAY_STATUS_CANCLE);
		pyBigGoodsorder.setStatus(PyBigGoodsorder.STATUS_UNABLE);
		int count = bigGoodsorderService.update(pyBigGoodsorder);
		if (count > 0) {
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
		} else {
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("提交取消订单失败");
		}
		return responseInfo;
	}

	@Override
	public ResponseInfo deleteOrderById(String orderId) {
		ResponseInfo responseInfo = new ResponseInfo();
		PyBigGoodsorder pyBigGoodsorder = new PyBigGoodsorder();
		pyBigGoodsorder.setIds(orderId);
		pyBigGoodsorder.setStatus(PyBigGoodsorder.STATUS_UNABLE);
		pyBigGoodsorder.setPayStatus(PyBigGoodsorder.PAY_STATUS_DELETE);
		int count = bigGoodsorderService.update(pyBigGoodsorder);
		if (count > 0) {
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
		} else {
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("提交删除失败");
		}
		return responseInfo;
	}

	@Override
	public ResponseInfo payOrder(PyMainGoodsorder pyMainGoodsorder) {
		ResponseInfo responseInfo = new ResponseInfo();
		try {
			PyBigGoodsorder pyBigGoodsorder = bigGoodsorderService.selectByIds(pyMainGoodsorder.getBigorderId());
			pyBigGoodsorder.setPayStatus("1");
			pyBigGoodsorder.setPayTime(StringDateUtil.convertDateToLongString(new Date()));
			pyBigGoodsorder.setPayway("中信信用卡支付");
			bigGoodsorderService.update(pyBigGoodsorder);
			PyChildGoodsorder pyChildGoodsorder = childGoodsorderService.selectByMainorderIds(pyBigGoodsorder.getIds()).get(0);
			pyChildGoodsorder.setOrderStatus("已付款");
			childGoodsorderService.save(pyChildGoodsorder);
			pyMainGoodsorder.setIds(UUIDUtils.getUuid());
			pyMainGoodsorder.setPayTime(StringDateUtil.convertDateToLongString(new Date()));
			mainGoodsorderService.save(pyMainGoodsorder);
			
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
		} catch (Exception e) {
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("支付订单失败");
		}

		return responseInfo;
	}

	@Override
	public ResponseInfo updateOrder(JSONObject json) {
		ResponseInfo responseInfo = new ResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try {
			@SuppressWarnings("unchecked")
			List<PyChildGoodsorder> goodsList = (List<PyChildGoodsorder>) json.get("goodsList");
			if (null != goodsList) {
				for (PyChildGoodsorder pyChildGoodsorder : goodsList) {
					childGoodsorderService.update(pyChildGoodsorder);
				}
			}
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
			responseInfo.setData(data);
		} catch (Exception e) {
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("提交订单失败");
		}
		return responseInfo;
	}
	
	//组装订单信息
		private List<PyChildGoodsorder> getOrderInfo(String orderCreateTime,String bigOrderNo,JSONObject json) throws Exception{
			PyMainGoodsorder mainGoodsorder = new PyMainGoodsorder();//主订单
			PyChildGoodsorder childorder = new PyChildGoodsorder();//子订单
			List<PyChildGoodsorder> childList = new LinkedList<PyChildGoodsorder>();//子订单集合
			JSONObject json_mian = new JSONObject();//购物车对象
			json_mian = json.getJSONObject("shopCard");//获取购物车信息
			int main_size = json_mian.size();//商户个数
			JSONObject json_shop = new JSONObject();//商户对象
			JSONObject json_goods = new JSONObject();//商品对象
			String mainTransactionId = null;
			String childTransactionId = null;
			for(int i=1;i<main_size+1;i++){
				//String mainOrderNo = getOrderNo(i,bigOrderNo);//获取组订单编号
				mainGoodsorder.setIds(UUIDUtils.getUuid());//IDS
				mainGoodsorder.setBigorderId(bigOrderNo);//所属大订单
				mainTransactionId = "M".concat(orderCreateTime.concat(getFixLenthString(4)));//主订单流水号
				mainGoodsorder.setTransactionid(mainTransactionId);
				mainGoodsorder.setVendorIds(json_mian.getJSONObject(("shop"+Integer.toString(i))).getString("shopId"));//商户ID
				mainGoodsorder.setUserIds(json.getString("userId"));
				mainGoodsorder.setOrderTime(orderCreateTime);//订单时间
				mainGoodsorder.setPayStatus("0");//支付状态  0 未支付 1 已支付  2 取消
				mainGoodsorder.setStatus("0");//订单状态   0 待付款  1 待发货 2 待收货 3 交易成功  4 交易关闭（已删除） 5 交易关闭（已取消） 6 交易关闭（退款成功）；
				BigDecimal shoporderAmt = null;//商户订单总金额;
				BigDecimal goodsorderAmt = null;//商品金额;
				json_shop = json_mian.getJSONObject(("shop"+Integer.toString(i)));
				int goods_size = json_shop.size();//注意:此JSON对象有一个shopId属性
				for(int j=1;j<goods_size;j++){
					json_goods = json_shop.getJSONObject(("goods"+Integer.toString(j)));
					String goodsId = json_goods.getString("goodsId");
					BigDecimal goodsNum = json_goods.getBigDecimal("goodsNum");
					//验证商品上架剩余数量
					boolean flag = checkGoods(goodsId,goodsNum);
					//如果数量超出,直接返回
					if(!flag){
						childList = null;
						mainList  = null;
						throw new Exception("商品购买数量超过库存");
					}
					childorder.setGoodsids(goodsId);//商品ID
					childorder.setGoodsNum(goodsNum);//商品数量
					childorder.setMainorderIds(mainTransactionId);//所属主订单编号
					childTransactionId = "G".concat(orderCreateTime.concat(getFixLenthString(4)));//子订单流水号
					childorder.setTransactionid(childTransactionId);
					childorder.setIds(UUIDUtils.getUuid());//IDS
					childorder.setCustIds(json.getString("userId"));
					
					childorder.setGoodsPrice(json_goods.getBigDecimal("goodsPrice"));//商品价格
					goodsorderAmt = json_goods.getBigDecimal("goodsNum").multiply(json_goods.getBigDecimal("goodsNum"));//金额
					if(j==1){
						shoporderAmt = goodsorderAmt; 
					}else{
						shoporderAmt = shoporderAmt.add(goodsorderAmt);
					}
					
					childorder.setOrderAmt(goodsorderAmt);//金额
					logger.info("************子订单**************="+childorder.toString());
					childList.add(childorder);
				}
				mainGoodsorder.setOrderTotalAmt(shoporderAmt);
				logger.info("************主订单**************="+mainGoodsorder.toString());
				mainList.add(mainGoodsorder);
			
			}
			
			return childList;
			
		}
		
		/*//组装订单编号
		private String getOrderNo(int i,String orderNo){
			String mainOrderIds = null;
			if(i<10){
				mainOrderIds = orderNo.concat("0".concat(Integer.toString(i))) ;
			}else{
				mainOrderIds = orderNo.concat(Integer.toString(i));
			}
			return mainOrderIds;
		}*/
		//验证商品库存数量
		private boolean checkGoods(String goodsId,BigDecimal num) throws MyException{
			BigDecimal goodsNum = childGoodsorderService.selectGoodsNum(goodsId);
			logger.info("***************商品数量*********="+goodsNum);
			int flag = num.compareTo(goodsNum);
			if(flag == 1){
				return false;
			}
			return true;
		}
		//生成时间戳
		private String mathNum(){
			Date date = new Date();
			SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
			String nowTime = sd.format(date);
			return nowTime;
		}
		//生成随机数
		private static String getFixLenthString(int strLength) {
	        Random rm = new Random(); 
	        // 获得随机数
	        double pross = (1 + rm.nextDouble()) * Math.pow(10, strLength);
	        // 将获得的获得随机数转化为字符串
	        String fixLenthString = String.valueOf(pross);
	        // 返回固定的长度的随机数
	        return "0000".concat(fixLenthString.substring(1, strLength + 1));
	    }

}
