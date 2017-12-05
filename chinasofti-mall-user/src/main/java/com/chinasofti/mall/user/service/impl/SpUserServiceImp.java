package com.chinasofti.mall.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpUser;
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
	
	Logger logger = LoggerFactory.getLogger(SpUserController.class);  
	
	@Override
	public ResponseInfo add(SpUser spUser) throws MyException{
		ResponseInfo res = new ResponseInfo();
		String userId = spUser.getUserId();
		spUser.setIds(UUIDUtils.getUuid());
		String countStr = countStr(userId);	
			//如果已经注册，直接返回Y
		if( countStr != null){
			logger.info("-------该账号已被注册------------");
			res.setRetCode("400010");
			res.setRetMsg("该账号已被注册");
			return res;
		}
		//如果没有 ，进行注册
		int retIn = spUserMapper.insert(spUser);
		res = dealResponseData(retIn);
		logger.info("-------注册成功------------");
		return res;
		
	}
	
	@Override
	public ResponseInfo select(SpUser spUser) throws MyException{
		ResponseInfo res = new ResponseInfo();
		SpUser user = new SpUser();
		user = spUserMapper.select(spUser);
		res = dealResponseData(user);
		return res;
	}
	//查询账号是否被注册
	private String countStr(String userId){
		return spUserMapper.contByUserId(userId);
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
