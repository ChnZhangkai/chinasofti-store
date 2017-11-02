package com.chinasofti.mall.goodscategory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "/select" , method = RequestMethod.POST)
	public List<Goodscategory> selectByGoodsCategory(@RequestBody(required = false)Goodscategory goodscategory){
		
		return goodsCategoryService.selectByExample(goodscategory);
		
	}

}
