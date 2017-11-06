/**
 * 
 */
package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.SpUser;
import com.chinasofti.mall.web.entrance.feign.SpUserFeignClient;

import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserFeignClientHystrix.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:53:40
 * @parma <T>
 */
@Component
public class SpUserFeignClientHystrix implements SpUserFeignClient{

	@Override
	public String selectBySpUser(SpUser spUser) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject.toString();
	}

}
