package com.chinasofti.mall.goods.mapper;

import com.chinasofti.mall.common.entity.SpGoodsAttrValue;

public interface SpGoodsAttrValueMapper {
    int deleteByPrimaryKey(String ids);

    int insert(SpGoodsAttrValue record);

    int insertSelective(SpGoodsAttrValue record);

    SpGoodsAttrValue selectByPrimaryKey(String ids);

    int updateByPrimaryKeySelective(SpGoodsAttrValue record);

    int updateByPrimaryKey(SpGoodsAttrValue record);
}