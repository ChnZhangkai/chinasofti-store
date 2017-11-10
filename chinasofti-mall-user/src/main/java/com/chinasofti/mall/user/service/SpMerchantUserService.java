package com.chinasofti.mall.user.service;



import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.common.service.IBaseService;

import net.sf.json.JSONObject;


/**
 * @ClassName: SpUserService.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:10:43
 * @parma <T>
 */
public interface SpMerchantUserService extends IBaseService<SpMerchantUser>{

	/**
	 * @param spUser
	 * @return
	 */
	JSONObject selectByExample(SpMerchantUser spMerchantUser);


}
