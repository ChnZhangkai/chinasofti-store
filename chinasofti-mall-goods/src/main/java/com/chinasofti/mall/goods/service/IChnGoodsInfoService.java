package com.chinasofti.mall.goods.service;

import java.util.List;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;

public interface IChnGoodsInfoService{
	
	  /**
     * 根据分类Id查询商品信息
     * @param goodsClassId
     * @return
     */
   public List<ChnGoodsinfo> selectByClassId(String goodsClassIds);
   
   public ChnGoodsinfo selectByGoodsId(String ids);

}
