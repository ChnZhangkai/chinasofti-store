package com.chinasofti.mall.web.entrance.hystrix;


import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.web.entrance.feign.PtHrUserFeignClient;

import net.sf.json.JSONObject;


@Component
public class PtHrUserFeignClientHystrix implements PtHrUserFeignClient{

	@Override
	public String selectByUser(PtHrUserBak ptHrUserBak) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject.toString();
	}
	
}
