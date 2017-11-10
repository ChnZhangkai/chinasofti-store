package com.chinasofti.mall.web.entrance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.web.entrance.feign.PtRoleFeignClient;

/**
 * 
 * @ClassName: PtRoleController.java
 * @Description: TODO
 * @author 黄佳喜
 * @Date: 2017年11月9日 下午5:01:59
 * @parma <T>
 */
@RestController
@RequestMapping("/ptrole")
public class PtRoleController {
	@Autowired
	private PtRoleFeignClient ptRoleFeignClient;

	@RequestMapping("/{id}")
	@ResponseBody
	public String show(@PathVariable String id) {
		return ptRoleFeignClient.show(id);
	}

	@RequestMapping("/all")
	public String list() {
		return ptRoleFeignClient.list();
	}

	@PostMapping("/add")
	public int add(PtRole ptRole) {
		return ptRoleFeignClient.add(ptRole);
	}

	@PostMapping("/update")
	public int update(PtRole ptRole) {
		return ptRoleFeignClient.update(ptRole);
	}

	@PostMapping("/save")
	public int saveIds(String id, String ids) {
		System.out.println(id + ":....." + ids);
		PtRole ptRole = new PtRole();
		ptRole.setIds(id);
		ptRole.setNumbers(ids);
		return ptRoleFeignClient.saveIds(ptRole);
	}

	@RequestMapping("/index")
	public ModelAndView toIndex() {
		return new ModelAndView("/ptrole/role");
	}
}
