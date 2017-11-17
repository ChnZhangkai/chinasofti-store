package com.chinasofti.mall.user.service.impl;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.user.handler.MyException;
import com.chinasofti.mall.user.mapper.SpSendAddressMapper;
import com.chinasofti.mall.user.service.SpSendAddressService;

@Service
public class SpSendAddressServiceImp implements SpSendAddressService {

	@Autowired
	private SpSendAddressMapper spSendAddressMapper;
	
	@Override
	public List<SpSendAddress> querySentAddressList(String userId) throws MyException{
		List<SpSendAddress> list = new LinkedList<SpSendAddress>();
		try{
			list = spSendAddressMapper.selectSentAddressList(userId);
		}catch(Exception e){
			throw new MyException("9999","发生错误");
		}
		return list;
	}
	
	@Override
	public int insertSendAddress(SpSendAddress spSendAddress) throws MyException{
		spSendAddress.setAddressId(UUIDUtils.getUuid());
		try{
			spSendAddressMapper.insert(spSendAddress);
		}catch(Exception e){
			throw new MyException("9999","发生错误");
		}
		return 0;
		
	}
	
	@Override
	public int updateSendAddress(SpSendAddress spSendAddress) throws MyException{
		try{
			spSendAddressMapper.update(spSendAddress);
		}catch(Exception e){
			throw new MyException("9999","发生错误");
		}
		return 0;
	}
	
	@Override
	public int deleteSendAddress(SpSendAddress spSendAddress) throws MyException{
		try{
			spSendAddressMapper.delete(spSendAddress);
		}catch(Exception e){
			throw new MyException("9999","发生错误");
		}
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
