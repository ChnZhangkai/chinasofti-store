package com.chinasofti.mall.web.entrance.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUser;
import com.chinasofti.mall.web.entrance.hystrix.PtUserFeignClientHystrix;

import net.sf.json.JSONObject;

@FeignClient(name = "userService" , fallback = PtUserFeignClientHystrix.class)
public interface PtUserFeignClient {
	
	@RequestMapping("user/select/{ids}")
	public PtUser findById(@PathVariable("ids") String id) ;

	@RequestMapping("user/delete/{ids}")
	public String deleteById(@PathVariable("ids") String id) ;

	@RequestMapping(value="user/update" , method = RequestMethod.POST)
	public String update(@RequestBody(required=false) PtUser ptUser); 
	
	@RequestMapping(value="user/add" , method = RequestMethod.POST)
	public String add(@RequestBody(required=false) PtUser ptUser) ;
		
	@RequestMapping(value="user/list" , method = RequestMethod.POST)
	public JSONObject selectByPtUser(@RequestBody(required=false) PtUser ptUser);
	
	@RequestMapping("user/findRoleName/{ids}")
	public String findUserRoleName(@PathVariable("ids") String ids);
	
	@RequestMapping("user/updateRoleUser")
	public int updateRoleUser(@RequestBody(required=false) PtRoleUser ptRoleUser);

}
