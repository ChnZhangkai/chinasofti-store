package com.chinasofti.mall.web.entrance.mapper;

import com.chinasofti.mall.common.entity.LogOperator;
import com.chinasofti.mall.common.entity.LogOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LogOperatorMapper {
    int countByExample(LogOperatorExample example);

    int deleteByExample(LogOperatorExample example);

    int deleteByPrimaryKey(String ids);

    int insert(LogOperator record);

    int insertSelective(LogOperator record);

    List<LogOperator> selectByExample(LogOperatorExample example);
    
    List<LogOperator> selectByLogOperator(LogOperator logOperator);

    LogOperator selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") LogOperator record, @Param("example") LogOperatorExample example);

    int updateByExample(@Param("record") LogOperator record, @Param("example") LogOperatorExample example);

    int updateByPrimaryKeySelective(LogOperator record);

    int updateByPrimaryKey(LogOperator record);
}