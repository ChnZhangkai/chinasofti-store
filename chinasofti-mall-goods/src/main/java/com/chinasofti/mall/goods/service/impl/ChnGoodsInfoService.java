package com.chinasofti.mall.goods.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsInfoVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goods.mapper.ChnGoodsInfoMapper;
import com.chinasofti.mall.goods.service.IChnGoodsInfoService;

@Service
public class ChnGoodsInfoService implements IChnGoodsInfoService{

	@Autowired
	private ChnGoodsInfoMapper goodsinfoMapper;
	
	public ResponseInfo selectByClassId(String goodsClassIds) {
		ResponseInfo  response= new ResponseInfo();
		List<ChnGoodsinfo> result =goodsinfoMapper.selectByClassId(goodsClassIds);
		response = dealAdResponseData(result);
		return response;
	}
	private ResponseInfo dealAdResponseData(List<ChnGoodsinfo> result) {
		ResponseInfo  response= new ResponseInfo();
		if(result.size()>0){
			Map<String, Object> data= new HashMap<String, Object>();
			data.put("ResponseInfo", result);			
			response.setData(data);
			response.setRetCode(MsgEnum.SUCCESS.getCode());
			response.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}else if(result==null||result.size()==0){
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("未找到相关数据！");
		}else{
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg(MsgEnum.ERROR.getMsg());
		}
		return response;
	}

	public ResponseInfo selectByGoodsId(String ids) {
		ResponseInfo  response= new ResponseInfo();
		ChnGoodsInfoVo result = goodsinfoMapper.selectByPrimaryKey(ids);
		response =dealResponseData(result);
		return response;
	}
	//封装返回参数
		private ResponseInfo dealResponseData(ChnGoodsInfoVo result) {
			ResponseInfo  response= new ResponseInfo();
			if(result !=null){
				result.setFilepath(Constant.HOST_URL+result.getFilepath());
				Map<String, Object> data= new HashMap<String, Object>();
				data.put("ResponseInfo", result);
				response.setData(data);
				response.setRetCode(MsgEnum.SUCCESS.getCode());
				response.setRetMsg(MsgEnum.SUCCESS.getMsg());
			}else if("".equals(result)){
				response.setRetCode(MsgEnum.ERROR.getCode());
				response.setRetMsg(MsgEnum.ERROR.getMsg());
			}else{
				response.setRetCode(MsgEnum.ERROR.getCode());
				response.setRetMsg("未找到相关数据！");	
			}
			return response;
		}
		/**
	     * 根据关键字查询商品列表
	     * @param record
	     * @return
	     */
		@Override
		public ResponseInfo selectByNameOrother(ChnGoodsinfo record) {
			ResponseInfo  response= new ResponseInfo();
			List<ChnGoodsinfo> result = goodsinfoMapper.selectByNameOrother(record);
			response = dealAdResponseData(result);
			return response;
		}

}
