package com.chinasofti.app.feign;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.app.hystrix.GoodsFeignClientHystrix;
import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;

/**
 * 商品专区
 * @author chen
 *
 */
@FeignClient(name="Goods-Service",fallback = GoodsFeignClientHystrix.class)
public interface PrefectureFeignClient {

	/**
	 * 查询专区
	 */
	@RequestMapping(value="/prefecture/findAll")
	public List<GoodsPrefecture> findAll();
	/**
	 * 根据专区ids查询商品列表
	 */
	@RequestMapping(value="/prefecture/findGoods")
	public List<ChnGoodsOnline> findGoodsById(@RequestBody(required = false) String ids);
}
