package com.chinasofti.mall.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.goods.mapper.GoodsPrefectureMapper;
import com.chinasofti.mall.goods.service.IPrefectureService;
/**
 * 专区service实现类
 * @author chen
 *
 */
@Service
public class PrefectureServiceImpl implements IPrefectureService{

	@Autowired
	private GoodsPrefectureMapper goodsPrefectureMapper;
	/**
	 * 查询所有专区
	 */
	@Override
	public List<GoodsPrefecture> findAll() {
		List<GoodsPrefecture> list = goodsPrefectureMapper.findAll();
		return list;
	}

	/**
	 * 添加专区
	 */
	@Override
	public int savePrefecture(GoodsPrefecture goodsPrefecture) {
		return goodsPrefectureMapper.insert(goodsPrefecture);
	}

	/**
	 * 修改专区
	 */
	@Override
	public int updateById(GoodsPrefecture goodsPrefecture) {
		return goodsPrefectureMapper.updateByPrimaryKey(goodsPrefecture);
	}

	/**
	 * 删除专区
	 */
	@Override
	public int deleteById(String ids) {
		return goodsPrefectureMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public List<GoodsPrefecture> findById(String ids) {
		return goodsPrefectureMapper.selectByPrimaryKey(ids);
	}

	@Override
	public List<ChnGoodsOnline> findGoodsById(String ids) {
		List<ChnGoodsOnline> findGoodsById = goodsPrefectureMapper.findGoodsById(ids);
		return findGoodsById;
	}

	@Override
	public int deleteGoods(String goodsids) {
		return goodsPrefectureMapper.deleteGoods(goodsids);
	}

}
