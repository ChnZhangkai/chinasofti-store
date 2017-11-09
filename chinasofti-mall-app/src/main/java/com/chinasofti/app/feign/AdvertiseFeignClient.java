package com.chinasofti.app.feign;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.AdvertiseFeignClientHystrix;
import com.chinasofti.mall.common.entity.AdvertiseContents;




/**
* @ClassName: AdvertiseFeignClient
* @Description: 广告服务的feign消费类
* @author KanM
* @date 2017年11月2日 下午5:50:13 
* @version
*/
@FeignClient(name = "advertise-service" , fallback = AdvertiseFeignClientHystrix.class)
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
	public List<AdvertiseContents> findAdvertiseList(@RequestBody(required = false) AdvertiseContents advertiseContents);
	
	
	
	
	
}
