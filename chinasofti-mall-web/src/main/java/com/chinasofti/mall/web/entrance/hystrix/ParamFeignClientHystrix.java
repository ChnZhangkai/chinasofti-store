package com.chinasofti.mall.web.entrance.hystrix;

import com.chinasofti.mall.common.entity.param.Param;
import com.chinasofti.mall.web.entrance.feign.ParamFeigClient;

import net.sf.json.JSONObject;

public class ParamFeignClientHystrix implements ParamFeigClient{

	@Override
	public JSONObject findAll(Param param) {
		// TODO Auto-generated method stub
		return null;
	}

}
