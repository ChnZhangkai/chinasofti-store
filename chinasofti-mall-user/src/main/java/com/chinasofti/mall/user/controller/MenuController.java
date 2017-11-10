package com.chinasofti.mall.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.user.service.impl.PtHrUserServiceImpl;
import com.chinasofti.mall.user.service.impl.PtMenuServiceImpl;

@RestController
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private PtMenuServiceImpl menuService;
	
	@RequestMapping("/getMenu")
	public List<PtMenu> getMenu(String pIds){
		List<PtMenu> menuList=menuService.getMenu(pIds);
		
		for (PtMenu ptMenu : menuList) {
			List<PtMenu> childMenuList=menuService.getMenu(ptMenu.getIds());
			ptMenu.setChildMenu(childMenuList);
		}
		return menuList;		
	}
}
