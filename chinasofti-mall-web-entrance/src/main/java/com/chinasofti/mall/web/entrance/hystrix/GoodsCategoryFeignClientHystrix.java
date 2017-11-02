package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.web.entrance.feign.GoodsCategoryFeignClient;

@Component
public class GoodsCategoryFeignClientHystrix implements GoodsCategoryFeignClient{

	@Override
	public List<Goodscategory> selectByGoodsCategory(Goodscategory goodscategory) {
		return new ArrayList<>();
	}

}
