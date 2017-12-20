package com.chinasofti.mall.batch.processor;

import com.chinasofti.mall.batch.constants.Constants;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;
@Component("cancelGoodsOrdersProcessor")
public class CancelGoodsOrdersProcessor implements ItemProcessor<PyBigGoodsorder, PyBigGoodsorder> {
	
	private Logger logger = LoggerFactory.getLogger(CancelGoodsOrdersProcessor.class);

	public PyBigGoodsorder process(PyBigGoodsorder item) throws Exception {
		logger.info("当前处理的订单号是: "+item.getTransactionid());

		/**
		 * 变更大订单信息
		 */
		item.setPayStatus(Constants.PAY_STATUS_2);

		return item;
	}

}
