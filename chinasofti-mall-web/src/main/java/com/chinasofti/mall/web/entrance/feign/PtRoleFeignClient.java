package com.chinasofti.mall.web.entrance.feign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.web.entrance.hystrix.PtRoleFeignClientHystrix;

/**
 * @ClassName: PtRoleFeignClient.java
 * @Description: TODO
 * @author 黄佳喜
 * @Date: 2017年11月9日 下午5:05:14
 * @parma <T>
 */
@FeignClient(name = "userService" , fallback = PtRoleFeignClientHystrix.class)
public interface PtRoleFeignClient{
	
	@RequestMapping("/ptrole/{id}")
	@ResponseBody
	public String show(@PathVariable("id") String id);
	
	
	@RequestMapping("/ptrole/all")
	public String list();

	@RequestMapping(value = "/ptrole/add" , method = RequestMethod.POST)
	public int add(@RequestBody PtRole ptRole);

	@RequestMapping(value = "/ptrole/update" , method = RequestMethod.POST)
	public int update(@RequestBody PtRole ptRole);

	@RequestMapping(value = "/ptrole/save" , method = RequestMethod.POST)
	public int saveIds(@RequestBody PtRole ptRole);
	
	
}