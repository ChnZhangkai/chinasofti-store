package com.chinasofti.mall.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.PtUserExample;
import com.chinasofti.mall.common.entity.PtUserExample.Criteria;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUser;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUserExample;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.user.mapper.PtRoleUserMapper;
import com.chinasofti.mall.user.mapper.PtUserMapper;
import com.chinasofti.mall.user.service.PtUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;


@Service
public class PtUserServiceImpl implements PtUserService{

	@Autowired
	private PtUserMapper PtUserMapper;
	
	@Autowired
	private PtRoleUserMapper ptRoleUserMapper;

	@Override
	public int save(PtUser ptUser) {
		PtRoleUser ptRoleUser = new PtRoleUser();
		ptRoleUser.setIds(UUIDUtils.getUuid());
		ptRoleUser.setRoleIds(ptUser.getIds());
		ptUser.setIds(UUIDUtils.getUuid());
		ptRoleUser.setModuleIds(ptUser.getIds());
		PtUserMapper.insertSelective(ptUser);
		return ptRoleUserMapper.insert(ptRoleUser);
	}

	@Override
	public List<PtUser> findAll() {
		return null;
	}

	@Override
	public PtUser findById(String id) {
		return PtUserMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String ids) {
		ptRoleUserMapper.deleteByUserIds(ids);
		return PtUserMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public int update(PtUser ptUser) {
		return PtUserMapper.updateByPrimaryKeySelective(ptUser);
	}

	@Override
	public JSONObject selectByExample(PtUser ptUser) {
		
		JSONObject js=new JSONObject();
		PtUserExample example=new PtUserExample();
		Criteria criteria = example.createCriteria();
		
		if (!StringUtils.isEmpty(ptUser.getUsername())) {
			criteria.andUsernameLike("%" + ptUser.getUsername() + "%");
		}
	
		if (!StringUtils.isEmpty(ptUser.getUsernames())) {
			criteria.andUsernamesLike("%" + ptUser.getUsernames() + "%");
		}
		
		if (!StringUtils.isEmpty(ptUser.getStatus())) {
			criteria.andStatusEqualTo(ptUser.getStatus());
		}
			
		PageHelper.startPage(ptUser.getPageNumber(),ptUser.getPageSize());
		List<PtUser> list = PtUserMapper.selectByExample(example);
	
		js.put("rows", list);
		js.put("total", ((Page<PtUser>)list).getTotal());
		
		return js;
		}

	/* 
	 * 通过用户ID查询其角色名称
	 */
	@Override
	public PtRole selectUserRoleName(String ids) {
		return PtUserMapper.selectUserRoleName(ids);
	}
	
	/* 
	 * 通过用户修改角色
	 */
	@Override
	public int updateByExampleSelective(PtRoleUser ptRoleUser, PtRoleUserExample example) {
		
		(example.createCriteria()).andModuleIdsEqualTo(ptRoleUser.getModuleIds());
		ptRoleUser.setModuleIds(null);
		return ptRoleUserMapper.updateByExampleSelective(ptRoleUser, example);
	}

	@Override
	public String selectByUserName(String username) {
		return PtUserMapper.selectByUserName(username);
	}
	
	
}
