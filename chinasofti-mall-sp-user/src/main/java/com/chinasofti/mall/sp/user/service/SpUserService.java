package com.chinasofti.mall.sp.user.service;

import com.chinasofti.mall.common.entity.SpUser;
import com.chinasofti.mall.common.service.IBaseService;

/**
 * @ClassName: SpUserService.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:10:43
 * @parma <T>
 */
public interface SpUserService extends IBaseService<SpUser>{

	/**
	 * @param spUser
	 * @return
	 */
	String selectByExample(SpUser spUser);

}
