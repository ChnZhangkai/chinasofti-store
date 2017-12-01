package com.chinasofti.mall.web.entrance.hystrix;


import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUser;
import com.chinasofti.mall.web.entrance.feign.PtUserFeignClient;

import net.sf.json.JSONObject;

@Component
public class PtUserFeignClientHystrix implements PtUserFeignClient{

	@Override
	public PtUser findById(String id) {
		return new PtUser();
	}

	@Override
	public String deleteById(String id) {
		return null;
	}

	@Override
	public String update(PtUser ptUser) {
		return null;
	}

	@Override
	public String add(PtUser ptUser) {
		return null;
	}

	@Override
	public JSONObject selectByPtUser(PtUser ptUser) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("total", 0);
		jsonObject.put("rows", new ArrayList<>());
		return jsonObject;
	}

	@Override
	public String findUserRoleName(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int updateRoleUser(PtRoleUser ptRoleUser) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String findByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
