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
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.order.PyOrderInfo;
import com.chinasofti.mall.common.entity.order.PyShoppingCartInfo;
import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.goodsorder.handler.GoodsNumNotFondException;
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
		Map<String, Object> data = new HashMap<String, Object>();
		List<PyBigGoodsorder> list = bigGoodsorderService.selectByUserIds(userId);
		List<PyMainGoodsorder> pyMainGoodsorders = mainGoodsorderService.selectByUserIds(userId);
		List<PyChildGoodsorder> pyChildGoodsorders = childGoodsorderService.selectByUserIds(userId);

		List<Object> array0 = new ArrayList<Object>();
		List<Object> array1 = new ArrayList<Object>();
		List<Object> array2 = new ArrayList<Object>();
		//只查询出用户下单后未付款和已付款的订单，被删除或者被取消的订单不做展示
		if (list.size() != 0 && pyMainGoodsorders.size() != 0) {
			for (PyBigGoodsorder pyBigGoodsorder : list) {
				// 支付状态 未付款
				if (PyBigGoodsorder.PAY_STATUS_NOT.equals(pyBigGoodsorder.getPayStatus())) {
					array0.add(getMap(pyChildGoodsorders, pyMainGoodsorders, pyBigGoodsorder));
				}
				// 已付款
				if (PyBigGoodsorder.PAY_STATUS_OK.equals(pyBigGoodsorder.getPayStatus())) {
					array1.add(getMap(pyChildGoodsorders, pyMainGoodsorders, pyBigGoodsorder));
				}
				// 被取消
				if (PyBigGoodsorder.PAY_STATUS_CANCLE.equals(pyBigGoodsorder.getPayStatus())) {
					array2.add(getMap(pyChildGoodsorders, pyMainGoodsorders, pyBigGoodsorder));
				}
			}
			data.put("unpaidOrder", array0);
			data.put("paymentOrder", array1);
			data.put("cancelOrder", array2);
			
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

	private Map<String, Object> getMap(List<PyChildGoodsorder> pyChildGoodsorders, List<PyMainGoodsorder> pyMainGoodsorders, PyBigGoodsorder pyBigGoodsorder) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pyBigGoodsorder", pyBigGoodsorder);
		List<PyMainGoodsorder> mainGoodsorders = new ArrayList<PyMainGoodsorder>();
		List<PyChildGoodsorder> childGoodsorders = new ArrayList<PyChildGoodsorder>();
		BigDecimal sum = new BigDecimal(0);
		String mainId = "";
		for (PyMainGoodsorder pyMainGoodsorder : pyMainGoodsorders) {
			if (pyMainGoodsorder.getBigorderId().equals(pyBigGoodsorder.getTransactionid())) {
				mainGoodsorders.add(pyMainGoodsorder);
				mainId = pyMainGoodsorder.getTransactionid();
				for (PyChildGoodsorder pyChildGoodsorder : pyChildGoodsorders) {
					if (pyChildGoodsorder.getMainorderIds().equals(mainId)) {				
						sum = pyChildGoodsorder.getGoodsNum().add(sum);
						childGoodsorders.add(pyChildGoodsorder);
					}
				}
			}
		}
		map.put("sum", sum);
		map.put("pyMainGoodsorder", mainGoodsorders);
		map.put("pyChildGoodsorder", childGoodsorders);
		return map;
	}
	
	@Override
	@Transactional(readOnly=false,rollbackFor={RuntimeException.class, Exception.class})//启动事务
	public ResponseInfo saveOrder(PyOrderInfo orderInfo){
		ResponseInfo res = new ResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try{
			String transactionid = orderInfo.getOrderNo();//为防止重复提交，前端传有一个流水号进来
			int count = bigGoodsorderService.countOrderNO(transactionid);
			if(count !=0){
				res.setRetCode("900010");
				res.setRetMsg("该订单已提交过");
				return res;
			}
			//获取地址ID
			String addressId = orderInfo.getAddressId();
			if(addressId ==null){
				res.setRetCode("900011");
				res.setRetMsg("收件地址信息不能为空");
				return res;
			}
			//获取收件地址信息
			SpSendAddress address = childGoodsorderService.queryAddress(addressId);
			if(address ==null){
				res.setRetCode("900012");
				res.setRetMsg("收件地址信息异常");
				return res;
			}
			PyBigGoodsorder pyBigGoodsorder = new PyBigGoodsorder();//大订单对象
			String orderCreateTime = mathNum();//订单生成时间 yyyyMMddhhmmss
			pyBigGoodsorder.setIds(UUIDUtils.getUuid());
			pyBigGoodsorder.setOrderDate(orderCreateTime);//订单生成时间
			//String transactionid = orderCreateTime.concat(getFixLenthString(4));//生成随机数yyyyMMddhhmmss+0000+4位随机数
			pyBigGoodsorder.setTransactionid(transactionid);//大订单编号，流水号
			pyBigGoodsorder.setOrderRealAmt(orderInfo.getOrderRealAmt());//实付总额
			pyBigGoodsorder.setUserIds(orderInfo.getUserId());//用户ID
			
			List<PyChildGoodsorder> childList = new LinkedList<PyChildGoodsorder>();//子订单集合
			childList = installOrdergetOrderInfo(address,orderCreateTime,transactionid,orderInfo);
			if(childList !=null){
				int child=childGoodsorderService.insertChildGoodsorderList(childList);//保存子订单
				logger.info("***子订单插入成功***="+child);
				int main=mainGoodsorderService.insertMainGoodsorderList(mainList);//保存主订单
				logger.info("***主订单插入成功***="+main);
				int big=bigGoodsorderService.save(pyBigGoodsorder);//保存大订单
				logger.info("***大订单插入成功***="+big);
				
			}
			res.setRetCode(MsgEnum.SUCCESS.getCode());
			res.setRetMsg("订单提交成功");
			data.put("pyMainGoodsorder", mainList);
			data.put("pyChildGoodsorder", childList);
			data.put("pyBigGoodsorder", pyBigGoodsorder);
			res.setData(data);
		}catch(GoodsNumNotFondException e){
			res.setRetCode("900013");
			res.setRetMsg("您购买的 "+e.getValue()+e.getMessage());
		}catch (Exception e) {
			res.setRetCode(MsgEnum.SERVER_ERROR.getCode());
			res.setRetMsg(MsgEnum.SERVER_ERROR.getMsg());
			logger.error(e.toString());
		}
		return res;
		
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
		private List<PyChildGoodsorder> installOrdergetOrderInfo(SpSendAddress address,String orderCreateTime,
			String bigOrderNo,PyOrderInfo orderInfo) throws GoodsNumNotFondException{
			PyMainGoodsorder mainGoodsorder = new PyMainGoodsorder();//主订单
			PyChildGoodsorder childorder = new PyChildGoodsorder();//子订单
			List<PyChildGoodsorder> goodsInfoList = new LinkedList<PyChildGoodsorder>();//单个商户商品信息集合
			List<PyChildGoodsorder> childList = new LinkedList<PyChildGoodsorder>();//子订单集合
			List<PyShoppingCartInfo> shopCart = orderInfo.getShopCart();
			
			int main_size = shopCart.size();//商户个数
			String mainTransactionId = null;
			String childTransactionId = null;
			for(int i=0;i<main_size;i++){
				mainGoodsorder.setIds(UUIDUtils.getUuid());//IDS
				mainGoodsorder.setBigorderId(bigOrderNo);//所属大订单
				mainTransactionId = "M".concat(orderCreateTime.concat(getFixLenthString(4)));//主订单流水号
				mainGoodsorder.setTransactionid(mainTransactionId);
				mainGoodsorder.setVendorIds(shopCart.get(i).getVendorIds());//商户ID
				mainGoodsorder.setUserIds(orderInfo.getUserId());
				mainGoodsorder.setOrderTime(orderCreateTime);//订单时间
				mainGoodsorder.setPayStatus("0");//支付状态  0 未支付 1 已支付  2 取消
				mainGoodsorder.setStatus("0");//订单状态   0 待付款  1 待发货 2 待收货 3 交易成功  4 交易关闭（已删除） 5 交易关闭（已取消） 6 交易关闭（退款成功）；
				mainGoodsorder.setContPostcode(address.getZipCode());//邮编
				mainGoodsorder.setContPhone(address.getMobile());//联系电话
				mainGoodsorder.setContProvince(address.getProvince());//省
				mainGoodsorder.setContCity(address.getCity());//市
				mainGoodsorder.setContDistrict(address.getDistrict());//区
				mainGoodsorder.setContStreet(address.getStreet());//街道
				mainGoodsorder.setContAddress(address.getAddress());//详细地址
				mainGoodsorder.setContName(address.getName());//收件人姓名
				BigDecimal shoporderAmt = null;//商户订单总金额;
				BigDecimal goodsorderAmt = null;//商品金额;
				String goodsId = null;//商品ID
				String goodsName = null;//商品名称
				BigDecimal goodsNum = null;//购买数量
				BigDecimal goodsPrice = null;//商品价格
				goodsInfoList = shopCart.get(i).getGoodsInfoList();
				int goods_size = goodsInfoList.size();
				for(int j=0;j<goods_size;j++){
					goodsId = goodsInfoList.get(j).getGoodsids();//商品ID
					goodsName = goodsInfoList.get(j).getGoodsName();//商品名称
					goodsNum = goodsInfoList.get(j).getGoodsNum();//购买数量
					goodsPrice = goodsInfoList.get(j).getGoodsPrice();//商品单价
					childorder.setGoodsids(goodsId);//商品ID
					childorder.setGoodsNum(goodsInfoList.get(j).getGoodsNum());//购买数量
					//验证商品上架剩余数量
					boolean flag = checkGoods(goodsId,goodsNum);
					//如果数量超出,直接返回
					if(!flag){
						childList = null;
						mainList  = null;
						throw new GoodsNumNotFondException("数量超过库存",goodsName);
					}
					childorder.setGoodsPrice(goodsPrice);
					goodsorderAmt = goodsNum.multiply(goodsPrice);//商品金额
					if(j==1){
						shoporderAmt = goodsorderAmt; 
					}else{
						shoporderAmt = shoporderAmt.add(goodsorderAmt);
					}
					childorder.setMainorderIds(mainTransactionId);//所属主订单编号
					childTransactionId = "G".concat(orderCreateTime.concat(getFixLenthString(4)));//子订单流水号
					childorder.setTransactionid(childTransactionId);
					childorder.setIds(UUIDUtils.getUuid());//IDS
					childorder.setCustIds(orderInfo.getUserId());//用户ID
					
					logger.info("************子订单"+j+"**************="+childorder.toString());
					childList.add(childorder);
					
				}
				mainGoodsorder.setOrderTotalAmt(shoporderAmt);
				logger.info("************主订单"+i+"*************="+mainGoodsorder.toString());
				mainList.add(mainGoodsorder);
				
			}			
			return childList;
		}
	//验证商品库存数量
	private boolean checkGoods(String goodsId,BigDecimal num) {
		BigDecimal goodsNum = childGoodsorderService.selectGoodsNum(goodsId);
		if(goodsNum == null){
			logger.info("获取商品数量为空或者发生异常");
			return false;
		}
		int flag = num.compareTo(goodsNum);//购买数量是否小于等于库存
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
