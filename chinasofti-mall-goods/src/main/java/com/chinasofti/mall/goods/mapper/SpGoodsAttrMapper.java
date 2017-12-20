package com.chinasofti.mall.goods.mapper;

import com.chinasofti.mall.common.entity.SpGoodsAttr;

public interface SpGoodsAttrMapper {
    int deleteByPrimaryKey(String ids);

    int insert(SpGoodsAttr record);

    int insertSelective(SpGoodsAttr record);

    SpGoodsAttr selectByPrimaryKey(String ids);

    int updateByPrimaryKeySelective(SpGoodsAttr record);

    int updateByPrimaryKey(SpGoodsAttr record);
}