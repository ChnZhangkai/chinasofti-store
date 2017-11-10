package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.PyChildGoodsorder;
import com.chinasofti.mall.web.entrance.hystrix.ChildGoodsorderFeignClientHystrix;

import net.sf.json.JSONObject;

@FeignClient(name="goodsorder-service" , fallback=ChildGoodsorderFeignClientHystrix.class)
public interface ChildGoodsorderFeign {
	
	@RequestMapping("childorder/select/{ids}")
	public PyChildGoodsorder findById(@PathVariable("ids") String id) ;

	@RequestMapping("childorder/delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) ;

	@RequestMapping(value="childorder/update" , method = RequestMethod.POST)
	public String update(@RequestBody(required=false) PyChildGoodsorder childGoodsorder); 
	

	@RequestMapping(value="childorder/add" , method = RequestMethod.POST)
	public String add(@RequestBody(required=false) PyChildGoodsorder childGoodsorder) ;
	
	@RequestMapping(value="childorder/list" , method = RequestMethod.POST)
	public JSONObject selectByChildorderClass(@RequestBody(required=false) PyChildGoodsorder childGoodsorder);

}
