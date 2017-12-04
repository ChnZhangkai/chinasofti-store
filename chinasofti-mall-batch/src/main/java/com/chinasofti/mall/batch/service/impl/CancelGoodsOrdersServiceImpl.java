package com.chinasofti.mall.batch.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.batch.bean.PyBigGoodsorder;
import com.chinasofti.mall.batch.mapper.PyBigGoodsorderMapper;
import com.chinasofti.mall.batch.service.CancelGoodsOrdersService;

@Service
public class CancelGoodsOrdersServiceImpl implements CancelGoodsOrdersService {
	
	@Autowired
	private PyBigGoodsorderMapper pyBigGoodsorderMapper ;
	
	public void updatePaywayStatus(PyBigGoodsorder pyBigGodsOrder) throws Exception{
		try{
			this.pyBigGoodsorderMapper.updatePaywayStatus(pyBigGodsOrder);
			if("0f112f31de8746e4af098077425259a0".equals(pyBigGodsOrder.getIds())){
				throw new Exception();
			}
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("CancelGoodsOrdersService.updatePaywayStatus()更新支付状态失败!"); 
		}
	}
}
