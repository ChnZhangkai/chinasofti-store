package com.chinasofti.mall.web.entrance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
/**
 * 
* @ClassName: GoodsController
* @Description: TODO(这里用一句话描述这个类的作用)
* @author xiaokunxiong
* @date 2017年11月1日 下午2:55:08 
*
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goods");
	}
	
	
}
