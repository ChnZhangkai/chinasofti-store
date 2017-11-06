package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.web.entrance.feign.MainGoodsorderFeign;

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
	public List<PyMainGoodsorder> selectByExample(PyMainGoodsorder mainGoodsorder) {
		return new ArrayList<>();
	}

}
