package com.chinasofti.mall.user.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUserExample;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUserExample.Criteria;
import com.chinasofti.mall.user.mapper.SpMerchantUserMapper;
import com.chinasofti.mall.user.service.SpMerchantUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserServiceImpl.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:13:04
 * @parma spuser
 */
@Service
public class SpMerchantUserServiceImpl implements SpMerchantUserService {
	
	@Autowired
	private SpMerchantUserMapper spUserMapper;

	@Override
	public int save(SpMerchantUser spUser) {
		return spUserMapper.insertSelective(spUser);
	}


	@Override
	public List<SpMerchantUser> findAll() {
		return null;
	}


	@Override
	public SpMerchantUser findById(String id) {
		return spUserMapper.selectByPrimaryKey(id);
	}

	
	@Override
	public int deleteById(String id) {
		return spUserMapper.deleteByPrimaryKey(id);
	}

	
	@Override
	public int update(SpMerchantUser spMerchantUser) {
		return spUserMapper.updateByPrimaryKeySelective(spMerchantUser);
	}

	@Override
	public JSONObject selectByExample(SpMerchantUser spMerchantUser) {
		//String compare = "";
		JSONObject js = new JSONObject();
		SpMerchantUserExample example = new SpMerchantUserExample();
		Criteria criteria = example.createCriteria();
		
		
		
		if (!StringUtils.isEmpty(spMerchantUser.getVendorId())) {
				criteria.andVendorIdLike("%" + spMerchantUser.getVendorId() + "%");
			}
		if (!StringUtils.isEmpty(spMerchantUser.getVendorFnm())) {
				criteria.andVendorFnmLike("%" + spMerchantUser.getVendorFnm() + "%");
		}
		if (!StringUtils.isEmpty(spMerchantUser.getVendorSnm())) {
			criteria.andVendorSnmLike("%" + spMerchantUser.getVendorFnm() + "%");
		}
		if (!StringUtils.isEmpty(spMerchantUser.getBelongSiteName())) {
			criteria.andBelongSiteNameLike("%" + spMerchantUser.getBelongSiteName() + "%");
		}
		
		if (!StringUtils.isEmpty(spMerchantUser.getStatus())) {
			criteria.andStatesEqualTo(spMerchantUser.getStatus());
		}

		PageHelper.startPage(spMerchantUser.getPageNumber(),spMerchantUser.getPageSize());
		List<SpMerchantUser> list = spUserMapper.selectByExample(example);

		js.put("rows", list);
		js.put("total", ((Page<SpMerchantUser>)list).getTotal());
		
		return js;
	}



}
