package com.chinasofti.mall.web.entrance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.web.entrance.feign.GoodsCategoryFeignClient;

@RestController
@RequestMapping("/goods")
public class GoodsCategoryController {
	
	@Autowired
	private GoodsCategoryFeignClient goodsCategoryFeignClient;
	
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goods");
	}
	
	@RequestMapping("/list")
	public List<Goodscategory> selectByGoodsCategory(Goodscategory goodscategory){
		return goodsCategoryFeignClient.selectByGoodsCategory(goodscategory);
	}
	
}
