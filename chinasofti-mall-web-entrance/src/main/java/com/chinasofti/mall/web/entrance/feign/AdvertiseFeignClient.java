package com.chinasofti.mall.web.entrance.feign;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import com.chinasofti.mall.web.entrance.hystrix.AdvertiseFeignClientHystrix;


@FeignClient(name = "advertise-service" , fallback = AdvertiseFeignClientHystrix.class)
public interface AdvertiseFeignClient {
	
	@RequestMapping(value = "/advertise/findAll")
	public List<CmsAdContentsWithBLOBs> findAll();
	

	@RequestMapping(value = "/advertise/findByPage")
	public String findByPage(@RequestParam Map<String,Object> paramMap);
}
