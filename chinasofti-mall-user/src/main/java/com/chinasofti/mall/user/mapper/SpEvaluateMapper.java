package com.chinasofti.mall.user.mapper;

import java.util.List;

import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;


public interface SpEvaluateMapper {
	
	List<SpGoodsEvaluate> selectEvaluateList(SpGoodsEvaluate spGoodsEvaluate)throws Exception;
	
	List<SpGoodsEvaluate> selectNonEvaluateList(SpGoodsEvaluate spGoodsEvaluate)throws Exception;
	
	List<SpGoodsEvaluate> selectEvaluateAllList(SpGoodsEvaluate spGoodsEvaluate)throws Exception;
	
	int insertSelective(SpGoodsEvaluate SpGoodsEvaluate)throws Exception;

	int updateIsEvaluate(String transactionid)throws Exception;
}
