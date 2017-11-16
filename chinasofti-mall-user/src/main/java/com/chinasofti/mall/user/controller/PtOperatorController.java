package com.chinasofti.mall.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtOperator;
import com.chinasofti.mall.user.service.PtOperatorService;
/**
 * 
 * @ClassName: PtOperatorController.java
 * @Description: 菜单权限操作服务端
 * @author 黄佳喜
 * @Date: 2017年11月14日 上午11:39:44
 * @parma <T>
 */
@RequestMapping("/operator")
@RestController
public class PtOperatorController {
	
	@Autowired
	private PtOperatorService ptOperatorServiceImpl;
	/**
	 * 增加操作
	 * @param ptOperator 对象封装
	 * @return 新增的权限操作的ids，作为页面传参
	 */
	@PostMapping("/add")
	public String save(@RequestBody PtOperator ptOperator) {
		return ptOperatorServiceImpl.save(ptOperator);
	}
	/**
	 * 更新操作
	 * @param ptOperator 对象封装
	 * @return 更新影响的条数
	 */
	@PostMapping("/update")
	public int update(@RequestBody PtOperator ptOperator) {
		return ptOperatorServiceImpl.update(ptOperator);
	}
	/**
	 * 删除操作
	 * @param ptOperator 对象封装
	 * @return 删除影响的条数
	 */
	@RequestMapping("/delete")
	public int delete(@RequestBody PtOperator ptOperator) {
		return ptOperatorServiceImpl.delete(ptOperator.getIds());
	}
	
}
