package com.chinasofti.mall.goodsorder.service;

import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;

public interface OrderService {

	public ResponseInfo queryOrderListByUserId(String userId);
	
	public ResponseInfo saveOrder( JSONObject json );

	public ResponseInfo cancelOrder(PyBigGoodsorder pyBigGoodsorder);
	
	public ResponseInfo deleteOrderById(String orderId);

	public ResponseInfo payOrder(PyMainGoodsorder pyMainGoodsorder);

	public ResponseInfo updateOrder(JSONObject json);
}
