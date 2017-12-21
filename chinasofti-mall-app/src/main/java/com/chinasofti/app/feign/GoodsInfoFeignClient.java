package com.chinasofti.app.feign;


import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.GoodsFeignClientHystrix;
import com.chinasofti.mall.common.entity.goods.ChnGoodsInfoVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.SkuGoodsVo;

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
	public List<ChnGoodsinfo> queryGoodList(@RequestParam("id") String id);
  
	@RequestMapping(value = "/goodsInfo/queryGoodsInfo")
	public ChnGoodsInfoVo queryGoodInfo(@RequestParam("ids") String ids);
	
	@RequestMapping(value = "/goodsInfo/queryGoodsInfoList")
	public List<ChnGoodsinfo> queryGoodsInfoList(@RequestBody ChnGoodsinfo goodsInfo);
	
	@RequestMapping(value = "/goodsInfo/checkGoodsInfoById")
	public ChnGoodsinfo checkGoodsInfoById(@RequestParam("ids")String ids);
	
	@RequestMapping(value = "/goodsInfo/findSkuByGoodsIds")
	public List<SkuGoodsVo> findSkuByGoodsIds(@RequestParam("ids")String ids);
  
}
