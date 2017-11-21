package com.chinasofti.app.hystrix;



import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.GoodsInfoFeignClient;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 熔断类
 * @author gezhenlin
 *
 */
@Component
public class GoodsFeignClientHystrix implements GoodsInfoFeignClient{

	@Override
	public ResponseInfo queryGoodList(String classId) {
		return new ResponseInfo();
	}

	@Override
	public ResponseInfo queryGoodInfo(String ids) {
		return new ResponseInfo();
	}

}
