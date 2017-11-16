package com.chinasofti.mall.goodsorder.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.goodsorder.service.BigGoodsorderService;
import com.chinasofti.mall.goodsorder.service.ChildGoodsorderService;
import com.chinasofti.mall.goodsorder.service.MainGoodsorderService;
import com.chinasofti.mall.goodsorder.service.OrderService;

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
	public ResponseInfo queryOrderListByUserId(JSONObject json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseInfo saveOrder(JSONObject json) {
		ResponseInfo responseInfo = new ResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try{
			PyBigGoodsorder pyBigGoodsorder = new PyBigGoodsorder();
			pyBigGoodsorder.setIds(UUIDUtils.getUuid());
			//pyBigGoodsorder.setTransactionid(transactionid);
			//……
			bigGoodsorderService.save(pyBigGoodsorder);
			
			PyMainGoodsorder pyMainGoodsorder = new PyMainGoodsorder();
			pyMainGoodsorder.setIds(UUIDUtils.getUuid());
			//……
			mainGoodsorderService.save(pyMainGoodsorder);
			
			PyChildGoodsorder pyChildGoodsorder = new PyChildGoodsorder();
			pyChildGoodsorder.setIds(UUIDUtils.getUuid());
			//……
			childGoodsorderService.save(pyChildGoodsorder);
			
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
			data.put("pyMainGoodsorder", pyMainGoodsorder);
			data.put("pyChildGoodsorder", pyChildGoodsorder);
			data.put("pyBigGoodsorder", pyBigGoodsorder);
			responseInfo.setData(data);
		}catch(Exception e){
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("提交订单失败");
		}
		return responseInfo;
	}

	@Override
	public ResponseInfo cancelOrder(JSONObject json) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseInfo deleteOrderById(JSONObject json) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
