package com.chinasofti.mall.user.service;



import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.service.IBaseService;

import net.sf.json.JSONObject;


public interface PtUserService extends IBaseService<PtUser>{
	
	
	JSONObject selectByExample(PtUser ptUser);

}