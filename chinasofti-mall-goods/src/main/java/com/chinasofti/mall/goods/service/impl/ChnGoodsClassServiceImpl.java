package com.chinasofti.mall.goods.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClassExample;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClassExample.Criteria;
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goods.mapper.ChnGoodsClassMapper;
import com.chinasofti.mall.goods.service.ChnGoodsClassService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.util.StringUtil;

import net.sf.json.JSONObject;

/**
 * 分类Service层
 * @author Administrator
 *
 */
@Service
public class ChnGoodsClassServiceImpl implements ChnGoodsClassService{
	
	@Autowired
	private ChnGoodsClassMapper chnGoodsClassMapper;
	
	/* 
	 * 列表及提交查询
	 */
	@Override
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

		PageHelper.startPage(chnGoodsClass.getPageNumber(),chnGoodsClass.getPageSize());
		List<ChnGoodsClass> list = chnGoodsClassMapper.selectByExample(example);

		js.put("rows", list);
		js.put("total", ((Page<ChnGoodsClass>)list).getTotal());
		
		return js;
	}

	/* 
	 * 保存添加
	 */
	@Override
	public int save(ChnGoodsClass chnGoodsClass) {
		return chnGoodsClassMapper.insertSelective(chnGoodsClass);
	}

	/* 
	 * 修改
	 */
	@Override
	public int update(ChnGoodsClass chnGoodsClass) {
		return chnGoodsClassMapper.updateByPrimaryKeySelective(chnGoodsClass);
	}

	/* 
	 * 根据ID删除
	 */
	@Override
	public int deleteById(String ids) {
		return chnGoodsClassMapper.deleteByPrimaryKey(ids);
	}

	@Override
	public ChnGoodsClass findById(String ids) {
		return chnGoodsClassMapper.selectByPrimaryKey(ids);
	}

	/**
	 * 查询分类信息
	 */
	public ResponseInfo selectByIsParent(ResponseInfo  response, String isParent) {
		 List<ChnGoodsClass> result = chnGoodsClassMapper.selectByIsParent(isParent);
		 response = dealGoodsResponseData(response,result);
		return response;
	}

	public ResponseInfo selectById(ResponseInfo  response,String pids) {
		List<ChnGoodsClass> result = chnGoodsClassMapper.selectById(pids);
		response = dealGoodsResponseData(response,result);
		return response;
	}

	private ResponseInfo dealGoodsResponseData(ResponseInfo  response,List<ChnGoodsClass> result) {
		if(result.size()>0){
			Map<String, Object> data= new HashMap<String, Object>();
			for(ChnGoodsClass gc :result){
				
				data.put(result.get(0).toString(), gc);	
			}			
			response.setData(data);
			response.setRetCode(MsgEnum.SUCCESS.getCode());
			response.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}else{
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg(MsgEnum.ERROR.getMsg());
		}
		return response;
	}

	@Override
	public List<ChnGoodsClass> findAll() {
		return null;
	}
	/**
	 * 当classId不为空时查询二级列表，为空时则查询一级分类
	 * @param classId
	 * @return
	 */
	public ResponseInfo queryClass(String classId) {
		ResponseInfo  response= new ResponseInfo();
		String pids = classId;
		if(StringUtil.isNotEmpty(pids)){
			response = selectById(response,pids);
		}else{
			String isParent =Constant.IS_PARENT;
			response = selectByIsParent(response,isParent);
		}
		return response;
	}
}
