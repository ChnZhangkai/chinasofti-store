package com.chinasofti.mall.batch.mapper;

import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PyMainGoodsOrderMapper {
	/**
	 * 根据大订单号更新
	 * @param bigOrderIds
	 */
	void updatePayStatus(@Param("bigOrderId") String bigOrderIds) ;

	/**
	 * 根据大订单号检索出相应的主订单
	 * @return
	 */
	List<PyMainGoodsorder> findListByMainId(@Param("ids") List<String> ids) ;
}
