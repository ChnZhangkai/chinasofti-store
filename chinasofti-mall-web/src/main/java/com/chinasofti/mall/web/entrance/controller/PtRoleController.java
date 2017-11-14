package com.chinasofti.mall.web.entrance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.Tree;
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

	/**
	 * 展示角色的操作信息
	 * @param id
	 * @return
	 */
	@RequestMapping("/{id}")
	public List<Tree> show(@PathVariable String id) {
		return ptRoleFeignClient.show(id);
	}

	/**
	 * 列表展示所有的角色
	 * @return
	 */
	@RequestMapping("/all")
	public String list() {
		return ptRoleFeignClient.list();
	}

	/**
	 * 添加角色
	 * @param ptRole
	 * @return
	 */
	@PostMapping("/add")
	public int add(PtRole ptRole) {
		return ptRoleFeignClient.add(ptRole);
	}

	/**
	 * 修改角色信息
	 * @param ptRole
	 * @return
	 */
	@PostMapping("/update")
	public int update(PtRole ptRole) {
		return ptRoleFeignClient.update(ptRole);
	}

	/**
	 * 保存页面选择的操作
	 * @param id 角色的ids
	 * @param ids 角色的操作ids
	 * @return
	 */
	@PostMapping("/save")
	public int saveIds(String id, String ids) {
		PtRole ptRole = new PtRole();
		ptRole.setIds(id);
		ptRole.setNumbers(ids);
		return ptRoleFeignClient.saveIds(ptRole);
	}
	/**
	 * 菜单树展示
	 * @param id 角色的ids
	 * @return
	 */
	@RequestMapping("/menu/{id}")
	public List<Tree> menuTree(@PathVariable String id) {
		return ptRoleFeignClient.menuTree(id);
	}

	/**
	 * 角色页面跳转
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex() {
		return new ModelAndView("/ptrole/role");
	}
}
