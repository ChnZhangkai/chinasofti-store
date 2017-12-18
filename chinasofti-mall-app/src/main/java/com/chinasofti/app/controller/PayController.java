package com.chinasofti.app.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
* @ClassName: PayController
* @Description: 支付测试接口
* @author km
* @date 2017年12月17日 下午9:24:10 
*
 */
@RestController
public class PayController {
	
	@RequestMapping("submitPay")
	public String submitPay() {
		return "pay success";	
	}
}
