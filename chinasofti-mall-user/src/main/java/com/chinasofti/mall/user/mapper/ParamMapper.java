package com.chinasofti.mall.user.mapper;

import com.chinasofti.mall.common.entity.param.Param;
import com.chinasofti.mall.common.entity.param.ParamExample;
import java.util.List;

public interface ParamMapper {
    int countByExample(ParamExample example);

    int deleteByExample(ParamExample example);

    int insert(Param record);

    int insertSelective(Param record);

    List<Param> selectByExample(ParamExample example);
    
    List<Param> findAll(Param param);

    int updateByExampleSelective(Param record);

    int updateByExample(Param record);
}