package com.chinasofti.mall.web.entrance.hystrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
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
@Component
public class AdvertiseFeignClientHystrix implements AdvertiseFeignClient{

	@Override
	public List<AdvertiseContents> findAll() {
		return new ArrayList<>();
	}

	@Override
	public String findByPage(Map<String, Object> paramMap) {
		return "服务已断开";
	}

	@Override
	public String deleteById(String id) {
		return "服务已断开";
	}

	@Override
	public String add(AdvertiseContents cmsAdContentsWithBLOBs) {
		return "服务已断开";
	}

	@Override
	public String update(AdvertiseContents cmsAdContentsWithBLOBs) {
		return "服务已断开";
	}

	
}
