package com.chinasofti.mall.goodsclass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.ChnGoodsClass;
import com.chinasofti.mall.common.entity.ChnGoodsClassExample;
import com.chinasofti.mall.common.entity.ChnGoodsClassExample.Criteria;
import com.chinasofti.mall.goodsclass.mapper.ChnGoodsClassMapper;
import com.chinasofti.mall.goodsclass.service.ChnGoodsClassService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;

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
		
		String compare = "";
		
		JSONObject js = new JSONObject();
		ChnGoodsClassExample example = new ChnGoodsClassExample();
		Criteria criteria = example.createCriteria();
				
		if ((chnGoodsClass.getName()) != null && !(chnGoodsClass.getName()).equals(compare)) {
				criteria.andNameLike("%" + chnGoodsClass.getName() + "%");
			}
		if ((chnGoodsClass.getCommons()) != null && !(chnGoodsClass.getCommons().equals(compare))) {
				criteria.andCommonsLike("%" + chnGoodsClass.getCommons() + "%");
		}

		PageHelper.startPage(chnGoodsClass.getPageNumber(),chnGoodsClass.getPageSize());
		List<ChnGoodsClass> list = chnGoodsClassMapper.selectByExample(example);
		Gson gson = new Gson();
		
		String json = gson.toJson(list);
		js.put("rows", list);
		js.put("total", ((Page)list).getTotal());
		
//		return list;
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
