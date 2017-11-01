package com.chinasofti.mall.web.entrance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/goods")
public class GoodsController {
	
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goods");
	}
	
	
}
