package com.chinasofti.mall.goods.service;

import java.util.List;

import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;

public interface IPrefectureService{

	/**
	 * 查询所有专区
	 */
	public List<GoodsPrefecture> findAll();
	/**
	 * 根据id查询专区
	 */
	public List<GoodsPrefecture> findById(String ids);
	/**
	 * 根据专区ids查询所属商品
	 */
	public List<ChnGoodsOnline> findGoodsById(String ids);
	/**
	 * 根据商品goodsids删除商品
	 */
	public int deleteGoods(String goodsids);
	/**
	 * 增加专区
	 */
	public int savePrefecture(GoodsPrefecture goodsPrefecture);
	/**
	 * 修改专区
	 */
	public int updateById(GoodsPrefecture goodsPrefecture);
	/**
	 * 删除专区
	 */
	public int deleteById(String ids);
}
