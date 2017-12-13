/**
 * 
 */
package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;

import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserFeignClientHystrix.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:53:40
 * @parma <T>
 */
@Component
public class SpMerchantUserFeignClientHystrix implements SpMerchantUserFeignClient{

	@Override
	public JSONObject selectBySpUser(SpMerchantUser spMerchantUser) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject;
	}

	
	@Override
	public SpMerchantUser selectSpUserById(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public String deleteById(String ids) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int spUserAdd(SpMerchantUser spMerchantUser) {
		return 0;
		
	}

	@Override
	public int spUserUpdate(SpMerchantUser spMerchantUser) {
		return 0;
	}

	@Override
	public String findByPage(Map<String, Object> paramMap) {
		return "服务已断开";
	}

}
