package com.chinasofti.app.hystrix;



import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.GoodsInfoFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsInfoVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.SkuGoodsVo;

/**
 * 熔断类
 * @author gezhenlin
 *
 */
@Component
public class GoodsFeignClientHystrix implements GoodsInfoFeignClient{

	@Override
	public List<ChnGoodsinfo> queryGoodList(String classId) {
		return new ArrayList<ChnGoodsinfo>();
	}

	@Override
	public ChnGoodsInfoVo queryGoodInfo(String ids) {
		return new ChnGoodsInfoVo();
	}

	@Override
	public List<ChnGoodsinfo> queryGoodsInfoList(ChnGoodsinfo goodsInfo) {
		return new ArrayList<ChnGoodsinfo>();
	}

	@Override
	public ChnGoodsinfo checkGoodsInfoById(String ids) {
		
		return new ChnGoodsinfo();
	}

	@Override
	public List<SkuGoodsVo> findSkuByGoodsIds(String ids) {
		
		return new ArrayList<>();
	}

	
	
}
