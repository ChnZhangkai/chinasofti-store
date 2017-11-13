package com.chinasofti.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.feign.GoodsClassFeignClient;
import com.chinasofti.app.feign.GoodsFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;

@Controller
@RequestMapping("goodsInfo")
public class GoodsController {
	
	@Autowired
	private GoodsFeignClient goodsFeignClient;
	
	/**
	 * 当classId不为空时查询二级列表，为空时则查询一级分类
	 * @param classId(ids)
	 * @return
	 */
	@RequestMapping("queryGoodList")
	public List<ChnGoodsinfo>queryGoodList(@RequestParam String id,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return goodsFeignClient.queryGoodList(id);
	}
	@RequestMapping("queryGoodsInfo")
	public ChnGoodsinfo queryGoodsInfo(@RequestParam String ids,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return goodsFeignClient.queryGoodInfo(ids);
	}
}
