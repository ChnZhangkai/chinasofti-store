package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.PyMainGoodsorderWithBLOBs;
import com.chinasofti.mall.web.entrance.feign.MainGoodsorderFeign;

@Component
public class MainGoodsorderFeignClientHystrix implements MainGoodsorderFeign {

	@Override
	public PyMainGoodsorderWithBLOBs findById(String id) {
		return new PyMainGoodsorderWithBLOBs();
	}

	@Override
	public String deleteById(String id) {
		return null;
	}

	@Override
	public String update(PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs) {
		return null;
	}

	@Override
	public String add(PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs) {
		return null;
	}

	@Override
	public List<PyMainGoodsorderWithBLOBs> selectByExample(PyMainGoodsorderWithBLOBs mainGoodsorderWithBLOBs) {
		return new ArrayList<>();
	}

}
