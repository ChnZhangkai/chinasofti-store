package com.chinasofti.mall.batch.writer;

import com.chinasofti.mall.batch.service.CancelGoodsOrdersService;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component("cancelGoodsOrdersWriter")
public class CancelGoodsOrdersWriter implements ItemWriter<PyBigGoodsorder> {
	
	@Autowired
	private CancelGoodsOrdersService cancelGoodsOrdersService ;
	
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW,rollbackFor=Exception.class)
	@Override
	public void write(List<? extends PyBigGoodsorder> items) throws Exception {
		
		for (PyBigGoodsorder pyBigGoodsorder : items) {
			/**
			 * 更新订单的支付状态
			 */
			cancelGoodsOrdersService.updatePaywayStatus(pyBigGoodsorder);
			
		}
	}

}
