package com.chinasofti.mall.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.Aes;
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.DealParamFunctions;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.user.controller.SpUserController;
import com.chinasofti.mall.user.handler.MyException;
import com.chinasofti.mall.user.mapper.SpUserMapper;
import com.chinasofti.mall.user.service.SpUserService;

@Service
public class SpUserServiceImp implements SpUserService {

	@Autowired
	private SpUserMapper spUserMapper;
	
	Logger logger = LoggerFactory.getLogger(SpUserServiceImp.class);  
	@Value("${decryptKey}")
	private String decryptKey;
	
	@Override
	public int add(SpUser spUser) throws Exception{
		String password = Aes.aesDecrypt(spUser.getPassword(), decryptKey);//进行Aes解密
		spUser.setPassword(password);
		spUser.setIds(UUIDUtils.getUuid());
		spUser.setCreateTime(UUIDUtils.nowTime());//创建时间
		spUser.setStatus("1");//创建时默认启用   1：启用
		int insert=spUserMapper.insert(spUser);
		return insert;
	}
	
	@Override
	public SpUser select(SpUser spUser) throws Exception{
		SpUser reSpUser = new SpUser();
		String password = Aes.aesDecrypt(spUser.getPassword(), decryptKey);	
		spUser.setPassword(password);
		reSpUser = spUserMapper.signIn(spUser);
		return reSpUser;
	}
	//查询账号是否被注册
	@Override
	public boolean countStr(String userId){
		String countStr = spUserMapper.contByUserId(userId);
		if(countStr == null){
			return true;
		}
		return false;
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

	@Override
	public SpUser isUserExist(SpUser spUser) throws MyException{
		return spUserMapper.selectByUserId(spUser);
	}

}
