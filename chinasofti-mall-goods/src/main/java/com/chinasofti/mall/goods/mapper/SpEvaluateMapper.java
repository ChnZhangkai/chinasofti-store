package com.chinasofti.mall.goods.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.goods.SpEvaluate;
import com.chinasofti.mall.common.entity.goods.SpEvaluateExample;

public interface SpEvaluateMapper {
    int countByExample(SpEvaluateExample example);

    int deleteByExample(SpEvaluateExample example);

    int deleteByPrimaryKey(String ids);

    int insert(SpEvaluate record);

    int insertSelective(SpEvaluate record);

    List<SpEvaluate> selectByExample(SpEvaluateExample example);

    SpEvaluate selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") SpEvaluate record, @Param("example") SpEvaluateExample example);

    int updateByExample(@Param("record") SpEvaluate record, @Param("example") SpEvaluateExample example);

    int updateByPrimaryKeySelective(SpEvaluate record);

    int updateByPrimaryKey(SpEvaluate record);

	List<SpEvaluate> findByPage(Map<String, Object> map);

	int batchDeletes(List<String> delList);

}