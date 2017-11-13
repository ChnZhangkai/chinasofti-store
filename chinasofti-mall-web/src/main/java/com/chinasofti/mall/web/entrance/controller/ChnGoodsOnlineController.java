package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsFeignClient;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodsOnline")
public class ChnGoodsOnlineController {
	
	@Autowired
	ChnGoodsFeignClient chnGoodsFeignClient;
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goodsonline");
	}
	
	
	/**
	 * 列表及条件查询
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByGoodsOnline(ChnGoodsOnline chnGoodsOnline){
		System.out.println("goodsOnline!!!!!!");
		JSONObject jsonlist = chnGoodsFeignClient.selectByGoodsOnline(chnGoodsOnline);
		return jsonlist.toString();
	}
	
}
