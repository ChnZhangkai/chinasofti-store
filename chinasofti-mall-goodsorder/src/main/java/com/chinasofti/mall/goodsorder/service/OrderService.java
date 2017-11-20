package com.chinasofti.mall.goodsorder.service;

import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.utils.ResponseInfo;

public interface OrderService {

	public ResponseInfo queryOrderListByUserId(String userId);
	
	public ResponseInfo saveOrder(PyBigGoodsorder pyBigGoodsorder);

	public ResponseInfo cancelOrder(PyBigGoodsorder pyBigGoodsorder);
	
	public ResponseInfo deleteOrderById(String orderId);
}
