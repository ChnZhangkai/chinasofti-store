package com.chinasofti.mall.user.service.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.user.handler.MyException;
import com.chinasofti.mall.user.mapper.SpSendAddressMapper;
import com.chinasofti.mall.user.service.SpSendAddressService;

@Service
public class SpSendAddressServiceImp implements SpSendAddressService {

	@Autowired
	private SpSendAddressMapper spSendAddressMapper;
	
	private String retCode ;
	private String retMsg ;
	
	@Override
	public ResponseInfo querySentAddressList(String userId) throws MyException{
		ResponseInfo res = new ResponseInfo();
		List<SpSendAddress> list = new LinkedList<SpSendAddress>();
		list = spSendAddressMapper.selectSentAddressList(userId);
		res = dealResponseData(list);
		return res;
	}
	
	@Override
	public ResponseInfo insertSendAddress(SpSendAddress spSendAddress) throws MyException{
		ResponseInfo res = new ResponseInfo();
		//验证地址信息
		if(!checkAddrInfo(spSendAddress)){
			res.setRetCode(retCode);
			res.setRetMsg(retMsg);
			return res;
		}		
		spSendAddress.setAddressId(UUIDUtils.getUuid());
		int insert = spSendAddressMapper.insert(spSendAddress);
		res = dealResponseData(insert);
		return res;
		
	}
	
	@Override
	public ResponseInfo updateSendAddress(SpSendAddress spSendAddress) throws MyException{
		ResponseInfo res = new ResponseInfo();
		if(!"".equals(spSendAddress.getMobile())&&!checkAddrInfo(spSendAddress)){
			res.setRetCode(retCode);
			res.setRetMsg(retMsg);
			return res;
		}
		
		int update = spSendAddressMapper.update(spSendAddress);
		res = dealResponseData(update);
		return res;
	}
	
	@Override
	public ResponseInfo deleteSendAddress(SpSendAddress spSendAddress) throws MyException{
		ResponseInfo res = new ResponseInfo();
		int detele = spSendAddressMapper.delete(spSendAddress);
		res = dealResponseData(detele);
		return res;
	}

	//封装返回参数
	private ResponseInfo dealResponseData(Object obj) {
		ResponseInfo  response= new ResponseInfo();
		if(obj !=null){
			Map<String, Object> data= new HashMap<String, Object>();
			data.put("responseInfo", obj);
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
	private boolean checkAddress(SpSendAddress spSendAddress){
		String address=spSendAddress.getAddress();
		if("".equals(address)){
			return false;
		}
		return true;
		
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
