package com.chinasofti.mall.web.entrance.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.web.entrance.hystrix.GoodsCategoryFeignClientHystrix;

@FeignClient(name = "advertise-service" , fallback = GoodsCategoryFeignClientHystrix.class)
public interface AdvertiseFeignClient {
	
	@RequestMapping(value = "/goods/select" , method = RequestMethod.POST)
	public List<Goodscategory> selectByGoodsCategory(@RequestBody(required = false) Goodscategory goodscategory);
	
}
