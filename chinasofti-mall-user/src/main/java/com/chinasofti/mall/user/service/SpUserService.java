package com.chinasofti.mall.user.service;

import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.user.handler.MyException;

import net.sf.json.JSONObject;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:04时52分20秒
 *
 */
public interface SpUserService extends IBaseService<SpUser>{
	
	/**
	 * @param spUser
	 * @return ResponseInfo
	 */
	
	ResponseInfo add(SpUser spUser)throws MyException;
	
	ResponseInfo select(SpUser spUser)throws MyException;

}
