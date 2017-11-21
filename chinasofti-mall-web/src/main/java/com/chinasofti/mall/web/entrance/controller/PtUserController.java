package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.web.entrance.feign.PtUserFeignClient;

import net.sf.json.JSONObject;



@RestController
@RequestMapping("/user")
public class PtUserController {

	@Autowired
	private PtUserFeignClient ptUserFeignClient;
	
	@RequestMapping("/user")
	public ModelAndView toUser() {
		return new ModelAndView("/user/user");
	}
	
	/**
	* @Title: selectByPrimaryKey
	* @Description: 通过主键查询
	* @param ids
	* @return 
	* @throws
	*/
	@RequestMapping("select/{ids}")
	public PtUser selectByPrimaryKey(@PathVariable String ids){
		
		return ptUserFeignClient.findById(ids);
		
	}
	
	/**
	* @Title: selectAll
	* @Description: 条件查询
	* @param 
	* @return 
	* @throws
	*/
	@RequestMapping("/list")
	public String selectByPtUser(PtUser ptUser){
		JSONObject jsonlist = ptUserFeignClient.selectByPtUser(ptUser);
		System.out.println(jsonlist.toString());
		return jsonlist.toString();
	}
	
	
	/**
	* @Title: 
	* @Description: 
	* @param 
	* @return  String
	* @throws
	*/
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String AddPtuser(PtUser ptUser) {
		return ptUserFeignClient.add(ptUser);
	}

	/**
	* @Title: 
	* @Description: 
	* @param ids
	* @return String
	* @throws
	*/
	@RequestMapping(value = "delete/{ids}")
	public String DeleteById(@PathVariable String ids) {

		return ptUserFeignClient.deleteById(ids);

	}
	
	
	/**
	* @Title: 修改用户
	* @Description: 更改
	* @param 
	* @return String
	* @throws
	*/
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String Update(PtUser ptUser) {

		return ptUserFeignClient.update(ptUser);

	}
}