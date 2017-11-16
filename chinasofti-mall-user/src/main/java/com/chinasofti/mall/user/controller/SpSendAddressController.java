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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
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
	
	private String retCode ;
	private String retMsg ;
	
	/*
	 * 查询地址列表
	 * 参数 userId 用户ID
	 * */
	@RequestMapping(value="/list")
	@ResponseBody
	public ResponseInfo findSendAddressList(@RequestParam("userId") String userId) {
		ResponseInfo res = new ResponseInfo();
		List<SpSendAddress> list = new ArrayList<SpSendAddress>();
		list = spSendAddressService.querySentAddressList(userId);
		res = dealResponseData(list);
		logger.info("res="+res.toString());
		return res;
	}
	
	/*
	 * 增加收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/add" , method = RequestMethod.POST)
	public ResponseInfo addSendAddress(@RequestBody(required=false) SpSendAddress spSendAddress){
		ResponseInfo res = new ResponseInfo();
		//验证地址信息
		if(!checkAddrInfo(spSendAddress)){
			res.setRetCode(retCode);
			res.setRetMsg(retMsg);
			return res;
		}
		res = dealResponseData(spSendAddressService.insertSendAddress(spSendAddress));
		logger.info(res.toString());
		return res;
	}
	
	/*
	 * 修改收件地址
	 * 参数 spSendAddress
	 * */
	@RequestMapping(value="/updata" ,  method = RequestMethod.POST)
	public ResponseInfo updataSendAddress(@RequestBody(required=false) SpSendAddress spSendAddress){
		ResponseInfo res = new ResponseInfo();
		if(!"".equals(spSendAddress.getMobile())&&!checkAddrInfo(spSendAddress)){
			res.setRetCode(retCode);
			res.setRetMsg(retMsg);
			return res;
		}
		return dealResponseData(spSendAddressService.updateSendAddress(spSendAddress));
	}
	
	/*
	 * 删除收件地址
	 * 参数 userId,addressId
	 * */
	@RequestMapping(value="/delete"  , method = RequestMethod.POST)
	public ResponseInfo deleteSendAddress(@RequestBody(required=false) SpSendAddress spSendAddress){
		return dealResponseData(spSendAddressService.deleteSendAddress(spSendAddress));
	}
	
	//封装返回参数
	private ResponseInfo dealResponseData(Object obj) {
		ResponseInfo  response= new ResponseInfo();
		if(obj !=null){
			Map<String, Object> data= new HashMap<String, Object>();
			data.put("res", obj);
			response.setData(data);
			response.setRetCode(MsgEnum.SUCCESS.getCode());
			response.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}else{
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg(MsgEnum.ERROR.getMsg());
		}
		
		return response;
	}	
	
	private boolean checkAddrInfo(SpSendAddress spSendAddress){
		if(!checkMobile(spSendAddress)){
			retCode = "600010";
			retMsg = "请输入正确的手机号码";
			return false;
		}
		if(!checkWard(spSendAddress)){
			retCode = "600011";
			retMsg = "请输入完整的省市区";
			return false;
		}
		if(!checkAddress(spSendAddress)){
			retCode = "600012";
			retMsg = "请输入正确的地址";
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
	//验证省市区
		private boolean checkAddress(SpSendAddress spSendAddress){
			String address=spSendAddress.getAddress();
			if("".equals(address)){
				return false;
			}
			return true;
			
		}
}
