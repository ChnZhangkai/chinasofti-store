package com.chinasofti.mall.goods.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.goods.mapper.ChnGoodsOnlineMapper;
import com.chinasofti.mall.goods.service.ChnGoodsOnlineService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

@Service
public class ChnGoodsOnlineServiceImpl implements ChnGoodsOnlineService{

	@Autowired
	private ChnGoodsOnlineMapper chnGoodsOnlineMapper;
	
	@Override
	public JSONObject selectByExample(ChnGoodsOnline chnGoodsOnline) {
		JSONObject js = new JSONObject();
		
		PageHelper.startPage(chnGoodsOnline.getPageNumber(),chnGoodsOnline.getPageSize());
		List<ChnGoodsOnline> list = chnGoodsOnlineMapper.findAll(chnGoodsOnline);

		js.put("rows", list);
		js.put("total", ((Page<ChnGoodsOnline>)list).getTotal());
		
		return js;
	}

}
