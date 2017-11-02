package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;
import java.util.List;

import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import com.chinasofti.mall.web.entrance.feign.AdvertiseFeignClient;

public class AdvertiseFeignClientHystrix implements AdvertiseFeignClient{

	@Override
	public List<CmsAdContentsWithBLOBs> findAll() {
		return new ArrayList<>();
	}

}
