package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.web.entrance.feign.PtHrUserFeignClient;

@RestController
@RequestMapping("/user")
public class PtHrUserController {

	@Autowired
	private PtHrUserFeignClient ptHrUserFeignClient;
	
	@RequestMapping("/user")
	public ModelAndView toUser() {
		return new ModelAndView("/user/user");
	}
	
	@RequestMapping("/list")
	public String selectByUser(PtHrUserBak ptHrUserBak) {
		String jsonList=ptHrUserFeignClient.selectByUser(ptHrUserBak);
		return jsonList;
	}
}
