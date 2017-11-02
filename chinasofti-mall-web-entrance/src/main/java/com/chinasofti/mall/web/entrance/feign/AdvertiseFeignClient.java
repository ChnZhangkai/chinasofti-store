package com.chinasofti.mall.web.entrance.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import com.chinasofti.mall.web.entrance.hystrix.AdvertiseFeignClientHystrix;


@FeignClient(name = "advertise-service" , fallback = AdvertiseFeignClientHystrix.class)
public interface AdvertiseFeignClient {
	
	@RequestMapping(value = "/advertise/findAll" , method = RequestMethod.POST)
	public List<CmsAdContentsWithBLOBs> findAll();
	
}
