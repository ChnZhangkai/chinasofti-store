package com.chinasofti.mall.goods.service;


import java.util.List;

import com.chinasofti.mall.common.entity.goods.ChnGoodsInfoVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.SkuGoodsVo;


public interface IChnGoodsInfoService{
	
	  /**
     * 根据分类Id查询商品信息
     * @param goodsClassId
     * @return
     */
   public List<ChnGoodsinfo> selectByClassId(String goodsClassIds);
   
   public ChnGoodsInfoVo selectByGoodsId(String ids);
   /**
    * 根据关键字title查询商品列表
    * @param record
    * @return
    */
   public List<ChnGoodsinfo> selectByNameOrother(ChnGoodsinfo record);
   
   /**
    * 根据商品Id查询商品信息
    * @param ids
    * @return
    */
   public ChnGoodsinfo checkGoodsInfoById(String ids);
   
   
   /**
    
   * @Title: findSkuByGoodsIds
   * @Description: 查询sku商品信息
   * @param  ids
   * @return SkuGoodsVo
   * @throws
    */
   List<SkuGoodsVo> findSkuByGoodsIds(String ids);

}
