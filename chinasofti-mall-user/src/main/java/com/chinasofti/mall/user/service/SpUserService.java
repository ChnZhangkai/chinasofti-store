package com.chinasofti.mall.user.service;

import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.service.IBaseService;

import net.sf.json.JSONObject;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:04时52分20秒
 *
 */
public interface SpUserService extends IBaseService<SpUser>{
	
	/**
	 * @param spUser
	 * @return
	 */
	String insert(SpUser spUser);
	
	SpUser select(SpUser spUser);

}
