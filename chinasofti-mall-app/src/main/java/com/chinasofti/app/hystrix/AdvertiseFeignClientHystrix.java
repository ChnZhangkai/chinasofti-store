package com.chinasofti.app.hystrix;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.AdvertiseFeignClient;
import com.chinasofti.mall.common.entity.AdvertiseContents;

/**
 * 
* @ClassName: AdvertiseFeignClientHystrix
* @Description: 熔断类
* @author gezhenlin
* @date 2017年11月9日 
* @version
 */
@Component
public class AdvertiseFeignClientHystrix implements AdvertiseFeignClient{

	@Override
	public AdvertiseContents findAdvertise(String positionId) {
		return null;
	}

	@Override
	public List<AdvertiseContents> findAdvertiseList(AdvertiseContents advertiseContents) {
		return new ArrayList<AdvertiseContents>();
	}

	

	
}
