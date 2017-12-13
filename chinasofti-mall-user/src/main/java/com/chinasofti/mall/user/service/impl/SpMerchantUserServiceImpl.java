package com.chinasofti.mall.user.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
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
		System.out.println("商户数据:"+spUser);
		return spUserMapper.insertSelective(spUser);
	}


	@Override
	public List<SpMerchantUser> findAll() {
		return null;
	}


	@Override
	public SpMerchantUser findById(String vendorId) {
		return spUserMapper.selectByPrimaryKey(vendorId);
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
		JSONObject js = new JSONObject();
		PageHelper.startPage(spMerchantUser.getPageNumber(),spMerchantUser.getPageSize());
		List<SpMerchantUser> list = spUserMapper.selectByExample(spMerchantUser);

		js.put("rows", list);
		js.put("total", ((Page<SpMerchantUser>)list).getTotal());
		
		return js;
	}



	@Override
	public Map<String, Object> findByPage(Map<String, Object> paramMap) {
		// 执行分页查询
		PageHelper.startPage(Integer.parseInt(paramMap.get("page").toString()),
				Integer.parseInt(paramMap.get("rows").toString()));
		List<AdvertiseContents> list = spUserMapper.findByPage(paramMap);
		Map<String,Object> map = new HashMap<>();
		map.put("rows", list);
		map.put("total", ((Page<AdvertiseContents>) list).getTotal());
		return map;
	}

	

}
