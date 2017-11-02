/**
 * 
 */
package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.SpUser;
import com.chinasofti.mall.web.entrance.feign.SpUserFeignClient;

/**
 * @ClassName: SpUserController.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:51:30
 * @parma <T>
 */
@RestController
@RequestMapping("/spUser")
public class SpUserController {
    @Autowired
	private SpUserFeignClient spUserFeignClient;
    
    @RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/spuser/spuser");
	}
	
	@RequestMapping("/list")
	public String selectBySpUser(SpUser spUser){
		
		String jsonlist = spUserFeignClient.selectBySpUser(spUser);
		return jsonlist;
		
	}
}
