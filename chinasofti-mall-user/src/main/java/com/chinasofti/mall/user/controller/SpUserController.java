package com.chinasofti.mall.user.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.Aes;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.UUIDUtils;
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
	
	private static final Logger logger = LoggerFactory.getLogger(SpUserController.class);  
	
	@RequestMapping(value="/signUp")
	public int signUp(@RequestBody SpUser spUser) {
		try {
			//首先验证该客户是否存在
			boolean flag = spUserService.countStr(spUser.getUserId());
			if(!flag){
				return 0;
			}
			return spUserService.add(spUser);	
			} catch (Exception e) {
				logger.error(e.toString());
				return 0;
		}
	}
	
	@RequestMapping(value="/signIn")
	public SpUser signIn(@RequestBody SpUser spUser) {
		SpUser reSpUser = null;
		try {
			reSpUser = spUserService.select(spUser);	
		} catch (Exception e) {
			logger.error(e.toString());	
		}
		return reSpUser;	
	}
	
	@RequestMapping(value="/isUserExist")
	public Boolean isUserExist(@RequestBody SpUser spUser) {
		try {
			SpUser user = spUserService.isUserExist(spUser);
			if (user == null) {
				logger.info("该用户不存在！");
				return false;
			} 
			
		} catch (Exception e) {
			logger.info(e.getMessage());
			logger.info(e.toString());
		}
		return true;
	}
	
	
}
