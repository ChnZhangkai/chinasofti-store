package com.chinasofti.mall.goodscategory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.common.entity.GoodscategoryExample;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.goodscategory.service.GoodsCategoryService;

@RestController
@RequestMapping("goods")
public class GoodsCategoryController extends BaseController<Goodscategory>{
	
	@Autowired
	private GoodsCategoryService goodsCategoryService;
	
	@Override
	public IBaseService<Goodscategory> getService() {
		
		return goodsCategoryService;
	}
	
	@RequestMapping("/select")
	public List<Goodscategory> selectGoodscategoryByExample(Goodscategory goodscategory){
		
		return goodsCategoryService.selectByExample(new GoodscategoryExample());
		
	}

}
