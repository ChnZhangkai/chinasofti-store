package com.chinasofti.mall.user.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.user.service.PtRoleService;

/**
 * 商城 角色
 * 
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
	@ResponseBody
	public int save(PtRole ptRole) {
		return ptroleServiceImpl.save(ptRole);
	}
	/**
	 * 角色删除
	 * @return 返回信息是否成功
	 */
	@GetMapping("/delete/{ids}")
	@ResponseBody
	public PtRole delete(@PathVariable String ids) {
		return ptroleServiceImpl.findById(ids);
	}
	/**
	 * 查询所有
	 * @return 返回信息是否成功
	 */
	@GetMapping("/all")
	@ResponseBody
	public List<PtRole> findAll() {
		return ptroleServiceImpl.findAll();
	}
	/**
	 * 角色更新
	 * @return 返回信息是否成功
	 */
	@PostMapping("/update")
	@ResponseBody
	public int update(PtRole ptRole) {
		return ptroleServiceImpl.update(ptRole);
	}
	
	public int add2(String ids) {
		return ptroleServiceImpl.add2(ids);	
	}
	@RequestMapping("/show")
	public List<Tree> show(String roleId) {
		return ptroleServiceImpl.show(roleId);
	}
}
