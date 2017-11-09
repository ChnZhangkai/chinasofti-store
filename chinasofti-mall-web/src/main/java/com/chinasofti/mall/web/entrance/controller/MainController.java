package com.chinasofti.mall.web.entrance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 访问主界面
 * @author Administrator
 *
 */
@RestController
public class MainController {
	
	@RequestMapping("/main")
	public ModelAndView toMain(){
		return new ModelAndView("main");
	}
	
}
