package com.chinasofti.mall.web.entrance.hystrix;
 

import java.util.List;
import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.web.entrance.feign.PtRoleFeignClient;

import net.sf.json.JSONObject;


public class PtRoleFeignClientHystrix implements PtRoleFeignClient{

	@Override
	public List<Tree> show(String roleId) {
		return null;
	}

	@Override
	public JSONObject list(PtRole ptRole) {
		JSONObject js = new JSONObject();
		return js;
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

	@Override
	public int saveMenuIds(PtRole ptRole) {
		return 0;
	}

	@Override
	public int deleteByIds(String ids) {
		return 0;
	}

}
