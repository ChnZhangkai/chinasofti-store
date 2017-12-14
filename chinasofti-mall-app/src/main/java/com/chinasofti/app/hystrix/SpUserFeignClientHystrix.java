package com.chinasofti.app.hystrix;

import org.springframework.stereotype.Component;
import com.chinasofti.app.feign.SpUserFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpUser;
import com.chinasofti.mall.common.utils.ResponseInfo;

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
	public int signUp(SpUser spUser) {
		return 0;
	}
	
 
	@Override
	public SpUser signIn(SpUser spUser) {
		return new SpUser();
	}

	

	
}
