package com.chinasofti.mall.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.entity.PtOperator;
import com.chinasofti.mall.common.entity.PtOperatorExample;
import com.chinasofti.mall.common.entity.PtOperatorExample.Criteria;
import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.PtRoleOperator;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.user.mapper.PtMenuMapper;
import com.chinasofti.mall.user.mapper.PtOperatorMapper;
import com.chinasofti.mall.user.mapper.PtRoleMapper;
import com.chinasofti.mall.user.service.PtRoleService;

import net.sf.json.JSONObject;


@Service
public class PtRoleServiceImpl implements PtRoleService {

	@Autowired
	private PtRoleMapper ptRoleMapper;
	@Autowired
	private PtMenuMapper ptMenuMapper;
	@Autowired
	private PtOperatorMapper ptOperatorMapper;
	@Override
	public int save(PtRole ptRole) {
		ptRole.setIds(getIds());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		ptRole.setCreatetime(time);
		return ptRoleMapper.insertSelective(ptRole);
	}

	@Override
	public PtRole findById(String ids) {
		return ptRoleMapper.selectByPrimaryKey(ids);
	}

	@Override
	public String findAll() {
		JSONObject map = new JSONObject();
		map.put("rows", ptRoleMapper.selectByExample(null));
		map.put("total", ptRoleMapper.countByExample(null));
		return map.toString();
	}

	@Override
	public int update(PtRole ptRole) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		ptRole.setUpdatetime(time);
		return ptRoleMapper.updateByPrimaryKeySelective(ptRole);
	}

	@Override
	public List<Tree> menuTree(String roleId) {
		//查出角色有的操作
		List<String> operatorIds = ptRoleMapper.getRoleOperatorIds(roleId);
		List<PtOperator> roleOperators = new ArrayList<PtOperator>();
		for (String id : operatorIds) {
			roleOperators.add(ptOperatorMapper.selectByPrimaryKey(id));
		}
		Tree tree = null;
		List<Tree> list = new ArrayList<Tree>();
		//一级菜单
		List<PtMenu> menus = ptMenuMapper.selectByPid("000");
		for (PtMenu ptMenu : menus) {
			tree = getTree(ptMenu);
			//二级菜单
			List<PtMenu> menus2 = ptMenuMapper.selectByPid(ptMenu.getIds());
			for (PtMenu ptMenu2 : menus2) {
				Tree tree2 = getTree(ptMenu2);
				//三级菜单 操作
				PtOperatorExample example = new PtOperatorExample();
				Criteria criteria = example.createCriteria();
				criteria.andMenuidsEqualTo(ptMenu2.getIds());
				List<PtOperator> operators = ptOperatorMapper.selectByExample(example);
				for (PtOperator ptOperator : operators) {
					Tree tree3 = getOperatorTree(ptOperator);
					if (roleOperators.contains(ptOperator)) {
						tree3.setChecked(true);
					}
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
		tree.setChildren(new ArrayList<Tree>());
		return tree;
	}

	@Override
	public List<Tree> showTree(String roleIds) {
		List<String> operatorIds = ptRoleMapper.getRoleOperatorIds(roleIds);
		List<PtOperator> operators = new ArrayList<PtOperator>();
		for (String id : operatorIds) {
			operators.add(ptOperatorMapper.selectByPrimaryKey(id));
		}
		Tree tree = null;
		List<Tree> trees = new ArrayList<Tree>();
		List<PtOperator> list = ptOperatorMapper.selectByExample(null);
		for (PtOperator ptOperator : list) {
			tree = getOperatorTree(ptOperator);
			if (operators.contains(ptOperator)) {
				tree.setChecked(true);
			}
			trees.add(tree);
		}
		return trees;
	}
	
	/**
	 * 将操作权限转换为树结构
	 * @param 操作权限
	 * @return
	 */
	private Tree getOperatorTree(PtOperator ptOperator){
		Tree tree = new Tree();
		tree.setId(ptOperator.getIds());
		tree.setText(ptOperator.getNames());
		tree.setChildren(new ArrayList<Tree>());
		return tree;
	}

	@Override
	public int saveIds(PtRole ptRole) {
		String[] arr = ptRole.getNumbers().split(",");
		int count = 0;
		PtRoleOperator roleOperator = new PtRoleOperator();
		//修改之前把原来关联的信息删除
		ptRoleMapper.deleteByRoleIds(ptRole.getIds());
		for (String operatorIds : arr) {
			roleOperator.setIds(getIds());
			roleOperator.setRoleids(ptRole.getIds());
			roleOperator.setOperatorids(operatorIds);
			count += ptRoleMapper.insertRoleOperator(roleOperator);
		}
		return count;
	}
	
	private String getIds() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	@Override
	public int saveMenuIds(PtRole ptRole) {
		String[] arr = ptRole.getNumbers().split(",");
		int count = 0;
		PtRoleOperator roleOperator = new PtRoleOperator();
		//修改之前把原来关联的信息删除
		ptRoleMapper.deleteByRoleIds(ptRole.getIds());
		for (String operatorIds : arr) {
			roleOperator.setIds(getIds());
			roleOperator.setRoleids(ptRole.getIds());
			roleOperator.setOperatorids(operatorIds);
			count += ptRoleMapper.insertRoleOperator(roleOperator);
		}
		return count;
	}
}
