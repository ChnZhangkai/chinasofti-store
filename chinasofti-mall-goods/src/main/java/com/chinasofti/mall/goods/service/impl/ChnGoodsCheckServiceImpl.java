package com.chinasofti.mall.goods.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.common.utils.StringDateUtil;
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
		chnGoodsinfoCheck.setStatus("2");
		return chnGoodsinfoCheckMapper.insertSelective(chnGoodsinfoCheck);
	}

	/**
	 * 列表及条件查询
	 * @param chnGoodsinfoCheck
	 * @return 
	 */
	public JSONObject selectAll(ChnGoodsinfoCheck chnGoodsinfoCheck){
		
		JSONObject js = new JSONObject();
		
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getStartTime())) {
			chnGoodsinfoCheck.setStartTime(StringDateUtil.convertToSqlFormat(chnGoodsinfoCheck.getStartTime()));
		}
		if (!StringUtils.isEmpty(chnGoodsinfoCheck.getEndTime())) {
			chnGoodsinfoCheck.setEndTime(StringDateUtil.convertToSqlFormat(chnGoodsinfoCheck.getEndTime()));
		}

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

		int updateGoodsCheck = chnGoodsinfoCheckMapper.updateByPrimaryKeySelective(chnGoodsinfoCheck);
		return updateGoodsCheck;
	}

	/* 
	 * 根据ID删除
	 */
	@Override
	public int deleteById(String ids) {
		return chnGoodsinfoCheckMapper.deleteByPrimaryKey(ids);
	}

	/* 
	 * 更改审核状态(0.提交审核,3.撤销审核,1.审核通过,2.审核拒绝)
	 */
	@Override
	public int updateByPrimaryKeySelective(ChnGoodsinfoCheck chnGoodsinfoCheck) {
		
		int checkReviewStatus = Integer.valueOf(chnGoodsinfoCheck.getReviewStatues());
		//若未提交则更改为已提交
		if (checkReviewStatus == 0) {
			chnGoodsinfoCheck.setReviewStatues("3");
		}
		//若已提交则改为未提交
		if (checkReviewStatus == 3) {
			chnGoodsinfoCheck.setReviewStatues("0");
		}
		
		if (checkReviewStatus == 1) {
			ChnGoodsinfoCheck goods = findById(chnGoodsinfoCheck.getIds());
			goods.setIds(goods.getGoodsids());	
			goods.setGoodsids("");
			goods.setReviewStatues("1");
			goods.setStatus("2");
			
			chnGoodsinfoCheckMapper.insertGoodsOnlineSelective(goods);
		}
		
		return chnGoodsinfoCheckMapper.updateByPrimaryKeySelective(chnGoodsinfoCheck);
	}
	
	
	
	
	
	
	@Override
	public List<ChnGoodsinfoCheck> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/* 
	 * 列表及条件查询
	 */
	@Override
	public JSONObject selectByExample(ChnGoodsinfoCheck chnGoodsinfoCheck) {
		
		JSONObject js = new JSONObject();
		
		return js;
	}

}
