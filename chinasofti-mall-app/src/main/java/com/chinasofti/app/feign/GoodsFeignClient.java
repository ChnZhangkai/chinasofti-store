package com.chinasofti.app.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.app.hystrix.GoodsFeignClientHystrix;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**分类消费类
 * 
 * @author gezhenlin
 *
 */
@FeignClient(name = "Goods-Service" ,fallback = GoodsFeignClientHystrix.class)
public interface GoodsFeignClient {

	/***
	 * 商品分类查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/goodsinfo/queryGoodList/{id}" ,method = RequestMethod.POST )
	public ResponseInfo queryGoodList(@PathVariable("id") String id);
  
	@RequestMapping(value = "/goodsinfo/queryGoodinfo/{ids}" ,method = RequestMethod.POST )
	public ResponseInfo queryGoodInfo(@PathVariable("ids") String ids);
  
}
