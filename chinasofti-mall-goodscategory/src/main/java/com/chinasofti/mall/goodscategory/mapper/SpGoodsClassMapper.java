package com.chinasofti.mall.goodscategory.mapper;

import com.chinasofti.mall.common.entity.SpGoodsClass;
import com.chinasofti.mall.common.entity.SpGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpGoodsClassMapper {
    int countByExample(SpGoodsClassExample example);

    int deleteByExample(SpGoodsClassExample example);

    int deleteByPrimaryKey(String ids);

    int insert(SpGoodsClass record);

    int insertSelective(SpGoodsClass record);

    List<SpGoodsClass> selectByExample(SpGoodsClassExample example);

    SpGoodsClass selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") SpGoodsClass record, @Param("example") SpGoodsClassExample example);

    int updateByExample(@Param("record") SpGoodsClass record, @Param("example") SpGoodsClassExample example);

    int updateByPrimaryKeySelective(SpGoodsClass record);

    int updateByPrimaryKey(SpGoodsClass record);
}