package com.chinasofti.mall.goodsorder.service;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.utils.ResponseInfo;

public interface OrderService {

	public ResponseInfo queryOrderListByUserId(JSONObject json);
	
	public ResponseInfo saveOrder(JSONObject json);

	public ResponseInfo cancelOrder(JSONObject json);
	
	public ResponseInfo deleteOrderById(JSONObject json);
}
