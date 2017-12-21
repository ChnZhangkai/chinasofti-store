package com.chinasofti.mall.web.entrance.hystrix;


import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.web.entrance.feign.MenuFeignClient;


@Component
public class PtMenuFeignClientHystrix implements MenuFeignClient{


	@Override
	public String getMenu(String pIds) {
		return null;
	}

	
	@Override
	public List<Tree> menuTreeManage(String id) {
		return null;
	}


	
	@Override
	public String add(PtMenu ptMenu) {
		return "添加成功";
	}


	public int update(PtMenu ptMenu) {
		return 0;
	}


	@Override
	public int delete(PtMenu ptMenu) {
		return 0;
	}

}
