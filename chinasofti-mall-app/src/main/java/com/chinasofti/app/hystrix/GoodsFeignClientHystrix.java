package com.chinasofti.app.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.GoodsFeignClient;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 熔断类
 * @author gezhenlin
 *
 */
@Component
public class GoodsFeignClientHystrix implements GoodsFeignClient{

	@Override
	public List<ChnGoodsinfo>queryGoodList(String classId) {
		return new ArrayList<ChnGoodsinfo>();
	}

	@Override
	public ResponseInfo queryGoodInfo(String ids) {
		return new ResponseInfo();
	}

}
