package com.chinasofti.mall.goods.mapper;

import com.chinasofti.mall.common.entity.SpGoodsOptionSku;

public interface SpGoodsOptionSkuMapper {
    int deleteByPrimaryKey(String ids);

    int insert(SpGoodsOptionSku record);

    int insertSelective(SpGoodsOptionSku record);

    SpGoodsOptionSku selectByPrimaryKey(String ids);

    int updateByPrimaryKeySelective(SpGoodsOptionSku record);

    int updateByPrimaryKey(SpGoodsOptionSku record);
}