package com.chinasofti.mall.goodsclass.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.ChnGoodsClass;
import com.chinasofti.mall.common.entity.ChnGoodsClassExample;
import com.chinasofti.mall.goodsclass.mapper.ChnGoodsClassMapper;
import com.chinasofti.mall.goodsclass.service.SpGoodsClassService;
import com.google.gson.Gson;

/**
 * 分类Service层
 * @author Administrator
 *
 */
@Service
public class SpGoodsClassServiceImpl implements SpGoodsClassService{
	
	@Autowired
	private ChnGoodsClassMapper chnGoodsClassMapper;
	
	/* 
	 * 列表及提交查询
	 */
	@Override
	public String selectByExample(ChnGoodsClass chnGoodsClass) {
		
//		String compare = "";
		
//		JSONObject js = new JSONObject();
		ChnGoodsClassExample example = new ChnGoodsClassExample();
//		Criteria criteria = example.createCriteria();
				
//		if ((goodscategory.getName()) != null && !(goodscategory.getName()).equals(compare)) {
//				criteria.andNameLike("%" + goodscategory.getName() + "%");
//			}
//		if ((goodscategory.getTitle()) != null && !(goodscategory.getTitle().equals(compare))) {
//				criteria.andTitleLike("%" + goodscategory.getTitle() + "%");
//		}

//		PageHelper.startPage(spGoodsClass.getPageNumber(),spGoodsClass.getPageSize());
		List<ChnGoodsClass> list = chnGoodsClassMapper.selectByExample(example);
		Gson gson = new Gson();
		String json = gson.toJson(list);
//		js.put("rows", list);
//		js.put("total", ((Page)list).getTotal());
		
		return json;
//		return js.toString();
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
