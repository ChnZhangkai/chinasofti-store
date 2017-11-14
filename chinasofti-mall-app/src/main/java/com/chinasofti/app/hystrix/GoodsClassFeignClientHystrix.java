package com.chinasofti.app.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.GoodsClassFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 熔断类
 * @author gezhenlin
 *
 */
@Component
public class GoodsClassFeignClientHystrix implements GoodsClassFeignClient{

	@Override
	public ResponseInfo queryClass(String classId) {
		return new ResponseInfo();
	}

}
