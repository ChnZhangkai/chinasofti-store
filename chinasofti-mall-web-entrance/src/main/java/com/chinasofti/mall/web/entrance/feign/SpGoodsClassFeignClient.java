package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.ChnGoodsClass;
import com.chinasofti.mall.web.entrance.hystrix.SpGoodsClassFeignClientHystrix;

import net.sf.json.JSONObject;

/**
 * Feign服务调用+负载均衡
 * @author Administrator
 *
 */
@FeignClient(name = "ChnGoodsClassService" , fallback = SpGoodsClassFeignClientHystrix.class)
public interface SpGoodsClassFeignClient {
	
	/**
	 * 列表及条件查询
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/goods/select" , method = RequestMethod.POST)
	public JSONObject selectByGoodsClass(@RequestBody(required = false) ChnGoodsClass chnGoodsClass);
	
	/**
	 * 根据ID删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/goods/delete/{ids}" , method =RequestMethod.POST)
	public int deleteGoodsClassById(@PathVariable("ids") String ids);
	
	/**
	 * 根据ID查找
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/goods/select/{ids}" , method = RequestMethod.POST)
	public ChnGoodsClass selectGoodsClassById(@PathVariable("ids") String ids);
	
	/**
	 * 根据ID修改
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/goods/update" , method = RequestMethod.POST)
	public int updateGoodsClass(@RequestBody(required = false) ChnGoodsClass chnGoodsClass);
	
	/**
	 * 增加
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping(value = "/goods/save" , method = RequestMethod.POST)
	public int saveGoodsClass(@RequestBody(required = false) ChnGoodsClass chnGoodsClass);
	
}
