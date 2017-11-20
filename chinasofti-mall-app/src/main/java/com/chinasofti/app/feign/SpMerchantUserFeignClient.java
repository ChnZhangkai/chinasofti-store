/**
 * 
 */
package com.chinasofti.app.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.SpMerchantUserFeignClientHystrix;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;


/**
 * @ClassName: SpMerchantUserFeignClient.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月17日 下午5:08:36
 * @parma <T>
 */
@FeignClient(name = "userService" , fallback = SpMerchantUserFeignClientHystrix.class)
public interface SpMerchantUserFeignClient {

	/**
	 * @param vendorId
	 * @return
	 */
	@RequestMapping(value = "/spUser/queryVendorInfo")
	SpMerchantUser queryVendorInfo(@RequestParam("vendorId") String vendorId);

}
