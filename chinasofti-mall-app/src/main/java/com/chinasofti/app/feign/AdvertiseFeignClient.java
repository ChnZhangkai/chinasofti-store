package com.chinasofti.app.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.AdvertiseFeignClientHystrix;
import com.chinasofti.mall.common.entity.AdvertiseContents;
 
/**广告消费类
 * 
 * @author gezhenlin
 *
 */
@FeignClient(name = "Goods-Service" , fallback = AdvertiseFeignClientHystrix.class)
public interface AdvertiseFeignClient {
	
	
	/**
	 * 
	* @Title: findAdvertise
	* @Description: 
	* @param id
	* @return: String
	* @throws:
	 */
	@RequestMapping(value = "/advertise/findAdvertise")
	public AdvertiseContents findAdvertise(@RequestParam("positionId") String positionId);

	/**
	* @Title: 
	* @Description: 广告列表查询
	* @param: cmsAdContentsWithBLOBs
	* @return: String
	* @throws
	*/
	@RequestMapping(value = "/advertise/findAdvertiseList")
	public List<AdvertiseContents> findAdvertiseList(@RequestParam("positionId") String positionId);
	
	
	
	
	
}
