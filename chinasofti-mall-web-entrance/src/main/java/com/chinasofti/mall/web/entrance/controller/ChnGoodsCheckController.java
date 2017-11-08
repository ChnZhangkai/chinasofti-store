package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsClassFeignClient;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodscheck")
public class ChnGoodsCheckController {
	
	@Autowired
	ChnGoodsClassFeignClient chnGoodsClassFeignClient;
	
	@Autowired
	SpMerchantUserFeignClient spMerchantUserFeignClient;
	
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
		
		SpMerchantUser spMerchantUser = new SpMerchantUser();
		JSONObject spUser = spMerchantUserFeignClient.selectBySpUser(spMerchantUser);
		
		return spUser.toString();
	}
	
	
	
}
