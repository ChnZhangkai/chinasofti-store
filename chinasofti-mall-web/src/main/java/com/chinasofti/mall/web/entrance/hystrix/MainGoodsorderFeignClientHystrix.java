package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.web.entrance.feign.MainGoodsorderFeign;

import net.sf.json.JSONObject;

@Component
public class MainGoodsorderFeignClientHystrix implements MainGoodsorderFeign {

	@Override
	public PyMainGoodsorder findById(String id) {
		return new PyMainGoodsorder();
	}

	@Override
	public String deleteById(String id) {
		return null;
	}

	@Override
	public String update(PyMainGoodsorder mainGoodsorder) {
		return null;
	}

	@Override
	public String add(PyMainGoodsorder mainGoodsorder) {
		return null;
	}

	@Override
	public JSONObject selectByMainorderClass(PyMainGoodsorder mainGoodsorder) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject;
	}

}
