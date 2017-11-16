package com.chinasofti.app.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
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
	@RequestMapping(value="/liResponseInfost")
	@ResponseBody
	public ResponseInfo findSendAddressList(@RequestParam String userId) {
		return spSendAddressFeignClient.findSendAddressList(userId);
	}
	
	/*
	 * 增加收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	public ResponseInfo addSendAddress(@RequestBody SpSendAddress spSendAddress){
		
		return spSendAddressFeignClient.addSendAddress(spSendAddress);
	}
	
	/*
	 * 修改收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/updata" , method = RequestMethod.POST)
	public ResponseInfo updataSendAddress(@RequestBody SpSendAddress spSendAddress){
		return spSendAddressFeignClient.updataSendAddress(spSendAddress);
	}
	
	/*
	 * 删除收件地址
	 * 参数 userId,addressId
	 * */
	@RequestMapping(value="/delete" , method = RequestMethod.POST)
	public ResponseInfo deleteSendAddress(@RequestBody SpSendAddress spSendAddress){
		return spSendAddressFeignClient.deleteSendAddress(spSendAddress);
	}
	
	
}
