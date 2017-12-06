package com.chinasofti.mall.user.mapper;

import com.chinasofti.mall.common.entity.spuser.SpUser;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:05时13分47秒
 *
 */
public interface SpUserMapper {
	
	String contByUserId(String userId);
	
	int insert(SpUser spUser); 
	
	SpUser select(SpUser spUser);
	
    SpUser selectByUserId(SpUser spUser);

}
