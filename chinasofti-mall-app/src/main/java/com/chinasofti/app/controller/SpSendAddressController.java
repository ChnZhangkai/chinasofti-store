package com.chinasofti.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.app.feign.SpSendAddressFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:04时48分26秒
 *
 */

@RestController
@RequestMapping("/address")
public class SpSendAddressController {
	
	@Autowired
	SpSendAddressFeignClient spSendAddressFeignClient;
	private static final Logger logger = LoggerFactory.getLogger(SpSendAddressController.class);
	
	/*
	 * 查询地址列表
	 * 参数 userId 用户ID
	 * */
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public ResponseInfo findSendAddressList(@RequestParam String userId,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		return spSendAddressFeignClient.findSendAddressList(userId);
	}
	
	 
	/*
	 * 增加收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	public ResponseInfo addSendAddress(@RequestBody SpSendAddress spSendAddress,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		return spSendAddressFeignClient.addSendAddress(spSendAddress);
	}
	
	/*
	 * 修改收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/updata" , method = RequestMethod.POST)
	public ResponseInfo updataSendAddress(@RequestBody SpSendAddress spSendAddress,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		return spSendAddressFeignClient.updataSendAddress(spSendAddress);
	}
	
	/*
	 * 删除收件地址
	 * 参数 userId,addressId
	 * */
	@RequestMapping(value="/delete" , method = RequestMethod.POST)
	public ResponseInfo deleteSendAddress(@RequestBody SpSendAddress spSendAddress,HttpServletResponse response){
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		return spSendAddressFeignClient.deleteSendAddress(spSendAddress);
	}
	
	
}
