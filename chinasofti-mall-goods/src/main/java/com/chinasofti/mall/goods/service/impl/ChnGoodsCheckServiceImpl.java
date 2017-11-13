package com.chinasofti.mall.goods.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheckExample;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheckExample.Criteria;
import com.chinasofti.mall.goods.mapper.ChnGoodsinfoCheckMapper;
import com.chinasofti.mall.goods.service.ChnGoodsCheckService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

/**
 * 商品审核业务逻辑层
 * @author Administrator
 *
 */
@Service
public class ChnGoodsCheckServiceImpl implements ChnGoodsCheckService{
	
	@Autowired
	private ChnGoodsinfoCheckMapper chnGoodsinfoCheckMapper;
	
	/* 
	 * 增加
	 */
	@Override
	public int save(ChnGoodsinfoCheck chnGoodsinfoCheck) {
		return chnGoodsinfoCheckMapper.insertSelective(chnGoodsinfoCheck);
	}

	/**
	 * 列表及条件查询
	 * @param chnGoodsinfoCheck
	 * @return 
	 */
	public JSONObject selectAll(ChnGoodsinfoCheck chnGoodsinfoCheck){
		
		JSONObject js = new JSONObject();
		
		PageHelper.startPage(chnGoodsinfoCheck.getPageNumber(),chnGoodsinfoCheck.getPageSize());
		List<ChnGoodsinfoCheck> list = chnGoodsinfoCheckMapper.findAll(chnGoodsinfoCheck);
		
		js.put("rows", list);
		js.put("total", ((Page<ChnGoodsinfoCheck>)list).getTotal());
		
		return js;
	}
	
	/* 
	 * 根据ID查找
	 */
	@Override
	public ChnGoodsinfoCheck findById(String ids) {
		return chnGoodsinfoCheckMapper.selectByPrimaryKey(ids);
	}
	
	/* 
	 * 修改
	 */
	@Override
	public int update(ChnGoodsinfoCheck chnGoodsinfoCheck) {
		return chnGoodsinfoCheckMapper.updateByPrimaryKeySelective(chnGoodsinfoCheck);
	}

	/* 
	 * 列表及条件查询
	 */
	@Override
	public JSONObject selectByExample(ChnGoodsinfoCheck chnGoodsinfoCheck) {
		
		JSONObject js = new JSONObject();
		
		ChnGoodsinfoCheckExample example = new ChnGoodsinfoCheckExample();
		Criteria criteria = example.createCriteria();
		
		//商品编号
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getGoodsids())) {
			criteria.andGoodsidsLike("%" + chnGoodsinfoCheck.getGoodsids() + "%");
		}
		//商品名称标题
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getTitle())) {
				criteria.andTitleLike("%" + chnGoodsinfoCheck.getTitle() + "%");
			}
		//开始时间,结束时间
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getStartTime()) && !StringUtils.isEmpty(chnGoodsinfoCheck.getEndTime())) {
			criteria.andStartTimeGreaterThanOrEqualTo(chnGoodsinfoCheck.getStartTime());
			criteria.andEndTimeLessThanOrEqualTo(chnGoodsinfoCheck.getEndTime());
		}else if (!StringUtils.isEmpty(chnGoodsinfoCheck.getStartTime())) {
			criteria.andBrandIdsGreaterThanOrEqualTo(chnGoodsinfoCheck.getStartTime());
		}else if (!StringUtils.isEmpty(chnGoodsinfoCheck.getEndTime())) {
			criteria.andEndTimeLessThanOrEqualTo(chnGoodsinfoCheck.getEndTime());
		}
		//商户编号
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getVendorids())) {
			criteria.andVendoridsLike("%" + chnGoodsinfoCheck.getVendorids() + "%");
		}
		//商品分类
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getGoodsClassIds())) {
				criteria.andGoodsClassIdsLike("%" + chnGoodsinfoCheck.getGoodsClassIds() + "%");
		}
		//商品类型
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getType())) {
			criteria.andTypeEqualTo(chnGoodsinfoCheck.getType());
		}
		//审核状态
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getReviewStatues())) {
			criteria.andReviewStatuesEqualTo(chnGoodsinfoCheck.getReviewStatues());
		}
		
		PageHelper.startPage(chnGoodsinfoCheck.getPageNumber(),chnGoodsinfoCheck.getPageSize());
		List<ChnGoodsinfoCheck> list = chnGoodsinfoCheckMapper.selectByExample(example);

		js.put("rows", list);
		js.put("total", ((Page<ChnGoodsinfoCheck>)list).getTotal());
		
		return js;
	}

	/* 
	 * 根据ID删除
	 */
	@Override
	public int deleteById(String ids) {
		return chnGoodsinfoCheckMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public List<ChnGoodsinfoCheck> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
