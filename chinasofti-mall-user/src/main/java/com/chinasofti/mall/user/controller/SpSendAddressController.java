package com.chinasofti.mall.user.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
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
	public List<SpSendAddress> findSendAddressList(@RequestParam("userId") String userId) {
		List<SpSendAddress> list = new ArrayList<SpSendAddress>();
		try {
			list = spSendAddressService.querySentAddressList(userId);
		} catch (MyException e) {
			e.printStackTrace();
			logger.error(e.toString());
			return list;
		}
		return list;
	} 
	
	/*
	 * 增加收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/add")
	public int addSendAddress(@RequestBody SpSendAddress spSendAddress){
		int result=0;
		try{
			result = spSendAddressService.insertSendAddress(spSendAddress);
		} catch (MyException e) {
			logger.error(e.toString());
			e.printStackTrace();
			return result;
		}
		return result;
	}
	
	/*
	 * 修改收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/updata")
	public int updataSendAddress(@RequestBody SpSendAddress spSendAddress){
		int result=0;
		try{
			result = spSendAddressService.updateSendAddress(spSendAddress);
		} catch (MyException e) {
			logger.error(e.toString());
			e.printStackTrace();
			return result;
		}
		return result;	
	}
	
	/*
	 * 删除收件地址
	 * 参数 userId,addressId
	 * */
	@RequestMapping(value="/delete")
	public int deleteSendAddress(@RequestBody SpSendAddress spSendAddress){
		int result=0;
		try{
			result = spSendAddressService.deleteSendAddress(spSendAddress);
		} catch (MyException e) {
			logger.error(e.toString());
			e.printStackTrace();
			return result;
		}
		return result;
	}	
	
}
