package com.chinasofti.mall.common.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;

public class RequestParamService {

	private static final Logger logger = LoggerFactory.getLogger(RequestParamService.class);
	@SuppressWarnings("null")
	public static ResponseInfo packageWithShoppingCartRequestParam(PyShoppingCart goodsInfo){
		ResponseInfo response = null;
		if (StringUtils.isEmpty(goodsInfo.getUserId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("userId不能为空！");
			return response;
		}
		if (StringUtils.isEmpty(goodsInfo.getId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("Id不能为空！");
			return response;
		}
		if (StringUtils.isEmpty(goodsInfo.getGoodsNum().toString())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("goodsNum不能为空！");
			return response;
		}
		if (StringUtils.isEmpty(goodsInfo.getGoodsId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("goodsId不能为空！");
			return response;
		}
		return response;
	}
	
	@SuppressWarnings("null")
	public static ResponseInfo packageWithAddShoppingCartParam(PyShoppingCart goodsInfo){
		ResponseInfo response = null;
		if (StringUtils.isEmpty(goodsInfo.getUserId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("userId不能为空！");
			logger.info("用户Id为空，请登录后再添加！userId:"+goodsInfo.getUserId());
			return response;
		}
		if (StringUtils.isEmpty(goodsInfo.getGoodsNum().toString())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("goodsNum不能为空！");
			return response;
		}
		if (StringUtils.isEmpty(goodsInfo.getGoodsId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("goodsId不能为空！");
			return response;
		}
		return response;
	}
}
