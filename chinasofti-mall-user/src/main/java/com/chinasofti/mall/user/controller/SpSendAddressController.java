package com.chinasofti.mall.user.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.user.handler.MyException;
import com.chinasofti.mall.user.service.SpSendAddressService;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:04时48分26秒
 *
 */

@RestController
@RequestMapping("/address")
public class SpSendAddressController {
	
	@Autowired
	SpSendAddressService spSendAddressService;
	private static final Logger logger = LoggerFactory.getLogger(SpSendAddressController.class);
	
	
	
	/*
	 * 查询地址列表
	 * 参数 userId 用户ID
	 * */
	@RequestMapping(value="/list")
	public ResponseInfo findSendAddressList(@RequestParam("userId") String userId) {
		return spSendAddressService.querySentAddressList(userId);
	} 
	
	/*
	 * 增加收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/add")
	public ResponseInfo addSendAddress(@RequestBody SpSendAddress spSendAddress){
		return spSendAddressService.insertSendAddress(spSendAddress);
		
	}
	
	/*
	 * 修改收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/updata")
	public ResponseInfo updataSendAddress(@RequestBody SpSendAddress spSendAddress){
		return spSendAddressService.updateSendAddress(spSendAddress);
	}
	
	/*
	 * 删除收件地址
	 * 参数 userId,addressId
	 * */
	@RequestMapping(value="/delete")
	public ResponseInfo deleteSendAddress(@RequestBody SpSendAddress spSendAddress){
		return spSendAddressService.deleteSendAddress(spSendAddress);
	}	
	
}
