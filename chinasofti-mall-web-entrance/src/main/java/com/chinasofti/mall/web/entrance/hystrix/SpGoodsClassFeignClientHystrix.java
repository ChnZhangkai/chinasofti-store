package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.ChnGoodsClass;
import com.chinasofti.mall.web.entrance.feign.SpGoodsClassFeignClient;

import net.sf.json.JSONObject;

@Component
public class SpGoodsClassFeignClientHystrix implements SpGoodsClassFeignClient{

	@Override
	public JSONObject selectByGoodsClass(ChnGoodsClass chnGoodsClass) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject;
	}

	@Override
	public int deleteGoodsClassById(String ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ChnGoodsClass selectGoodsClassById(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateGoodsClass(ChnGoodsClass chnGoodsClass) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveGoodsClass(ChnGoodsClass chnGoodsClass) {
		// TODO Auto-generated method stub
		return 0;
	}

}
