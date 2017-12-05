package com.chinasofti.mall.batch.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.batch.bean.PyBigGoodsorder;
import com.chinasofti.mall.batch.mapper.PyBigGoodsorderMapper;
import com.chinasofti.mall.batch.mapper.PyMainGoodsOrderMapper;
import com.chinasofti.mall.batch.service.CancelGoodsOrdersService;

@Service
public class CancelGoodsOrdersServiceImpl implements CancelGoodsOrdersService {
	
	private Logger logger = LoggerFactory.getLogger(CancelGoodsOrdersServiceImpl.class);
	
	@Autowired
	private PyBigGoodsorderMapper pyBigGoodsorderMapper ;
	
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
