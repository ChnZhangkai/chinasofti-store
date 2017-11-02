package com.chinasofti.mall.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.user.service.impl.PtHrUserServiceImpl;

@RestController
@RequestMapping("/user")
public class PtHrUserController {

	@Autowired
	private PtHrUserServiceImpl ptHrUserService;
	
	@RequestMapping("/select")
	public List<PtHrUserBak> SelectByPtHrUserBaks(PtHrUserBak ptHrUserBak){
		return ptHrUserService.selectByExample(ptHrUserBak);		
	}
}
