package com.chinasofti.mall.user.service;

import java.util.List;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.entity.Tree;

public interface PtMenuService{

	List<PtMenu> getMenu(String pids);
	
	List<Tree> menuTreeManage(String roleId);
	
	String save(PtMenu ptMenu);

	List<PtMenu> findAll();

	int update(PtMenu ptMenu);

	int delete(String ids);


}
