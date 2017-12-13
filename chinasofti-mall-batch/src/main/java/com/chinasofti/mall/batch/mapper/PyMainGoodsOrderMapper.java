package com.chinasofti.mall.batch.mapper;

import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PyMainGoodsOrderMapper {

	/**
	 * 更新主订单表
	 * @param pyMainGoodsorder
	 */
	void updateMainGoodsOrder(@Param("pyMainGoodsorder") PyMainGoodsorder pyMainGoodsorder) ;


	/**
	 * 根据大订单号检索出相应的主订单
	 * @param pyBigGoodsorder
	 * @return
	 */
	List<PyMainGoodsorder> findListByMainId(@Param("pyBigGoodsorder")PyBigGoodsorder pyBigGoodsorder) ;
}
