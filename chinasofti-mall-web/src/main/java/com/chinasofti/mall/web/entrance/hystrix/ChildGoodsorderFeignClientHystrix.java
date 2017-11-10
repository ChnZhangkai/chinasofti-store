package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.order.ChildorderCondition;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.web.entrance.feign.ChildGoodsorderFeign;

import net.sf.json.JSONObject;

@Component
public class ChildGoodsorderFeignClientHystrix implements ChildGoodsorderFeign {

	@Override
	public PyChildGoodsorder findById(String id) {
		return new PyChildGoodsorder();
	}

	@Override
	public String deleteById(String id) {
		return null;
	}

	@Override
	public String update(PyChildGoodsorder childGoodsorder) {
		return null;
	}

	@Override
	public String add(PyChildGoodsorder childGoodsorder) {
		return null;
	}

	@Override
	public JSONObject selectByChildorderClass(PyChildGoodsorder childGoodsorder) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject;
	}

	@Override
	public JSONObject selectByChildorderCondition(ChildorderCondition childorderCondition) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject;
	}

}
