package com.chinasofti.app.hystrix;


import org.springframework.stereotype.Component;
import com.chinasofti.app.feign.SpUserFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.ResponseInfo;

import net.sf.json.JSONObject;

/**
 * 
* @ClassName: SpUserFeignClientHystrix
* @Description: 熔断类
* @author xiaozhiliang
* @date 2017年11月9日 
* @version
 */
@Component
public class SpUserFeignClientHystrix implements SpUserFeignClient{

	@Override
	public ResponseInfo signUp(SpUser spUser) {
		return null;
	}
	

	@Override
	public ResponseInfo signIn(SpUser spUser) {
		return null;
	}

	

	
}
