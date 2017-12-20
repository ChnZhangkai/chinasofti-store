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
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.DealParamFunctions;
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
		ResponseInfo res = new ResponseInfo() ;
		int result=spUserFeignClient.signUp(spUser); 
		if(result == 0 ){
			res.setRetCode(Constant.SPUSERID_EXIST_CODE);
			res.setRetMsg(Constant.SPUSERID_EXIST_MSG);
			logger.info("123");
			return res;
		}
		return DealParamFunctions.dealResponseData(result);
	}
	@RequestMapping(value="/signIn" , method = RequestMethod.POST)
	public ResponseInfo signIn(@RequestBody SpUser spUser,HttpServletResponse response) {
		ResponseInfo res = new ResponseInfo() ;
		SpUser reSpUser = spUserFeignClient.signIn(spUser);
		if(reSpUser==null){
			res.setRetCode(Constant.SPUSERID_PASSWORD_ERROR);
			res.setRetMsg(Constant.SPUSERID_PASSWORD_MSG);
			return res;
		}
		return DealParamFunctions.dealResponseData(reSpUser);
	}


}
