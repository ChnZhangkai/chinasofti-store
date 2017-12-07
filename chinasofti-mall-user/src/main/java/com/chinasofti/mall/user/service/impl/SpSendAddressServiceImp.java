package com.chinasofti.mall.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.user.controller.SpUserController;
import com.chinasofti.mall.user.handler.MyException;
import com.chinasofti.mall.user.mapper.SpSendAddressMapper;
import com.chinasofti.mall.user.service.SpSendAddressService;

@Service
public class SpSendAddressServiceImp implements SpSendAddressService {

	@Autowired
	private SpSendAddressMapper spSendAddressMapper;
	
	Logger logger = LoggerFactory.getLogger(SpUserController.class);  
	
	private String retCode ;
	private String retMsg ;
	
	@Override
	public ResponseInfo querySentAddressList(String userId) {
		ResponseInfo res = new ResponseInfo();
		try {
			List<SpSendAddress>  list = spSendAddressMapper.selectSentAddressList(userId);
			res = DealParamFunctions.dealResponseData(list);
		} catch (MyException e) {
			e.printStackTrace();
			logger.error(e.toString());
		}
		
		return res;
	}
	
	@Override
	public ResponseInfo insertSendAddress(SpSendAddress spSendAddress){
		ResponseInfo res = new ResponseInfo();
		//验证地址信息
		if(!checkAddrInfo(spSendAddress)){
			res.setRetCode(retCode);
			res.setRetMsg(retMsg);
			return res;
		}		
		spSendAddress.setAddressId(UUIDUtils.getUuid());
		spSendAddress.setCreateTime(mathNum());
		try {
			int insert = spSendAddressMapper.insert(spSendAddress);
			res = DealParamFunctions.dealResponseData(insert);
		} catch (MyException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return res;
		
	}
	
	@Override
	public ResponseInfo updateSendAddress(SpSendAddress spSendAddress){
		ResponseInfo res = new ResponseInfo();
		if(!"".equals(spSendAddress.getMobile())&&!checkAddrInfo(spSendAddress)){
			res.setRetCode(retCode);
			res.setRetMsg(retMsg);
			return res;
		}
		try {
			int update = spSendAddressMapper.update(spSendAddress);
			res = DealParamFunctions.dealResponseData(update);
		} catch (MyException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public ResponseInfo deleteSendAddress(SpSendAddress spSendAddress){
		ResponseInfo res = new ResponseInfo();
		try {
			int detele = spSendAddressMapper.delete(spSendAddress);
			res = DealParamFunctions.dealResponseData(detele);
		} catch (MyException e) {
			logger.error(e.toString());
			e.printStackTrace();
		}
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
	//时间戳
	private String mathNum(){
		Date date = new Date();
		SimpleDateFormat sd = new SimpleDateFormat("yyyyMMddHHmmss");
		String nowTime = sd.format(date);
		return nowTime;
	}

	@Override
	public int save(SpSendAddress t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SpSendAddress> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpSendAddress findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SpSendAddress t) {
		// TODO Auto-generated method stub
		return 0;
	}	


}
