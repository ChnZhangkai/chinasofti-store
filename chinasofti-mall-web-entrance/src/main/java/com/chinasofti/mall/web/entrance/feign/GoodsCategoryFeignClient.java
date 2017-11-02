package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.web.entrance.hystrix.GoodsCategoryFeignClientHystrix;

/**
 * Feign服务调用+负载均衡
 * @author Administrator
 *
 */
@FeignClient(name = "goodscategoryService" , fallback = GoodsCategoryFeignClientHystrix.class)
public interface GoodsCategoryFeignClient {
	
	/**
	 * 列表及条件查询
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/goods/select" , method = RequestMethod.POST)
	public String selectByGoodsCategory(@RequestBody(required = false) Goodscategory goodscategory);
	
	@RequestMapping(value = "/goods/delete/{ids}" , method =RequestMethod.POST)
	public int deleteGoodsCategory(@PathVariable("ids") Integer ids);
	
	@RequestMapping(value = "/goods/select/{ids}" , method = RequestMethod.POST)
	public Goodscategory selectById(@PathVariable("ids") Integer ids);
	
	@RequestMapping(value = "/goods/update" , method = RequestMethod.POST)
	public int updateGoodsCategoryById(@RequestBody(required = false) Goodscategory goodscategory);
	
	@RequestMapping(value = "/goods/save" , method = RequestMethod.POST)
	public int saveGoodsCategoryById(@RequestBody(required = false) Goodscategory goodscategory);
	
}
