package com.chinasofti.app.controller;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
 
import com.chinasofti.app.feign.SpUserFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.ResponseInfo;


@RestController
@RequestMapping("/spUser")
@Component
public class SpUserController {
	@Autowired
	SpUserFeignClient spUserFeignClient;
	private static final Logger logger = LoggerFactory.getLogger(SpUserController.class);


	@RequestMapping(value="/signUp" , method = RequestMethod.POST)
	public ResponseInfo signUp(@RequestBody SpUser spUser,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		return spUserFeignClient.signUp(spUser); 
	}
	@RequestMapping(value="/signIn" , method = RequestMethod.POST)
	public ResponseInfo signIn(@RequestBody SpUser spUser,HttpServletResponse response) {
		response.setHeader("Access-Control-Allow-Origin", "*");
		response.setHeader("Access-Control-Allow-Methods","POST");
		logger.info(spUser.toString());
		return spUserFeignClient.signIn(spUser);
		//return null;
	}


}
