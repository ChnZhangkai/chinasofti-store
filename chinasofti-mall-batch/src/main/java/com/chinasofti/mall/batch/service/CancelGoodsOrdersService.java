package com.chinasofti.mall.batch.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.batch.bean.PyBigGoodsorder;
import com.chinasofti.mall.batch.mapper.PyBigGoodsorderMapper;

@Service("cancelGoodsOrdersService")
public class CancelGoodsOrdersService {
	
	@Autowired
	private PyBigGoodsorderMapper pyBigGoodsorderMapper ;
	
	public void updatePaywayStatus(PyBigGoodsorder pyBigGodsOrder) throws Exception{
		try{
			this.pyBigGoodsorderMapper.updatePaywayStatus(pyBigGodsOrder);
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception("CancelGoodsOrdersService.updatePaywayStatus()更新支付状态失败!"); 
		}
	}
}
