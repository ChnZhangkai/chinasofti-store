package com.chinasofti.mall.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.common.entity.PtHrUserBakExample;
import com.chinasofti.mall.user.mapper.PtHrUserBakMapper;
import com.chinasofti.mall.user.service.PrHrUserService;

@Service
public class PtHrUserServiceImpl implements PrHrUserService{

	@Autowired
	private PtHrUserBakMapper ptHrUserBakMapper;
	
	
	@Override
	public int save(PtHrUserBak t) {
		return 0;
	}

	@Override
	public List<PtHrUserBak> findAll() {
		return null;
	}

	@Override
	public PtHrUserBak findById(String id) {
		return null;
	}

	@Override
	public int deleteById(String id) {
		return 0;
	}

	@Override
	public int update(PtHrUserBak t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<PtHrUserBak> selectByExample(PtHrUserBak ptHrUserBak) {
		return ptHrUserBakMapper.selectByExample(new PtHrUserBakExample());
	}

}
