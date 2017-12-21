package com.chinasofti.mall.web.entrance.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.web.entrance.hystrix.PtMenuFeignClientHystrix;

@FeignClient(name = "userService" , fallback = PtMenuFeignClientHystrix.class)
public interface MenuFeignClient {
	
	@RequestMapping(value = "/menu/getMenu" )
	public String getMenu(@RequestParam(value = "pIds")String pIds);

	@RequestMapping("/menu/menuTree/{id}")
	public List<Tree> menuTreeManage(@PathVariable("id") String id);

	@RequestMapping(value = "/menu/add" , method = RequestMethod.POST)
	public String add(@RequestBody PtMenu ptMenu);

	@RequestMapping(value = "/menu/update" , method = RequestMethod.POST)
	public int update(@RequestBody PtMenu ptMenu);

	@RequestMapping(value = "/menu/delete" , method = RequestMethod.POST)
	public int delete(@RequestBody PtMenu ptMenu);
	
}
