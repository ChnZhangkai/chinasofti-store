/**
 * 
 */
package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.web.entrance.hystrix.SpMerchantUserFeignClientHystrix;

import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserFeignClient.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:53:01
 * @parma <T>
 */
@FeignClient(name = "sp-userService" , fallback = SpMerchantUserFeignClientHystrix.class)
public interface SpMerchantUserFeignClient {

	/**
	 * @param spUser
	 * @return
	 */
	@RequestMapping(value = "/spUser/select" , method = RequestMethod.POST)
	JSONObject selectBySpUser(@RequestBody(required = false) SpMerchantUser spMerchantUser);

}
