package com.chinasofti.app.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.GoodsClassFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;

/**
 * 熔断类
 * @author gezhenlin
 *
 */
@Component
public class GoodsClassFeignClientHystrix implements GoodsClassFeignClient{

	@Override
	public List<ChnGoodsClass> queryClass(String classId) {
		return new ArrayList<ChnGoodsClass>();
	}

}
