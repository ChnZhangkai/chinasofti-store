package com.chinasofti.mall.sp.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.SpUser;
import com.chinasofti.mall.sp.user.service.SpUserService;

/**
 * @ClassName: SpUserController.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:08:02
 * @parma <T>
 */
public class SpUserController {
	@Autowired
	private SpUserService spUserService;
	
	@RequestMapping(value = "/select" , method = RequestMethod.POST)
	public String selectBySpUser(@RequestBody(required = false)SpUser spUser){
		
		return spUserService.selectByExample(spUser);
		
	}
}
