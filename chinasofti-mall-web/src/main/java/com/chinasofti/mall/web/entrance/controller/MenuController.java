package com.chinasofti.mall.web.entrance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.web.entrance.feign.MenuFeignClient;
import com.chinasofti.mall.web.entrance.feign.PtRoleFeignClient;

/**
 * 
* @ClassName: MenuController
* @Description: 菜单管理
* @author lixhongwu@163.com
* @date 2017年11月10日 下午4:02:29 
*
 */
@RestController
@RequestMapping("menu")
public class MenuController {
	@Autowired
	MenuFeignClient menuFeignClient;
	@Autowired
	private PtRoleFeignClient ptRoleFeignClient;
	
	/**
	 * 
	 * @Title: getMenu
	 * @Description: 根据pids查询所有菜单
	 * @param pIds
	 * @return 参数
	 * @return String    返回类型
	 * @throws
	 */
	@RequestMapping("/getMenu")
	public String getMenu(String pIds) {
		String jsonList = menuFeignClient.getMenu(pIds);
		return jsonList;
	}
	@RequestMapping("/tree")
	public List<Tree> menuTree() {
		return ptRoleFeignClient.menuTree("0");
	}
}
