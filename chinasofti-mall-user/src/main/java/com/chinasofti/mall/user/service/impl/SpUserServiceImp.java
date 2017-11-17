package com.chinasofti.mall.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.user.handler.MyException;
import com.chinasofti.mall.user.mapper.SpUserMapper;
import com.chinasofti.mall.user.service.SpUserService;

import net.sf.json.JSONObject;

@Service
public class SpUserServiceImp implements SpUserService {

	@Autowired
	private SpUserMapper spUserMapper;
	
	@Override
	public String insert(SpUser spUser) throws MyException{
		String userId = spUser.getUserId();
		//查询账号是否已被注册
		String reUserId = spUserMapper.contByUserId(userId);
		System.out.println("reUserId="+reUserId);
		
		//如果已经注册，直接返回Y
		if( reUserId != null){
			System.out.println("已经被注册");
			return "Y" ;
		}
		//如果没有 ，进行注册
		int retIn = spUserMapper.insert(spUser);
		if(retIn !=1){
			throw new MyException("9999","发生错误");
		}
		return "SUCCESS";
		
	}
	
	@Override
	public SpUser select(SpUser spUser) throws MyException{
		SpUser res = new SpUser();
		try{
			res = spUserMapper.select(spUser);
		}catch(Exception e){
			throw new MyException("9999","发生错误");
		}
		return res;
	}
	
	@Override
	public int save(SpUser t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<SpUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SpUser findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(SpUser t) {
		// TODO Auto-generated method stub
		return 0;
	}


}
