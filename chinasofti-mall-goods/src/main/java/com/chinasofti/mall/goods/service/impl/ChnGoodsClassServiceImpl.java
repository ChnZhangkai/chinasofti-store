package com.chinasofti.mall.goods.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClassExample;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClassExample.Criteria;
import com.chinasofti.mall.goods.mapper.ChnGoodsClassMapper;
import com.chinasofti.mall.goods.service.ChnGoodsClassService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

/**
 * 分类Service层
 * @author Administrator
 *
 */
@Service
public class ChnGoodsClassServiceImpl implements ChnGoodsClassService{
	
	@Autowired
	private ChnGoodsClassMapper chnGoodsClassMapper;
	
	/* 
	 * 列表及提交查询
	 */
	@Override
	public JSONObject selectByExample(ChnGoodsClass chnGoodsClass) {
		
		JSONObject js = new JSONObject();
		ChnGoodsClassExample example = new ChnGoodsClassExample();
		Criteria criteria = example.createCriteria();
		
		
		
		if (!StringUtils.isEmpty(chnGoodsClass.getName())) {
				criteria.andNameLike("%" + chnGoodsClass.getName() + "%");
			}
		if (!StringUtils.isEmpty(chnGoodsClass.getCommons())) {
				criteria.andCommonsLike("%" + chnGoodsClass.getCommons() + "%");
		}
		if (!StringUtils.isEmpty(chnGoodsClass.getCreateBy())) {
			criteria.andCreateByLike("%" + chnGoodsClass.getCreateBy() + "%");
		}
		if (!StringUtils.isEmpty(chnGoodsClass.getStates())) {
			criteria.andStatesEqualTo(chnGoodsClass.getStates());
		}

		PageHelper.startPage(chnGoodsClass.getPageNumber(),chnGoodsClass.getPageSize());
		List<ChnGoodsClass> list = chnGoodsClassMapper.selectByExample(example);

		js.put("rows", list);
		js.put("total", ((Page<ChnGoodsClass>)list).getTotal());
		
		return js;
	}

	/* 
	 * 保存添加
	 */
	@Override
	public int save(ChnGoodsClass chnGoodsClass) {
		return chnGoodsClassMapper.insertSelective(chnGoodsClass);
	}

	/* 
	 * 修改
	 */
	@Override
	public int update(ChnGoodsClass chnGoodsClass) {
		return chnGoodsClassMapper.updateByPrimaryKeySelective(chnGoodsClass);
	}

	/* 
	 * 根据ID删除
	 */
	@Override
	public int deleteById(String ids) {
		return chnGoodsClassMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public ChnGoodsClass findById(String ids) {
		return chnGoodsClassMapper.selectByPrimaryKey(ids);
	}

	@Override
	public List<ChnGoodsClass> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
