package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
 
import com.chinasofti.mall.common.entity.PtOperator;
import com.chinasofti.mall.web.entrance.feign.PtOperatorFeignClient;

/**
 * 
 * @ClassName: PtOperatorController.java
 * @Description: 项目入口客户端
 * @author 黄佳喜
 * @Date: 2017年11月14日 上午11:23:32
 * @parma <T>
 */  
@RestController
@RequestMapping("/operator")
public class PtOperatorController {
	@Autowired
	private PtOperatorFeignClient ptOperatorFeignClient;
	
	/**
	 * 增加操作
	 * @param ptOperator 对象封装
	 * @return 新增的权限操作的ids，作为页面传参
	 */
	@PostMapping("/add")
	public String save(PtOperator ptOperator) {
		return ptOperatorFeignClient.add(ptOperator);
	}
	/**
	 * 更新操作
	 * @param ptOperator 对象封装
	 * @return 更新影响的条数
	 */
	@PostMapping("/update")
	public int update(PtOperator ptOperator) {
		return ptOperatorFeignClient.update(ptOperator);
	}
	/**
	 * 删除操作
	 * @param ptOperator 对象封装
	 * @return 删除影响的条数
	 */
	@PostMapping("/delete")
	public int delete(PtOperator ptOperator) {
		return ptOperatorFeignClient.delete(ptOperator);
	}
	
	
	//权限设置的管理页面
	@RequestMapping("/index")
	public ModelAndView allMenu() {
		return new ModelAndView("/ptrole/operator");
	}
	
}
