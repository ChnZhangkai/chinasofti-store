package com.chinasofti.app.feign;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.GoodsClassFeignClientHystrix;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;

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
	@RequestMapping(value = "/goodsClass/queryClass")
	public List<ChnGoodsClass> queryClass(@RequestParam("classId") String classId);
}
