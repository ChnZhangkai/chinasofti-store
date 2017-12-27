package com.chinasofti.mall.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.user.mapper.PtMenuMapper;
import com.chinasofti.mall.user.service.PtMenuService;

@Service
public class PtMenuServiceImpl implements PtMenuService {

	@Autowired
	private PtMenuMapper ptMenuMapper;

	
	@Override
	public List<PtMenu> getMenu(String pids) {
		return ptMenuMapper.selectByPid(pids);
	}

	@Override
	public String save(PtMenu ptMenu) {
		String str = UUIDUtils.getUuid();
		ptMenu.setIds(str);
		ptMenu.setCeratetime(StringDateUtil.convertToSqlFormat(StringDateUtil.getStringTime()));
		ptMenuMapper.insertSelective(ptMenu);
		return  str;
	}


	
	@Override
	public List<PtMenu> findAll() {
		return ptMenuMapper.selectByExample(null);
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public List<Tree> menuTreeManage(String roleId) {
		Tree tree = null;
		List<Tree> list = new ArrayList<Tree>();
		//一级菜单
		List<PtMenu> menus = ptMenuMapper.selectByPid("00");
		for (PtMenu ptMenu : menus) {
			tree = getTree(ptMenu);
			//二级菜单
			List<PtMenu> menus2 = ptMenuMapper.selectByPid(ptMenu.getIds());
			for (PtMenu ptMenu2 : menus2) {
				Tree tree2 = getTree(ptMenu2);
				//三级菜单 操作
				List<PtMenu> menus3 = ptMenuMapper.selectByPid(ptMenu2.getIds());
				for (PtMenu ptMenu3 : menus3) {
					Tree tree3 = getTree(ptMenu3);
					tree2.getChildren().add(tree3);
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
		tree.setIconCls(menu.getLogo());
		tree.setChildren(new ArrayList<Tree>());
		return tree;
	}

	@Override
	public int update(PtMenu ptMenu) {
		ptMenu.setUpdatetime(StringDateUtil.convertToSqlFormat(StringDateUtil.getStringTime()));
		return ptMenuMapper.updateByPrimaryKeySelective(ptMenu);
	}


	@Override
	public int delete(String ids) {
		return ptMenuMapper.deleteByPrimaryKey(ids);
	}

}