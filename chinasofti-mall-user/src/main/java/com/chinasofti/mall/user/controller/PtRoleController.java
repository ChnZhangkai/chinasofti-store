package com.chinasofti.mall.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.user.service.PtRoleService;

/**
 * 商城 角色
 * 微服务端
 * @author 黄佳喜
 *
 */
@RestController
@RequestMapping("/ptrole")
public class PtRoleController {
	@Autowired
	private PtRoleService ptroleServiceImpl;

	/**
	 * 角色增加
	 * @return 返回信息是否成功
	 */
	@PostMapping("/add")
	public int save(@RequestBody PtRole ptRole) {
		return ptroleServiceImpl.save(ptRole);
	}
	/**
	 * 角色删除
	 * @return 返回信息是否成功
	 */
	@GetMapping("/select/{ids}")
	public PtRole delete(@PathVariable String ids) {
		return ptroleServiceImpl.findById(ids);
	}
	/**
	 * 查询所有 列表展示
	 * @return 返回信息是否成功
	 */
	@GetMapping("/all")
	public String findAll() {
		return ptroleServiceImpl.findAll();
	}
	/**
	 * 角色更新
	 * @return 返回信息是否成功
	 */
	@PostMapping("/update")
	public int update(@RequestBody PtRole ptRole) {
		return ptroleServiceImpl.update(ptRole);
	}
	/**
	 * 保存角色的操作id
	 * @param ptRole
	 * @return 
	 */
	@PostMapping("/save")
	public int saveIds(@RequestBody PtRole ptRole) {
		return ptroleServiceImpl.saveIds(ptRole);	
	}
	/**
	 * 展示角色的操作权限
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public List<Tree> operatorTree(@PathVariable String id) {
		List<Tree> list = ptroleServiceImpl.showTree(id);
		return list;
	}
	
	/**
	 * 展示角色的菜单权限
	 * @param id
	 * @return
	 */
	@RequestMapping("/menu/{id}")
	public List<Tree> menuTree(@PathVariable String id) {
		return ptroleServiceImpl.menuTree(id);
	}
}

