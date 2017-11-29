package com.chinasofti.mall.batch.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.chinasofti.mall.batch.bean.PyBigGoodsorder;
import com.chinasofti.mall.batch.constants.Constants;
@Component("cancelGoodsOrdersProcessor")
public class CancelGoodsOrdersProcessor implements ItemProcessor<PyBigGoodsorder, PyBigGoodsorder> {
	
	private Logger logger = LoggerFactory.getLogger(CancelGoodsOrdersProcessor.class);
	
	@Override
	public PyBigGoodsorder process(PyBigGoodsorder item) throws Exception {
		logger.info("当前处理的订单号是: "+item.getTransactionid());
		
		//修改订单状态为 已取消-2
		item.setPayStatus(Constants.PAY_STATUS_2);
		
		return item;
	}

}
