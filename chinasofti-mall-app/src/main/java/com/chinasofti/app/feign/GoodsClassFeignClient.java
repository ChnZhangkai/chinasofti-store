package com.chinasofti.app.feign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.app.hystrix.GoodsClassFeignClientHystrix;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**分类消费类
 * 
 * @author gezhenlin
 *
 */
@FeignClient(name = "Goods-Service" ,fallback = GoodsClassFeignClientHystrix.class)
public interface GoodsClassFeignClient {

	/***
	 * 商品分类查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/goodsClass/queryClass" ,method = RequestMethod.POST )
	public ResponseInfo queryClass(@PathVariable("classId") String classId);
}
