package com.chinasofti.mall.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.user.service.PtRoleService;
import com.google.gson.Gson;

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
	@ResponseBody
	public int save(@RequestBody PtRole ptRole) {
		return ptroleServiceImpl.save(ptRole);
	}
	/**
	 * 角色删除
	 * @return 返回信息是否成功
	 */
	@GetMapping("/select/{ids}")
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
	@PostMapping("/save")
	public int saveIds(@RequestBody PtRole ptRole) {
		return ptroleServiceImpl.saveIds(ptRole);	
	}
	@RequestMapping("/{id}")
	@ResponseBody
	public String showTree(@PathVariable String id) {
		Gson gson = new Gson();
		gson.toJson(ptroleServiceImpl.showTree(id));
		return gson.toJson(ptroleServiceImpl.showTree(id));
	}
}
