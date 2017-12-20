package com.chinasofti.mall.goods.mapper;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.goods.SkuGoodsVo;

public interface SpGoodsSkuMapper {
  
	SkuGoodsVo findSkuByGoodsIds(@Param("ids") String ids);
}