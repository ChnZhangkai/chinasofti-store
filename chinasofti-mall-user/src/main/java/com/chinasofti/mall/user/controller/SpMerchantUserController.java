package com.chinasofti.mall.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.user.service.SpMerchantUserService;

import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserController.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:08:02
 * @parma <T>
 */
@RestController
@RequestMapping("/spUser")
public class SpMerchantUserController {
	@Autowired
	private SpMerchantUserService spUserService;
	
	/**
	 * 列表及条件查询
	 * @param spUser
	 * @return
	 */
	@RequestMapping(value = "/select" , method = RequestMethod.POST)
	public JSONObject selectByGoodsClass(@RequestBody(required = false)SpMerchantUser spMerchantUser){
		return spUserService.selectByExample(spMerchantUser);
		
	}
	
	@RequestMapping("select/{ids}")
	public SpMerchantUser findById(@PathVariable("ids") String id) {
		
		return spUserService.findById(id);
	}
	
	
	@RequestMapping("delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) {
		spUserService.deleteById(id);
		return "delete";
	}

	@RequestMapping(value="update" , method = RequestMethod.POST)
	public String update(@RequestBody(required=false) SpMerchantUser spMerchantUser) {
		spUserService.update(spMerchantUser);
		return "update";
	}

	@RequestMapping(value="add" , method = RequestMethod.POST)
	public String add(@RequestBody(required=false) SpMerchantUser spMerchantUser) {
		spUserService.save(spMerchantUser);
		return "add";
	}
}
