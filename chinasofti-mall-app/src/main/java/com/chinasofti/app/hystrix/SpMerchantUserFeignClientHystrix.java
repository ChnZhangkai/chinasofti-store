/**
 * 
 */
package com.chinasofti.app.hystrix;

import com.chinasofti.app.feign.SpMerchantUserFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;

/**
 * @ClassName: SpMerchantUserFeignClientHystrix.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月17日 下午5:09:27
 * @parma <T>
 */
public class SpMerchantUserFeignClientHystrix implements SpMerchantUserFeignClient{

	
	@Override
	public SpMerchantUser queryVendorInfo(String vendorId) {
		return new SpMerchantUser();
	}

	

}
