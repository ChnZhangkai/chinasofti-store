package com.chinasofti.mall.batch.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.batch.bean.PyBigGoodsorder;

public interface PyBigGoodsorderMapper {
	/**
	 * 查询7天内未支付的订单
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	List<PyBigGoodsorder> selectOrderNotPay(@Param("beginTime") String beginTime , @Param("endTime")String endTime) ;
	/**
	 * 更新7天内未支付的订单的状态为：已取消-2
	 * @param order
	 */
	void updatePaywayStatus(@Param("order") PyBigGoodsorder order) ;
}
