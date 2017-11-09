package com.chinasofti.mall.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.user.mapper.PtMenuMapper;
import com.chinasofti.mall.user.mapper.PtRoleMapper;
import com.chinasofti.mall.user.service.PtRoleService;

@Service
public class PtRoleServiceImpl implements PtRoleService {

	@Autowired
	private PtRoleMapper ptRoleMapper;
	@Autowired
	private PtMenuMapper ptMenuMapper;

	@Override
	public int save(PtRole ptRole) {
		return ptRoleMapper.insertSelective(ptRole);
	}

	@Override
	public PtRole findById(String ids) {
		return ptRoleMapper.selectByPrimaryKey(ids);
	}

	@Override
	public List<PtRole> findAll() {
		return ptRoleMapper.selectByExample(null);
	}

	@Override
	public int update(PtRole ptRole) {
		return ptRoleMapper.updateByPrimaryKeySelective(ptRole);
	}

	@Override
	public int add2(String ids) {
		String[] arr = ids.split(",");
		for (String id : arr) {
			PtMenu ptMenu = ptMenuMapper.selectByPrimaryKey(id);
			while (null != ptMenu.getPids()) {
				ptMenuMapper.selectByPrimaryKey(ptMenu.getPids());
			}
		}
		return ptRoleMapper.add2(arr);
	}

	@Override
	public List<Tree> show(String roleId) {
		List<String> roleMenuids = ptRoleMapper.getRoleMenuids(roleId);
		List<PtMenu> roleMenus = new ArrayList<PtMenu>();
		Tree tree = null;
		List<Tree> list = new ArrayList<Tree>();
		//一级菜单
		List<PtMenu> menus = ptMenuMapper.selectByPid("000");
		for (String id : roleMenuids) {
			roleMenus.add(ptMenuMapper.selectByPrimaryKey(id));
		}
		for (PtMenu ptMenu : menus) {
			tree = getTree(ptMenu);
			//二级菜单
			List<PtMenu> menus2 = ptMenuMapper.selectByPid(ptMenu.getIds());
			for (PtMenu ptMenu2 : menus2) {
				Tree tree2 = getTree(ptMenu2);
				if (roleMenus.contains(ptMenu2)) {
					tree2.setChecked(true);
				}
				tree.getChildren().add(tree2);
			}
			list.add(tree);
		}
		return list;
	}
	
	/**
	 * 将菜单转换为树结构
	 * @param menu
	 * @return
	 */
	private Tree getTree(PtMenu menu){
		Tree tree = new Tree();
		tree.setId(menu.getIds());
		tree.setText(menu.getMenuname());
		tree.setChildren(new ArrayList<Tree>());
		return tree;
	}
}
