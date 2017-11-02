package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.web.entrance.feign.GoodsCategoryFeignClient;

/**
 * 商品分类服务消费
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsCategoryController {
	
	@Autowired
	private GoodsCategoryFeignClient goodsCategoryFeignClient;
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goods");
	}
	
	/**
	 * 列表及条件查询
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByGoodsCategory(Goodscategory goodscategory){
		
		String jsonlist = goodsCategoryFeignClient.selectByGoodsCategory(goodscategory);
		return jsonlist;
		
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/select/{ids}")
	public Goodscategory selectByGoodsCategoryId(@PathVariable Integer ids){
		Goodscategory goodscategory = goodsCategoryFeignClient.selectById(ids);
		return goodscategory;
	}
	
	/**
	 * 根据ID删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete/{ids}")
	public int deleteGoodsCategoryById(@PathVariable Integer ids){
		int delById = goodsCategoryFeignClient.deleteGoodsCategory(ids);
		return delById;
	}
	
	
}
