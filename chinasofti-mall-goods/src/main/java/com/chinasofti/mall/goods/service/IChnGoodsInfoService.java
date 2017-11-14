package com.chinasofti.mall.goods.service;


import com.chinasofti.mall.common.utils.ResponseInfo;

public interface IChnGoodsInfoService{
	
	  /**
     * 根据分类Id查询商品信息
     * @param goodsClassId
     * @return
     */
   public ResponseInfo selectByClassId(String goodsClassIds);
   
   public ResponseInfo selectByGoodsId(String ids);

}
