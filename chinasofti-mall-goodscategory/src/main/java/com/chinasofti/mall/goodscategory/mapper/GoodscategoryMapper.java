package com.chinasofti.mall.goodscategory.mapper;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.common.entity.GoodscategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GoodscategoryMapper {
    int countByExample(GoodscategoryExample example);

    int deleteByExample(GoodscategoryExample example);

    int deleteByPrimaryKey(Integer ids);

    int insert(Goodscategory record);

    int insertSelective(Goodscategory record);

    List<Goodscategory> selectByExample(GoodscategoryExample example);

    Goodscategory selectByPrimaryKey(Integer ids);

    int updateByExampleSelective(@Param("record") Goodscategory record, @Param("example") GoodscategoryExample example);

    int updateByExample(@Param("record") Goodscategory record, @Param("example") GoodscategoryExample example);

    int updateByPrimaryKeySelective(Goodscategory record);

    int updateByPrimaryKey(Goodscategory record);
}