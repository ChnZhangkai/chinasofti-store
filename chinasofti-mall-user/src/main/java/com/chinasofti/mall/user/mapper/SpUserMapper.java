package com.chinasofti.mall.user.mapper;

import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.user.handler.MyException;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:05时13分47秒
 *
 */
public interface SpUserMapper {
	
	String contByUserId(String userId);
	
	int insert(SpUser spUser)throws MyException; 
	
	SpUser select(SpUser spUser)throws MyException;
	
    SpUser selectByUserId(SpUser spUser);

}
