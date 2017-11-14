package com.chinasofti.mall.web.entrance.hystrix;


import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.web.entrance.feign.MenuFeignClient;
import com.chinasofti.mall.web.entrance.feign.PtHrUserFeignClient;

import net.sf.json.JSONObject;


@Component
public class PtMenuFeignClientHystrix implements MenuFeignClient{


	@Override
	public String getMenu(String pIds) {
		return null;
	}
	
}
