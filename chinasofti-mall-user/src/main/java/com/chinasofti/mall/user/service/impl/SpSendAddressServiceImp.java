package com.chinasofti.mall.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.user.controller.SpUserController;
import com.chinasofti.mall.user.handler.MyException;
import com.chinasofti.mall.user.mapper.SpSendAddressMapper;
import com.chinasofti.mall.user.service.SpSendAddressService;

@Service
public class SpSendAddressServiceImp implements SpSendAddressService {

	@Autowired
	private SpSendAddressMapper spSendAddressMapper;
	
	Logger logger = LoggerFactory.getLogger(SpSendAddressServiceImp.class);  
	
	@Override
	public List<SpSendAddress> querySentAddressList(String userId) throws MyException{
		List<SpSendAddress> list = new ArrayList<SpSendAddress>();
		list = spSendAddressMapper.selectSentAddressList(userId);
		return list;	
	}
	
	@Override
	public int insertSendAddress(SpSendAddress spSendAddress) throws MyException{
		spSendAddress.setAddressId(UUIDUtils.getUuid());
		spSendAddress.setCreateTime(UUIDUtils.nowTime());
	    int result = spSendAddressMapper.insert(spSendAddress);
		return result;
		
	}
	
	@Override
	public int updateSendAddress(SpSendAddress spSendAddress) throws MyException{
		int result = spSendAddressMapper.update(spSendAddress);
		return result;
	}
	
	@Override
	public int deleteSendAddress(SpSendAddress spSendAddress) throws MyException{
		int result = spSendAddressMapper.delete(spSendAddress);
		return result;
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
