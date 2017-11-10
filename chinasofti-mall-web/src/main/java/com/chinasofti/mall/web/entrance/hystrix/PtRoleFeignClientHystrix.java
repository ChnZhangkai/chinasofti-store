package com.chinasofti.mall.web.entrance.hystrix;


import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.web.entrance.feign.PtRoleFeignClient;


public class PtRoleFeignClientHystrix implements PtRoleFeignClient{

	@Override
	public String show(String roleId) {
		return "系统繁忙";
	}

	@Override
	public String list() {
		return "系统繁忙";
	}

	@Override
	public int add(PtRole ptRole) {
		return 0;
	}

	@Override
	public int update(PtRole ptRole) {
		return 0;
	}

	@Override
	public int saveIds(PtRole ptRole) {
		return 0;
	}

}
