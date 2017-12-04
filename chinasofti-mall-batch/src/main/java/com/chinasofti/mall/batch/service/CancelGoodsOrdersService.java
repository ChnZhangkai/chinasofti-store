package com.chinasofti.mall.batch.service;

import com.chinasofti.mall.batch.bean.PyBigGoodsorder;

public interface CancelGoodsOrdersService {
	/**
	 * 更新订单的支付状态
	 * @param pyBigGodsOrder
	 * @throws Exception
	 */
	void updatePaywayStatus(PyBigGoodsorder pyBigGodsOrder) throws Exception ;
}
