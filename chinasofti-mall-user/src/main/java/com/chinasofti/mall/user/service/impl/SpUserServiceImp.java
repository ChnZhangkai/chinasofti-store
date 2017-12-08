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
	@Value("${decryptKey}")
	private String decryptKey;
	
	@Override
	public ResponseInfo add(SpUser spUser) {
		ResponseInfo res = new ResponseInfo();
		String password;
		try {
			password = Aes.aesDecrypt(spUser.getPassword(), decryptKey);
			logger.info("解密的Key="+decryptKey+"  解密后的ASE密码:"+password);
			spUser.setPassword(password);
			spUser.setIds(UUIDUtils.getUuid());
			//如果已经注册，直接返回Y
			if( countStr(spUser.getUserId()) != null){
				logger.info("---该账号已被注册--");
				res.setRetCode(Constant.SPUSERID_EXIST_CODE);
				res.setRetMsg(Constant.SPUSERID_EXIST_MSG);
				return res;
			}
			//如果没有 ，进行注册
			int insert=spUserMapper.insert(spUser);
			res = success(res);
			logger.info("-------注册成功--insert="+insert);
		} catch (Exception e) {
			logger.error(e.toString());
			res = error(res);
		}
		return res;
		
	}
	
	@Override
	public ResponseInfo select(SpUser spUser){
		ResponseInfo res = new ResponseInfo();
		try {
			SpUser reSpUser = spUserMapper.select(spUser);
			if(reSpUser ==null||reSpUser.getUserId()==null){
				res.setRetCode(Constant.SPUSERID_PASSWORD_ERROR);
				res.setRetMsg(Constant.SPUSERID_PASSWORD_MSG);
			}
			res = success(res);
			logger.info("-------登录成功----reSpUser="+reSpUser.toString());
		} catch (Exception e) {
			logger.error(e.toString());
			res = error(res);
		
		}
		return res;
	}
	//查询账号是否被注册
	private String countStr(String userId){
		return spUserMapper.contByUserId(userId);
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
	
	
	private ResponseInfo success(ResponseInfo res){
		res.setRetCode(MsgEnum.SUCCESS.getCode());
		res.setRetMsg(MsgEnum.SUCCESS.getMsg());
		return res;
	}
	private ResponseInfo error(ResponseInfo res){
		res.setRetCode(MsgEnum.ERROR.getCode());
		res.setRetMsg(MsgEnum.ERROR.getMsg());
		return res;
	}

}
