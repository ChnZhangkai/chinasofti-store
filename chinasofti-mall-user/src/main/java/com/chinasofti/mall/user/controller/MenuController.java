package com.chinasofti.mall.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.user.service.PtMenuService;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private PtMenuService menuServiceImpl;
	
	@RequestMapping("/getMenu")
	public List<PtMenu> getMenu(String pIds){
		List<PtMenu> menuList=menuServiceImpl.getMenu(pIds);
		
		for (PtMenu ptMenu : menuList) {
			List<PtMenu> childMenuList=menuServiceImpl.getMenu(ptMenu.getIds());
			ptMenu.setChildMenu(childMenuList);
		}
		return menuList;		
	}
	
	/**
	 * 展示菜单管理的菜单
	 * @param id
	 * @return
	 */
	@RequestMapping("/menuTree/{id}")
	public List<Tree> menuTreeManage(@PathVariable String id) {
		return menuServiceImpl.menuTreeManage(id);
	}
	
	/**
	 * 增加操作
	 * @param PtMenu 对象封装
	 * @return 新增的菜单操作的ids，作为页面传参
	 */
	@PostMapping("/add")
	public String add(@RequestBody PtMenu ptMenu) {	
		String str = menuServiceImpl.save(ptMenu);
		 return str;
	}
	
	/**
	 * 更新操作
	 * @param PtMenu 对象封装
	 * @return 更新影响的条数
	 */
	@PostMapping("/update")
	public int update(@RequestBody PtMenu ptMenu) {
		return menuServiceImpl.update(ptMenu);
	}
	
	
	/**
	 * 删除操作
	 * @param PtMenu 对象封装
	 * @return 删除影响的条数
	 */
	@RequestMapping("/delete")
	public int delete(@RequestBody PtMenu ptMenu) {
		return menuServiceImpl.delete(ptMenu.getIds());
	}
}
