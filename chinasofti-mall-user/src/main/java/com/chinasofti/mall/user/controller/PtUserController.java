package com.chinasofti.mall.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.user.service.PtUserService;

import net.sf.json.JSONObject;


@RestController
@RequestMapping("/user")
public class PtUserController{

	@Autowired
	private PtUserService ptUserService; 
	


	@RequestMapping(value = "/list" , method = RequestMethod.POST)
	public JSONObject selectByPtUser(@RequestBody(required = false)PtUser ptUser){
		return ptUserService.selectByExample(ptUser);
		
	}
	
	@RequestMapping("select/{ids}")
	public PtUser findById(@PathVariable("ids") String id) {
		
		return ptUserService.findById(id);
	}
	
	
	@RequestMapping("delete/{ids}")
	public int deleteById(@PathVariable("ids") String id) {
		int deleteById = ptUserService.deleteById(id);
		return deleteById;
	}

	@RequestMapping(value="update" , method = RequestMethod.POST)
	public int update(@RequestBody(required=false) PtUser ptUser) {
		return ptUserService.update(ptUser);
		
	}

	@RequestMapping(value="add" , method = RequestMethod.POST)
	public int add(@RequestBody(required=false) PtUser ptUser) {
		return ptUserService.save(ptUser);
		
	}
	
}
