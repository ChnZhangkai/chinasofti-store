package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsClassFeignClient;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodscheck")
public class ChnGoodsCheckController {
	
	@Autowired
	ChnGoodsClassFeignClient chnGoodsClassFeignClient;
	
	@Autowired
	
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goodscheck");
	}
	
	/**
	 * 商品添加页面查询商品分类
	 * @return
	 */
	@RequestMapping("/reqGoodsClassName")
	public String reqGoodsClassName(){
		
		ChnGoodsClass chnGoodsClass = new ChnGoodsClass();
		JSONObject goodsClass = chnGoodsClassFeignClient.selectByGoodsClass(chnGoodsClass);
		
		return goodsClass.toString();
		
	}
	
	@RequestMapping("/reqSpUserName")
	public String reqSpUserName(){
		
		
		return "";
	}
	
	
	
}
