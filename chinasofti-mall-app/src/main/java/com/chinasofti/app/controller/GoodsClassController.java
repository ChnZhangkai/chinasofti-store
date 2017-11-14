package com.chinasofti.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.feign.GoodsClassFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.utils.ResponseInfo;

@Controller
@RequestMapping("goodsClass")
public class GoodsClassController {
	
	@Autowired
	private GoodsClassFeignClient goodsFeignClient;
	
	/**
	 * 当classId不为空时查询二级列表，为空时则查询一级分类
	 * @param classId(ids)
	 * @return
	 */
	@RequestMapping("queryClass")
	public ResponseInfo queryClass(@RequestParam String classId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return goodsFeignClient.queryClass(classId);
	}

}
