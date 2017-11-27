package com.chinasofti.app.controller;


import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.GoodsClassFeignClient;
import com.chinasofti.mall.common.utils.ResponseInfo;
/**
 * 主要查询商品分类的通用接口（一二级分类）
 * @author gezhenlin
 * @Date: 2017年11月15日 上午10:38:45
 */
@RestController
@RequestMapping("goodsClass")
public class GoodsClassController {
	
	@Autowired
	private GoodsClassFeignClient goodsFeignClient;
	
	private static final Logger logger = LoggerFactory.getLogger(GoodsClassController.class);
	/**
	 * 当classId不为空时查询二级列表，为空时则查询一级分类
	 * @param classId(ids)
	 * @return
	 */
	@RequestMapping("queryClass")
	public ResponseInfo queryClass(@RequestParam(defaultValue ="000000") String classId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		logger.info(classId);
		return goodsFeignClient.queryClass(classId);
	}

}
