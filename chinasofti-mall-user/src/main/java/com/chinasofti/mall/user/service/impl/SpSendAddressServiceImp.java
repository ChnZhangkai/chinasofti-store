package com.chinasofti.mall.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.user.mapper.SpSendAddressMapper;
import com.chinasofti.mall.user.service.SpSendAddressService;

@Service
public class SpSendAddressServiceImp implements SpSendAddressService {

	@Autowired
	private SpSendAddressMapper spSendAddressMapper;
	
	@Override
	public List<SpSendAddress> querySentAddressList(String userId){
		return spSendAddressMapper.selectSentAddressList(userId);
	}
	
	@Override
	public int insertSendAddress(SpSendAddress spSendAddress) {
		spSendAddressMapper.insert(spSendAddress);
		return 0;
		
	}
	
	@Override
	public int updateSendAddress(SpSendAddress spSendAddress){
		spSendAddressMapper.update(spSendAddress);
		return 0;
	}
	
	@Override
	public int deleteSendAddress(SpSendAddress spSendAddress){
		spSendAddressMapper.delete(spSendAddress);
		return 0;
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
