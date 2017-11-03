package com.chinasofti.mall.web.entrance.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.web.entrance.hystrix.MainGoodsorderFeignClientHystrix;

@FeignClient(name="main-goodsorder-service" , fallback=MainGoodsorderFeignClientHystrix.class)
public interface MainGoodsorderFeign {
	
	@RequestMapping("mainorder/select/{ids}")
	public PyMainGoodsorder findById(@PathVariable("ids") String id) ;

	@RequestMapping("mainorder/delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) ;

	@RequestMapping(value="mainorder/update" , method = RequestMethod.POST)
	public String update(@RequestBody(required=false) PyMainGoodsorder mainGoodsorder); 
	

	@RequestMapping(value="mainorder/add" , method = RequestMethod.POST)
	public String add(@RequestBody(required=false) PyMainGoodsorder mainGoodsorder) ;
	
	@RequestMapping(value="mainorder/list" , method = RequestMethod.POST)
	public List<PyMainGoodsorder> selectByExample(@RequestBody(required=false) PyMainGoodsorder mainGoodsorder);

}
