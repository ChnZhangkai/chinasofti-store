package com.chinasofti.mall.user.controller;


import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
	@RequestMapping(value = "/list" , method = RequestMethod.POST)
	public JSONObject selectByGoodsClass(@RequestBody(required = false)SpMerchantUser spMerchantUser){
		return spUserService.selectByExample(spMerchantUser);
		
	}
	
	/**
	 * 
	 * @Title: findByPage
	 * @Description: 分页查询
	 * @param map
	 * @return: String
	 * @throws:
	 */
	@RequestMapping("/findByPage")
	public Map<String, Object> findByPage(@RequestParam Map<String, Object> map) {
		return spUserService.findByPage(map);
		
	}
	
	@RequestMapping("/queryVendorInfo")
	public SpMerchantUser findById(@RequestParam("vendorId") String vendorId) {
		
		return spUserService.findById(vendorId);
	}
	
	
	@RequestMapping("delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) {
		spUserService.deleteById(id);
		return "delete";
	}

	@RequestMapping(value="update" , method = RequestMethod.POST)
	public int update(@RequestBody(required=false) SpMerchantUser spMerchantUser) {
		return spUserService.update(spMerchantUser);
		
	}

	@RequestMapping(value="add" , method = RequestMethod.POST)
	public int add(@RequestBody(required=false) SpMerchantUser spMerchantUser) {
		return spUserService.save(spMerchantUser);
		
	}
	

}
