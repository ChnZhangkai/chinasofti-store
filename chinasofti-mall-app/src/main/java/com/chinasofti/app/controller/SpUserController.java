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

import com.chinasofti.app.feign.SpUserFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.ResponseInfo;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/spUser")
public class SpUserController {
	@Autowired
	SpUserFeignClient spUserFeignClient;
	private static final Logger logger = LoggerFactory.getLogger(SpUserController.class);



	@RequestMapping(value="/signUp" , method = RequestMethod.POST)
	public ResponseInfo signUp(@RequestBody SpUser spUser) {;
		return spUserFeignClient.signUp(spUser);
		//return null;
	}
	@RequestMapping(value="/signIn" , method = RequestMethod.POST)
	public ResponseInfo signIn(@RequestBody SpUser spUser) {
		logger.info(spUser.toString());
		return spUserFeignClient.signIn(spUser);
		//return null;
	}


}
