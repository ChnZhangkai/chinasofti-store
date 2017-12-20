package com.chinasofti.app.controller;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.MsgEnum;
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
	
	private String retCode ;
	private String retMsg ;
	/*
	 * 查询地址列表
	 * 参数 userId 用户ID
	 * */
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ResponseInfo findSendAddressList(@RequestParam String userId,HttpServletResponse response) {
		ResponseInfo res = new ResponseInfo();
		List<SpSendAddress> list = spSendAddressFeignClient.findSendAddressList(userId);
		res = DealParamFunctions.dealResponseData(list);
		return res;
	}
	
	 
	/*
	 * 增加收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	public ResponseInfo addSendAddress(@RequestBody SpSendAddress spSendAddress,HttpServletResponse response){
		ResponseInfo res = new ResponseInfo();
		//验证地址信息
		if(!checkAddrInfo(spSendAddress)){
			res.setRetCode(retCode);
			res.setRetMsg(retMsg);
			return res;
		}
		int result = spSendAddressFeignClient.addSendAddress(spSendAddress);
		if(result==0){
			return errorRes();
		}
		res = DealParamFunctions.dealResponseData(result);
		logger.info("123");
		return res;
	}
	
	/*
	 * 修改收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/updata" , method = RequestMethod.POST)
	public ResponseInfo updataSendAddress(@RequestBody SpSendAddress spSendAddress,HttpServletResponse response){
		ResponseInfo res = new ResponseInfo();
		if(!"".equals(spSendAddress.getMobile())&&!checkAddrInfo(spSendAddress)){
			res.setRetCode(retCode);
			res.setRetMsg(retMsg);
			return res;
		}
		int result = spSendAddressFeignClient.updataSendAddress(spSendAddress);
		if(result==0){
			return errorRes();
		}
		res = DealParamFunctions.dealResponseData(result);
		return res;
	}
	
	/*
	 * 删除收件地址
	 * 参数 userId,addressId
	 * */
	@RequestMapping(value="/delete" , method = RequestMethod.POST)
	public ResponseInfo deleteSendAddress(@RequestBody SpSendAddress spSendAddress,HttpServletResponse response){
		ResponseInfo res = new ResponseInfo();
		int result = spSendAddressFeignClient.deleteSendAddress(spSendAddress);
		if(result==0){
			return errorRes();
		}
		res = DealParamFunctions.dealResponseData(result);
		return res;
	}
	
	private boolean checkAddrInfo(SpSendAddress spSendAddress){
		if(!checkMobile(spSendAddress)){
			retCode = Constant.SPADDRESS_MOBILE_ERROR;
			retMsg = Constant.SPADDRESS_MOBILE_MSG;
			return false;
		}
		if(!checkWard(spSendAddress)){
			retCode = Constant.SPADDRESS_PROVINCECITY_ERROR;
			retMsg = Constant.SPADDRESS_PROVINCECITY_MSG;
			return false;
		}
		if(!checkAddress(spSendAddress)){
			retCode = Constant.SPADDRESS_INFO_ERROR;
			retMsg = Constant.SPADDRESS_INFO_MSG;
			return false;
		}
		return true;
		
	}
	
	//验证手机号码
	private boolean checkMobile(SpSendAddress spSendAddress){ 
		String mobile = spSendAddress.getMobile();
		String regExp = "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";  
        Pattern p = Pattern.compile(regExp);  
        Matcher m = p.matcher(mobile);  
        return m.matches();
		
	}
	//验证省市区
	private boolean checkWard(SpSendAddress spSendAddress){
		String province=spSendAddress.getProvince();
		String city=spSendAddress.getCity();
		String district=spSendAddress.getDistrict();
		String address=spSendAddress.getAddress();
		if("".equals(province)||"".equals(city)||"".equals(district)||"".equals(address)){
			return false;
		}
		return true;
		
	}
	//验证地址
	private boolean checkAddress(SpSendAddress spSendAddress){
		String address=spSendAddress.getAddress();
		if("".equals(address)){
			return false;
		}
		return true;
		
	}
	private ResponseInfo errorRes(){
		ResponseInfo res = new ResponseInfo();
		res.setRetCode(MsgEnum.ERROR.getCode());
		res.setRetMsg(MsgEnum.ERROR.getMsg());
		return res;
	}
}
