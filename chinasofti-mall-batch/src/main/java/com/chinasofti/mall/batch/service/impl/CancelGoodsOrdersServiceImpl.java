package com.chinasofti.mall.batch.service.impl;

import com.chinasofti.mall.batch.mapper.PyBigGoodsOrderMapper;
import com.chinasofti.mall.batch.mapper.PyMainGoodsOrderMapper;
import com.chinasofti.mall.batch.service.CancelGoodsOrdersService;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelGoodsOrdersServiceImpl implements CancelGoodsOrdersService {
	
	private Logger logger = LoggerFactory.getLogger(CancelGoodsOrdersServiceImpl.class);
	
	@Autowired
	private PyBigGoodsOrderMapper pyBigGoodsorderMapper ;
	
	@Autowired
	private PyMainGoodsOrderMapper pyMainGoodsOrderMapper ;
	
	public void updatePaywayStatus(PyBigGoodsorder pyBigGodsOrder) throws Exception{
		try{
			//更新大订单
			this.pyBigGoodsorderMapper.updatePaywayStatus(pyBigGodsOrder);
			
			//更新主订单
			this.pyMainGoodsOrderMapper.updatePayStatus(pyBigGodsOrder.getTransactionid());
			
			/**
			 * TODO:
			 * 子订单表没有增加相关逻辑
			 * 库存和销量没有回滚
			 */
		}catch(Exception e){
			logger.error(e.getMessage());
			throw new Exception("CancelGoodsOrdersService.updatePaywayStatus()更新支付状态失败!"); 
		}
	}
}
