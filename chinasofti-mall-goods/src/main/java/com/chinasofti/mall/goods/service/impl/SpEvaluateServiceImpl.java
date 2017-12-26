/**
 * 
 */
package com.chinasofti.mall.goods.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.SpEvaluate;
import com.chinasofti.mall.goods.mapper.SpEvaluateMapper;
import com.chinasofti.mall.goods.service.SpEvaluateService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * @ClassName: GoodsCommentsServiceImpl.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年12月20日 下午5:08:11
 * @parma <T>
 */
@Service
public class SpEvaluateServiceImpl implements SpEvaluateService{

	@Autowired
	private SpEvaluateMapper spEvaluateMapper;

	@Override
	public Map<String, Object> findByCommentsPage(Map<String, Object> paramMap) {
		// 执行分页查询
		PageHelper.startPage(Integer.parseInt(paramMap.get("page").toString()),
				Integer.parseInt(paramMap.get("rows").toString()));
		List<SpEvaluate> list = spEvaluateMapper.findByPage(paramMap);
		Map<String,Object> map = new HashMap<>();
		map.put("rows", list);
		map.put("total", ((Page<SpEvaluate>) list).getTotal());
		return map;
	}

	
	@Override
	public int deleteById(String id) {
		return spEvaluateMapper.deleteByPrimaryKey(id);
	}

	@Override
	public SpEvaluate selectByCommentsIds(String ids) {
		return spEvaluateMapper.selectByPrimaryKey(ids);
	}

	@Override
	public int batchDeletes(List<String> delList) {
		return  spEvaluateMapper.batchDeletes(delList);
	}

}
