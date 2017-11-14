package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.PtOperator;
import com.chinasofti.mall.web.entrance.hystrix.PtOperatorFeignClientHystrix;

/**
 * 
 * @ClassName: PtOperatorFeignClient.java
 * @Description: TODO
 * @author 黄佳喜
 * @Date: 2017年11月14日 上午11:23:21
 * @parma <T>
 */
@FeignClient(name = "userService" , fallback = PtOperatorFeignClientHystrix.class)
public interface PtOperatorFeignClient {

	@RequestMapping(value = "/operator/add" , method = RequestMethod.POST)
	public String add(@RequestBody PtOperator ptOperator);

	@RequestMapping(value = "/operator/update" , method = RequestMethod.POST)
	public int update(@RequestBody PtOperator ptOperator);

	@RequestMapping(value = "/operator/delete" , method = RequestMethod.POST)
	public int delete(@RequestBody PtOperator ptOperator);
}
