package com.chinasofti.mall.goodsclass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.SpGoodsClass;
import com.chinasofti.mall.common.entity.SpGoodsClassExample;
import com.chinasofti.mall.goodsclass.mapper.SpGoodsClassMapper;
import com.chinasofti.mall.goodsclass.service.SpGoodsClassService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

/**
 * 分类Service层
 * @author Administrator
 *
 */
@Service
public class SpGoodsClassServiceImpl implements SpGoodsClassService{
	
	@Autowired
	private SpGoodsClassMapper spGoodsClassMapper;
	
	/* 
	 * 列表及提交查询
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String selectByExample(SpGoodsClass spGoodsClass) {
		
//		String compare = "";
		
		JSONObject js = new JSONObject();
		SpGoodsClassExample example = new SpGoodsClassExample();
//		Criteria criteria = example.createCriteria();
				
//		if ((goodscategory.getName()) != null && !(goodscategory.getName()).equals(compare)) {
//				criteria.andNameLike("%" + goodscategory.getName() + "%");
//			}
//		if ((goodscategory.getTitle()) != null && !(goodscategory.getTitle().equals(compare))) {
//				criteria.andTitleLike("%" + goodscategory.getTitle() + "%");
//		}

		PageHelper.startPage(spGoodsClass.getPageNumber(),spGoodsClass.getPageSize());
		List<SpGoodsClass> list = spGoodsClassMapper.selectByExample(example);
		
		js.put("rows", list);
		js.put("total", ((Page)list).getTotal());
		
		return js.toString();
	}

	/* 
	 * 保存添加
	 */
	@Override
	public int save(SpGoodsClass spGoodsClass) {
		return spGoodsClassMapper.insertSelective(spGoodsClass);
	}
	
	/* 
	 * 根据ID查询
	 */
	@Override
	public SpGoodsClass selectById(String ids) {
		return spGoodsClassMapper.selectByPrimaryKey(ids);
	}

	/* 
	 * 修改
	 */
	@Override
	public int updateByExample(SpGoodsClass spGoodsClass) {
		return spGoodsClassMapper.updateByPrimaryKeySelective(spGoodsClass);
	}

	/* 
	 * 根据ID删除
	 */
	@Override
	public int deleteById(String ids) {
		return spGoodsClassMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public List<SpGoodsClass> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpGoodsClass findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(SpGoodsClass t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
