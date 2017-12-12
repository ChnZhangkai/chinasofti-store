package com.chinasofti.mall.goods.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClassExample;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClassExample.Criteria;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goods.mapper.ChnGoodsClassMapper;
import com.chinasofti.mall.goods.service.IChnGoodsClassService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

/**
 * 分类Service实现层
 * @author Administrator
 *
 */
@Service
public class ChnGoodsClassServiceImpl implements IChnGoodsClassService{

	@Autowired
	private ChnGoodsClassMapper chnGoodsClassMapper;
	
	@Override
	public List<ChnGoodsClass> findGoodsClass(String ids) {
		List<ChnGoodsClass> goodsClass = chnGoodsClassMapper.findGoodsClass(ids);
		return goodsClass;
	}
	
	
	/*
	 * 列表及提交查询
	 */
	public JSONObject selectByExample(ChnGoodsClass chnGoodsClass) {

		JSONObject js = new JSONObject();
		ChnGoodsClassExample example = new ChnGoodsClassExample();
		Criteria criteria = example.createCriteria();

		if (!StringUtils.isEmpty(chnGoodsClass.getName())) {
			criteria.andNameLike("%" + chnGoodsClass.getName() + "%");
		}
		if (!StringUtils.isEmpty(chnGoodsClass.getCommons())) {
			criteria.andCommonsLike("%" + chnGoodsClass.getCommons() + "%");
		}
		if (!StringUtils.isEmpty(chnGoodsClass.getCreateBy())) {
			criteria.andCreateByLike("%" + chnGoodsClass.getCreateBy() + "%");
		}
		if (!StringUtils.isEmpty(chnGoodsClass.getStates())) {
			criteria.andStatesEqualTo(chnGoodsClass.getStates());
		}

		PageHelper.startPage(chnGoodsClass.getPageNumber(), chnGoodsClass.getPageSize());
		List<ChnGoodsClass> list = chnGoodsClassMapper.selectByExample(example);

		js.put("rows", list);
		js.put("total", ((Page<ChnGoodsClass>) list).getTotal());

		return js;
	}

	/*
	 * 保存添加
	 */
	public int saveGoodsClass(ChnGoodsClass chnGoodsClass) {
		return chnGoodsClassMapper.insertSelective(chnGoodsClass);
	}

	/*
	 * 修改
	 */
	public int updateById(ChnGoodsClass chnGoodsClass) {
		return chnGoodsClassMapper.updateByPrimaryKeySelective(chnGoodsClass);
	}

	/*
	 * 根据ID删除
	 */
	public int deleteById(String ids) {
		return chnGoodsClassMapper.deleteByPrimaryKey(ids);
	}

	/**
	 * 根据ID查找
	 * @param ids
	 * @return
	 */
	public ChnGoodsClass findById(String ids) {
		return chnGoodsClassMapper.selectByPrimaryKey(ids);
	}
  
	/**
	 * 查询分类信息(弃用)
	 */
	public ResponseInfo selectByIsParent(ResponseInfo response, String isparent) {
		List<ChnGoodsClass> result = chnGoodsClassMapper.selectByIsParent(isparent);
		response = dealGoodsResponseData(response, result);
		return response;
	}


	private ResponseInfo dealGoodsResponseData(ResponseInfo response, List<ChnGoodsClass> result) {
		if (result.size() > 0) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("ResponseInfo", result);
			response.setData(data);
			response.setRetCode(MsgEnum.SUCCESS.getCode());
			response.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}else if(result==null||result.size()==0){
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("未找到相关数据！");
		}else {
			response.setRetCode(MsgEnum.SERVER_ERROR.getCode());
			response.setRetMsg(MsgEnum.SERVER_ERROR.getMsg());
		}
		return response;
	}

	/**
	 * 当classId不为空时查询二级列表，为空时则查询一级分类
	 * 
	 * @param classId
	 * @return
	 */
	public List<ChnGoodsClass> queryClass(String classId) {
		String pids = classId;
		return chnGoodsClassMapper.selectById(pids); 
	}

}
