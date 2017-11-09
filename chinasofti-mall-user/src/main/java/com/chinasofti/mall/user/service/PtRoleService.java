package com.chinasofti.mall.user.service;

import java.util.List;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.Tree;

public interface PtRoleService {

	int save(PtRole ptRole);

	PtRole findById(String ids);

	List<PtRole> findAll();

	int update(PtRole ptRole);

	int add2(String ids);

	List<Tree> show(String roleId);

}
