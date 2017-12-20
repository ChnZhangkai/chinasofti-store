package com.chinasofti.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.SpMerchantUserFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;


@RestController
@RequestMapping("spUser")
public class SpMerchantUserController {

	@Autowired
	private SpMerchantUserFeignClient spMerchantUserFeignClient;
	
	
	/*
	 * 根据Ids查询商户
	 * */
	@RequestMapping("queryVendorInfo")
	public SpMerchantUser queryVendorInfo(@RequestParam String vendorId,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		return spMerchantUserFeignClient.queryVendorInfo(vendorId);
	}
}
