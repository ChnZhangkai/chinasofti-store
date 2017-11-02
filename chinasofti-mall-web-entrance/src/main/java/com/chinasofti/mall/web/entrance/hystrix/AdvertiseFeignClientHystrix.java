package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.web.entrance.feign.AdvertiseFeignClient;
/**
 * 
* @ClassName: AdvertiseFeignClientHystrix
* @Description: 熔断类
* @author KanM
* @date 2017年11月2日 下午5:54:08 
* @version
 */
public class AdvertiseFeignClientHystrix implements AdvertiseFeignClient{

	@Override
	public List<AdvertiseContents> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findByPage(Map<String, Object> paramMap) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String deleteById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String add(AdvertiseContents cmsAdContentsWithBLOBs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String update(AdvertiseContents cmsAdContentsWithBLOBs) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
