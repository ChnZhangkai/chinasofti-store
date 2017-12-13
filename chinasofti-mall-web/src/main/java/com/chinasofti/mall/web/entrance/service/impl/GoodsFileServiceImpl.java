package com.chinasofti.mall.web.entrance.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.GoodsFile;
import com.chinasofti.mall.web.entrance.mapper.GoodsFileMapper;
import com.chinasofti.mall.web.entrance.service.GoodsFileService;

/**
 * 商品相关图片处理
 * @author Administrator
 *
 */
@Service
public class GoodsFileServiceImpl implements GoodsFileService{
	
	@Autowired
	GoodsFileMapper goodsFileMapper;
	
	@Override
	public int insert(GoodsFile goodsFile) {
		return goodsFileMapper.insert(goodsFile);
	}

	@Override
	public GoodsFile selectByPrimaryKey(String ids) {
		return goodsFileMapper.selectByPrimaryKey(ids);
	}

	@Override
	public int updateByPrimaryKeySelective(GoodsFile goodsFile) {
		return goodsFileMapper.updateByPrimaryKeySelective(goodsFile);
	}

	@Override
	public int deleteByPrimaryKey(String ids) {
		return goodsFileMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int deleteByGoodsIds(String ids) {
		return goodsFileMapper.deleteByGoodsIds(ids);
	}

	@Override
	public GoodsFile selectByGoodsIds(String ids) {
		return goodsFileMapper.selectByGoodsIds(ids);
	}

	

}
