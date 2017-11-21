package com.chinasofti.mall.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.user.handler.MyException;
import com.chinasofti.mall.user.service.SpUserService;

import net.sf.json.JSONObject;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:04时48分26秒
 *
 */

@RestController
@RequestMapping("/spUser")
public class SpUserController {
	
	@Autowired
	SpUserService spUserService;
	
	Logger logger = LoggerFactory.getLogger(SpUserController.class);  
	
	@RequestMapping(value="/signUp")
	public ResponseInfo signUp(@RequestBody SpUser spUser) {
		ResponseInfo res = new ResponseInfo();
		try {
			res = spUserService.add(spUser);
		} catch (MyException e1) {
			res.setRetCode("999999");
			res.setRetMsg("系统异常");
		}
		return res;	
		
	}
	
	@RequestMapping(value="/signIn")
	public ResponseInfo signIn(@RequestBody SpUser spUser) {
		ResponseInfo res = new ResponseInfo();
		try {
			res = spUserService.select(spUser);
		} catch (MyException e1) {
			res.setRetCode("999999");
			res.setRetMsg("系统异常");
		}
		return res;
	}
	
	
	
	
}
