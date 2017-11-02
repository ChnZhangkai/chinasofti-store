package com.chinasofti.mall.sp.user.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.SpUser;
import com.chinasofti.mall.common.entity.SpUserExample;
import com.chinasofti.mall.sp.user.mapper.SpUserMapper;
import com.chinasofti.mall.sp.user.service.SpUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserServiceImpl.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:13:04
 * @parma <T>
 */
@Service
public class SpUserServiceImpl implements SpUserService {
	
	@Autowired
	private SpUserMapper spUserMapper;

	/**
	 * @param spUser
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public String selectByExample(SpUser spUser) {
		
		JSONObject js = new JSONObject();
		
		PageHelper.startPage(spUser.getPageNumber(),spUser.getPageSize());
		List<SpUser> list = spUserMapper.selectByExample(new SpUserExample());
		
		js.put("rows", list);
		js.put("total", ((Page)list).getTotal());
		
		return js.toString();
	}

	
	@Override
	public int save(SpUser t) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public List<SpUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public SpUser findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public int deleteById(String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	@Override
	public int update(SpUser t) {
		// TODO Auto-generated method stub
		return 0;
	}

}
