package com.chinasofti.mall.web.entrance.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("advertise")
public class AdvertiseController {
	
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("/advertise/advertise");
	}
}
