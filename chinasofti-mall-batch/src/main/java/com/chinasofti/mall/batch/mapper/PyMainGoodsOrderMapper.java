package com.chinasofti.mall.batch.mapper;

import org.apache.ibatis.annotations.Param;

public interface PyMainGoodsOrderMapper {
	/**
	 * 根据大订单号更新
	 * @param bigOrderIds
	 */
	void updatePayStatus(@Param("bigOrderId") String bigOrderIds) ;
}
