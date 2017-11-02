package com.chinasofti.mall.web.entrance.feign;

import java.util.List;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.web.entrance.hystrix.AdvertiseFeignClientHystrix;


/**
* @ClassName: AdvertiseFeignClient
* @Description: 广告服务的feign消费类
* @author KanM
* @date 2017年11月2日 下午5:50:13 
* @version
*/
@FeignClient(name = "advertise-service" , fallback = AdvertiseFeignClientHystrix.class)
public interface AdvertiseFeignClient {
	
	@RequestMapping(value = "/advertise/findAll")
	public List<AdvertiseContents> findAll();
	/**
	 * 
	* @Title: findByPage
	* @Description: 分页查询
	* @param paramMap
	* @return: String
	* @throws:
	 */
	@RequestMapping(value = "/advertise/findByPage")
	public String findByPage(@RequestParam Map<String,Object> paramMap);
	/**
	 * 
	* @Title: deleteById
	* @Description: 删除方法
	* @param id
	* @return: String
	* @throws:
	 */
	@RequestMapping(value = "/advertise/deleteById")
	public String deleteById(@RequestParam("id") String id);
	
	/**
	* @Title: add
	* @Description: 添加方法
	* @param: cmsAdContentsWithBLOBs
	* @return: String
	* @throws:
	*/
	@RequestMapping(value = "/advertise/add")
	public String add(@RequestBody(required = false) AdvertiseContents cmsAdContentsWithBLOBs);
	
	/**
	* @Title: update
	* @Description: 更新方法
	* @param: cmsAdContentsWithBLOBs
	* @return: String
	* @throws:
	*/
	@RequestMapping(value = "/advertise/update")
	public String update(@RequestBody(required = false) AdvertiseContents cmsAdContentsWithBLOBs);
	
	
	
	
	
}
