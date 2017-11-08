package com.chinasofti.mall.goodsclass.mapper;

import com.chinasofti.mall.common.entity.ChnGoodsClass;
import com.chinasofti.mall.common.entity.ChnGoodsClassExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChnGoodsClassMapper {
    int countByExample(ChnGoodsClassExample example);

    int deleteByExample(ChnGoodsClassExample example);

    int deleteByPrimaryKey(String ids);

    int insert(ChnGoodsClass record);

    int insertSelective(ChnGoodsClass record);

    List<ChnGoodsClass> selectByExample(ChnGoodsClassExample example);

    ChnGoodsClass selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") ChnGoodsClass record, @Param("example") ChnGoodsClassExample example);

    int updateByExample(@Param("record") ChnGoodsClass record, @Param("example") ChnGoodsClassExample example);

    int updateByPrimaryKeySelective(ChnGoodsClass record);

    int updateByPrimaryKey(ChnGoodsClass record);
}