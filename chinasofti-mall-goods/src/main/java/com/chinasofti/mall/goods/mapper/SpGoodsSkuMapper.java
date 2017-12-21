package com.chinasofti.mall.goods.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.goods.AttrVo;
import com.chinasofti.mall.common.entity.goods.SkuGoodsVo;

public interface SpGoodsSkuMapper {
  
	List<SkuGoodsVo> findSkuByGoodsIds(@Param("ids") String ids);
	
	 AttrVo findSkuByOptionIds(String ids);
	 
}