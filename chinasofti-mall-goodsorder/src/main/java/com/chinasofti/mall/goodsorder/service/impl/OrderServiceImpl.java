package com.chinasofti.mall.goodsorder.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorderExample;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.common.utils.UUIDUtils;
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
	public ResponseInfo saveOrder(JSONObject json) {

		ResponseInfo responseInfo = new ResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		String pyBigGoodsorderUuid = UUIDUtils.getUuid();
		String userIds = json.getString("userIds");
		try {
			@SuppressWarnings("unchecked")
			List<PyChildGoodsorder> goodsList = (List<PyChildGoodsorder>) json.get("goodsList");
			if (null != goodsList) {
				for (PyChildGoodsorder pyChildGoodsorder : goodsList) {
					// 设置关联的主订单id
					pyChildGoodsorder.setMainorderIds(pyBigGoodsorderUuid);
					childGoodsorderService.save(pyChildGoodsorder);
				}
			}
			PyBigGoodsorder pyBigGoodsorder = new PyBigGoodsorder();
			pyBigGoodsorder.setIds(pyBigGoodsorderUuid);
			pyBigGoodsorder.setOrderDate(StringDateUtil.convertDateToLongString(new Date()));
			pyBigGoodsorder.setUserIds(userIds);
			bigGoodsorderService.save(pyBigGoodsorder);

			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
			data.put("pyBigGoodsorder", pyBigGoodsorder);
			responseInfo.setData(data);
		} catch (Exception e) {
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

}
