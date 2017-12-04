package com.chinasofti.mall.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.order.VendorShoppingcartVO;


public class DealParamFunctions {

	// 封装返回参数
	public final static ResponseInfo dealResponseData(Object result) {
		ResponseInfo response = new ResponseInfo();
		if (result != null) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("responseInfo", result);
			response.setData(data);
			response.setRetCode(MsgEnum.SUCCESS.getCode());
			response.setRetMsg(MsgEnum.SUCCESS.getMsg());
		} else if ("".equals(result)) {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg(MsgEnum.ERROR.getMsg());
		} else {
			response.setRetCode(MsgEnum.ERROR.getCode());
			response.setRetMsg("未找到相关数据！");
		}
		return response;
	}

	public  static List<Map<String, List<ChnGoodsinfo>>> pakacgeReponseData(List<VendorShoppingcartVO> pyShoppingCartList) {
		// 存放商户下相关商品List的Map
		Map<String, List<ChnGoodsinfo>> vendorMap = new HashMap<String, List<ChnGoodsinfo>>();
		// 存放所有商户的信息的List
		List<Map<String, List<ChnGoodsinfo>>> vendorList = new ArrayList<Map<String, List<ChnGoodsinfo>>>();

		String vendorNm = null;
		for (VendorShoppingcartVO shopgoods : pyShoppingCartList) {
			vendorNm = shopgoods.getVendorId() + "#" + shopgoods.getVendorSnm();
			List<ChnGoodsinfo> goodsList = vendorMap.get(vendorNm);
			if (goodsList == null) {
				goodsList = new ArrayList<ChnGoodsinfo>();
			}
			ChnGoodsinfo buyGoods = new ChnGoodsinfo();
			buyGoods.setIds(shopgoods.getId());
			buyGoods.setGoodsId(shopgoods.getGoodsId());
			buyGoods.setVendorids(shopgoods.getVendorId());
			buyGoods.setTitle(shopgoods.getGoodsName());
			buyGoods.setFilepath(Constant.HOST_URL + shopgoods.getFilepath());
			buyGoods.setGoodsNum(shopgoods.getGoodsNum());
			buyGoods.setPrice(shopgoods.getPrice());
			buyGoods.setStandard(shopgoods.getStandard());
			buyGoods.setOrgPrice(shopgoods.getOrgPrice());
			buyGoods.setChecked(shopgoods.getChecked());
			goodsList.add(buyGoods);
			vendorMap.put(vendorNm, goodsList);

		}
		vendorList.add(vendorMap);
		return vendorList;
	}
}
