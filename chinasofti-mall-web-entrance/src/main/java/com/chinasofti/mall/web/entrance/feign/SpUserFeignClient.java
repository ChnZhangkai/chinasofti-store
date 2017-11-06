/**
 * 
 */
package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.SpUser;
import com.chinasofti.mall.web.entrance.hystrix.SpUserFeignClientHystrix;

/**
 * @ClassName: SpUserFeignClient.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:53:01
 * @parma <T>
 */
@FeignClient(name = "sp-userService" , fallback = SpUserFeignClientHystrix.class)
public interface SpUserFeignClient {

	/**
	 * @param spUser
	 * @return
	 */
	@RequestMapping(value = "/spUser/select" , method = RequestMethod.POST)
	String selectBySpUser(@RequestBody(required = false) SpUser spUser);

}
