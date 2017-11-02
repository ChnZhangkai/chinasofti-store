package com.chinasofti.mall.goodscategory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.goodscategory.service.impl.GoodsCategoryServiceImpl;

@RestController
@RequestMapping("/goods")
public class GoodsCategoryController {
	
	@Autowired
	private GoodsCategoryServiceImpl goodsCategoryService;
	
	/**
	 * 列表及条件查询
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/select" , method = RequestMethod.POST)
	public String selectByGoodsCategory(@RequestBody(required = false)Goodscategory goodscategory){
		
		return goodsCategoryService.selectByExample(goodscategory);
		
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/select/{ids}")
	public Goodscategory selectGoodsCategory(@PathVariable Integer ids){
		
		return goodsCategoryService.selectById(ids);
		
	}
	
	/**
	 * 根据ID删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/delete/{ids}" ,method = RequestMethod.POST)
	public int deleteGoodsCategoryById(@PathVariable Integer ids){
		return goodsCategoryService.deleteById(ids);
	}
}
