package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.web.entrance.feign.GoodsCategoryFeignClient;

import net.sf.json.JSONObject;

@Component
public class GoodsCategoryFeignClientHystrix implements GoodsCategoryFeignClient{

	@Override
	public String selectByGoodsCategory(Goodscategory goodscategory) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject.toString();
	}

	@Override
	public int deleteGoodsCategory(Integer ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Goodscategory selectById(Integer ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateGoodsCategoryById(Goodscategory goodscategory) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int saveGoodsCategory(Goodscategory goodscategory) {
		// TODO Auto-generated method stub
		return 0;
	}

}