package com.chinasofti.app.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.PrefectureFeignClient;
import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
/**
 * 熔断类
 * @author chen
 *
 */
@Component
public class PrefectureFeignClientHystrix implements PrefectureFeignClient{

	@Override
	public List<GoodsPrefecture> findAll() {
		return new ArrayList<GoodsPrefecture>();
	}

	@Override
	public List<ChnGoodsOnline> findGoodsById(String ids) {
		return new ArrayList<ChnGoodsOnline>();
	}

}
