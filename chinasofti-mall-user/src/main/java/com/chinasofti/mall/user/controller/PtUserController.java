package com.chinasofti.mall.user.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUser;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUserExample;
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
	
	/**
	 * 查询用户当前角色名称
	 * @return
	 */
	@RequestMapping("/findRoleName/{ids}")
	public String findUserRoleName(@PathVariable("ids") String ids){
		PtRole ptRole = ptUserService.selectUserRoleName(ids);
		return ptRole.getNames();
	}
	
	@RequestMapping("/findByUserName")
	public String findByUserName(@RequestBody(required = false) String username){
		String ptUser = ptUserService.selectByUserName(username);
		if (ptUser != null) {
			return "1";
		}
		return "0";
	}
	
	/**
	 * 修改用户角色
	 * @param ptRoleUser
	 * @return
	 */
	@RequestMapping("/updateRoleUser")
	public int updateRoleUser(@RequestBody(required=false) PtRoleUser ptRoleUser){
		return ptUserService.updateByExampleSelective(ptRoleUser, new PtRoleUserExample());
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
