package com.chinasofti.app.feign;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.GoodsFeignClientHystrix;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.utils.ResponseInfo;
 
/**分类消费类
 * 
 * @author gezhenlin
 *
 */
@FeignClient(name = "Goods-Service" ,fallback = GoodsFeignClientHystrix.class)
public interface GoodsInfoFeignClient {

	/***
	 * 商品分类查询
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/goodsInfo/queryGoodsList")
	public ResponseInfo queryGoodList(@RequestParam("id") String id);
  
	@RequestMapping(value = "/goodsInfo/queryGoodsInfo")
	public ResponseInfo queryGoodInfo(@RequestParam("ids") String ids);
	
	@RequestMapping(value = "/goodsInfo/queryGoodsInfoList")
	public ResponseInfo queryGoodsInfoList(@RequestBody ChnGoodsinfo goodsInfo);
  
}
