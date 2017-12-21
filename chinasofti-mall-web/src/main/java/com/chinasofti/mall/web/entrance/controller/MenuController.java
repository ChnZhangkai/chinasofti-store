package com.chinasofti.mall.web.entrance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PtMenu;
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
	
	
	@RequestMapping("/menu")
	public ModelAndView toUser() {
		return new ModelAndView("/log/menu");
	}
	
	/**
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
	
	/**
	 * @Title: menuTree
	 * @Description: 查询所有操作管理菜单
	 * @return List<Tree>
	 * @throws
	 */
	@RequestMapping("/tree")
	public List<Tree> menuTree() {
		return ptRoleFeignClient.menuTree("0");
	}
	
	/**
	 * @Title: menuTreeManage
	 * @Description: 查询所有菜单管理
	 * @return List<Tree>
	 * @throws
	 */
	@RequestMapping("/menuTree")
	public List<Tree> menuTreeManage() {
		return menuFeignClient.menuTreeManage("0");
	}
	
	/**
	 * 增加操作
	 * @param PtMenu 对象封装
	 * @return 新增的菜单操作的ids，作为页面传参
	 */
	@PostMapping("/add")
	public String add(PtMenu ptMenu) {
		return menuFeignClient.add(ptMenu);
	}
	
	/**
	 * 更新操作
	 * @param PtMenu 对象封装
	 * @return 更新影响的条数
	 */
	@PostMapping("/update")
	public int update(PtMenu ptMenu) {
		return menuFeignClient.update(ptMenu);
	}
	
	/**
	 * 删除操作
	 * @param PtMenu 对象封装
	 * @return 删除影响的条数
	 */
	@PostMapping("/delete")
	public int delete(PtMenu ptMenu) {
		return menuFeignClient.delete(ptMenu);
	}
}
