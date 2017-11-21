package com.chinasofti.mall.web.entrance.hystrix;


import org.springframework.stereotype.Component;
import com.chinasofti.mall.web.entrance.feign.MenuFeignClient;


@Component
public class PtMenuFeignClientHystrix implements MenuFeignClient{


	@Override
	public String getMenu(String pIds) {
		return null;
	}

}
