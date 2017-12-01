package com.chinasofti.mall.user.service;



import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUser;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUserExample;
import com.chinasofti.mall.common.service.IBaseService;

import net.sf.json.JSONObject;


public interface PtUserService extends IBaseService<PtUser>{
	
	
	JSONObject selectByExample(PtUser ptUser);
	
	String selectByUserName(String username);
	
	PtRole selectUserRoleName(String ids);
	
	int updateByExampleSelective(@Param("record") PtRoleUser record, @Param("example") PtRoleUserExample example);
	
}