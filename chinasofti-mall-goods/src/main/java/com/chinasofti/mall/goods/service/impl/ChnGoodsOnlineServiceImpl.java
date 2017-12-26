package com.chinasofti.mall.goods.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.AdvertiseContents;
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

	@Override
	public int updateGoodsStatus(ChnGoodsOnline chnGoodsOnline) {
		int status = Integer.valueOf(chnGoodsOnline.getStatus());
		String leaveTime = chnGoodsOnline.getLeaveTime();
		String onlineTime = chnGoodsOnline.getOnlineTime();
		//若已上架则更改为已下架
		if (status == 1) {
			chnGoodsOnline.setStatus("2");
			chnGoodsOnline.setOnlineTime(onlineTime);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			chnGoodsOnline.setLeaveTime(df.format(new Date()));
			
		}
		//若已下架则改为已上架
		if (status == 2) {
			chnGoodsOnline.setStatus("1");
			chnGoodsOnline.setLeaveTime(leaveTime);
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			chnGoodsOnline.setOnlineTime(df.format(new Date()));
		}
		
		return chnGoodsOnlineMapper.updateByPrimaryKey(chnGoodsOnline);
	}

	@Override
	public int update(ChnGoodsOnline chnGoodsOnline) {
		return chnGoodsOnlineMapper.update(chnGoodsOnline);
		 
	}

	
	@Override
	public Map<String, Object> findByPage(Map<String, Object> paramMap) {
	// 执行分页查询
		PageHelper.startPage(Integer.parseInt(paramMap.get("page").toString()),
				Integer.parseInt(paramMap.get("rows").toString()));
		List<ChnGoodsOnline> list = chnGoodsOnlineMapper.findByPage(paramMap);
		Map<String,Object> map = new HashMap<>();
		map.put("rows", list);
		map.put("total", ((Page<ChnGoodsOnline>) list).getTotal());
		return map;
	}

	/* 
	 * 修改商品审核状态和在线状态
	 */
	@Override
	public int updateGoodsReviewStatusAndStatus(ChnGoodsOnline chnGoodsOnline) {
		
		return chnGoodsOnlineMapper.updateByPrimaryKeySelective(chnGoodsOnline);
	}

	/* 
	 * 通过Ids查询
	 */
	@Override
	public ChnGoodsOnline selectByPrimaryKey(String ids) {
		return chnGoodsOnlineMapper.selectByPrimaryKey(ids);
	}

	


}
