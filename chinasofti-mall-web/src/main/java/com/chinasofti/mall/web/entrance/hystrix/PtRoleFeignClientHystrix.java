package com.chinasofti.mall.web.entrance.hystrix;


import java.util.List;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.web.entrance.feign.PtRoleFeignClient;


public class PtRoleFeignClientHystrix implements PtRoleFeignClient{

	@Override
	public List<Tree> show(String roleId) {
		return null;
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

	@Override
	public List<Tree> menuTree(String id) {
		return null;
	}

}
