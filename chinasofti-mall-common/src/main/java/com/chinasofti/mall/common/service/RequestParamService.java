package com.chinasofti.mall.common.service;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;

public class RequestParamService {

	private static final Logger logger = LoggerFactory.getLogger(RequestParamService.class);

	public static ResponseInfo packageWithShoppingCartRequestParam(PyShoppingCart goodsInfo){
		ResponseInfo response = new ResponseInfo();
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
		/*if (StringUtils.isEmpty(goodsInfo.getGoodsNum().toString())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("goodsNum不能为空！");
			return response;
		}*/
		if (StringUtils.isEmpty(goodsInfo.getGoodsId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("goodsId不能为空！");
			return response;
		}
		return response;
	}
	
	public static ResponseInfo packageWithAddShoppingCartParam(PyShoppingCart goodsInfo){
		ResponseInfo response = new ResponseInfo();
		if (StringUtils.isEmpty(goodsInfo.getUserId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("userId不能为空！");
			logger.info("用户Id为空，请登录后再添加！userId:"+goodsInfo.getUserId());
			return response;
		}
		/*if (goodsInfo.getGoodsNum().compareTo(new BigDecimal("1"))==1) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("goodsNum不能小于1！");
			return response;
		}*/
		if (StringUtils.isEmpty(goodsInfo.getGoodsId())) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("goodsId不能为空！");
			return response;
		}
		return response;
	}

	/**
	 * 商品信息校验
	 * 
	 * @param shopCar
	 * @param storegoodsInfo
	 * @return
	 */
	public static ResponseInfo packageWithGoodsInfoRequest(PyShoppingCart shopCar, ChnGoodsinfo storegoodsInfo) {
		ResponseInfo response = new ResponseInfo();
		String goodsStatus = storegoodsInfo.getStatus();
		Map<String, Object> data = new HashMap<String, Object>();
		if (!goodsStatus.equals(Constant.GOODS_STATUS)) {
			response.setRetCode("500001");
			response.setRetMsg("该商品已下架或已删除");
			data.put("responseInfo", shopCar);
			response.setData(data);
			return response;
		}
		BigDecimal userBuyNum = shopCar.getGoodsNum();
		BigDecimal storeNum = storegoodsInfo.getStoreNum();
		if (userBuyNum.compareTo(storeNum) == 1) {
			response.setRetCode("600001");
			response.setRetMsg("库存不足");
			data.put("responseInfo", shopCar);
			response.setData(data);
			return response;
		}
		BigDecimal limitOrderNum = storegoodsInfo.getLimitOrderNum();
		if (userBuyNum.compareTo(limitOrderNum) == 1) {
			response.setRetCode("700001");
			response.setRetMsg("数量已超出单位限制！");
			data.put("responseInfo", shopCar);
			response.setData(data);
			return response;
		}
		data.put("responseInfo", shopCar);
		response.setData(data);
		response.setRetCode(MsgEnum.SUCCESS.getCode());
	    response.setRetMsg(MsgEnum.SUCCESS.getMsg());
		return response;
	}

	public static ResponseInfo packageWithGoodsInfoRequest2(PyShoppingCart shopCar, ChnGoodsinfo storegoodsInfo) {
		ResponseInfo response = new ResponseInfo();
		String goodsStatus = storegoodsInfo.getStatus();
		Map<String, Object> data = new HashMap<String, Object>();
		if (!goodsStatus.equals(Constant.GOODS_STATUS)) {
			response.setRetCode("500001");
			response.setRetMsg("该商品已下架或已删除");
			data.put("responseInfo", shopCar);
			response.setData(data);
			return response;
		}
		BigDecimal userBuyNum = shopCar.getGoodsNum();
		BigDecimal storeNum = storegoodsInfo.getStoreNum();
		if (userBuyNum.compareTo(storeNum) == 1) {
			response.setRetCode("600001");
			response.setRetMsg("库存不足");
			data.put("responseInfo", shopCar);
			response.setData(data);
			return response;
		}
		BigDecimal limitOrderNum = storegoodsInfo.getLimitOrderNum();
		if (userBuyNum.compareTo(limitOrderNum) == 1) {
			response.setRetCode("700001");
			response.setRetMsg("数量已超出单位限制！");
			data.put("responseInfo", shopCar);
			response.setData(data);
			return response;
		}
	
		return response;
	}
}
