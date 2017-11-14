package com.chinasofti.mall.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PtMenu;
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
	public int save(PtMenu t) {
		return ptMenuMapper.insertSelective(t);
	}

	@Override
	public List<PtMenu> findAll() {
		return ptMenuMapper.selectByExample(null);
	}

	@Override
	public PtMenu findById(String id) {
		return null;
	}

	@Override
	public int deleteById(String id) {
		return 0;
	}

	@Override
	public int update(PtMenu t) {
		return 0;
	}

}
