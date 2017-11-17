package com.chinasofti.mall.goodsorder.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.goodsorder.mapper.PyShoppingCartMapper;
import com.chinasofti.mall.goodsorder.service.PyShoppingCartService;

@Service
public class PyShoppingCartServiceImpl implements PyShoppingCartService{
	
	private static final Logger logger = LoggerFactory.getLogger(PyShoppingCartServiceImpl.class);
	
	@Autowired
	private PyShoppingCartMapper pyShoppingCartMapper;

	@Override
	public List<PyShoppingCart> findAll() {
		return null;
	}

	@Override
	public PyShoppingCart findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteById(String id) {
		return pyShoppingCartMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public int save(PyShoppingCart t) {
		return pyShoppingCartMapper.insert(t);
	}

	@Override
	public int update(PyShoppingCart t) {
		return pyShoppingCartMapper.updateByPrimaryKey(t);
	}

	@Override
	public ResponseInfo queryPyShoppingCartListByUserId(String userId) {
		ResponseInfo responseInfo = new ResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		try{
			List<PyShoppingCart> pyShoppingCartList = pyShoppingCartMapper.getPyShoppingCartListByUserId(userId);
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
			data.put("pyShoppingCartList", pyShoppingCartList);
			responseInfo.setData(data);
		}catch(Exception e){
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error(userId+"：查询购物车失败");
		}
		return responseInfo;
	}

	@Override
	public ResponseInfo savePyShoppingCart(JSONObject json) {
		ResponseInfo responseInfo = new ResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();
		List<PyShoppingCart> pyShoppingCartList = new ArrayList<PyShoppingCart>();
		try{
			JSONArray jSONArray =  json.getJSONArray("goodsList");
			for(int i=0;jSONArray.size()>i;i++){
				JSONObject jsonObject = jSONArray.getJSONObject(i);
				PyShoppingCart pyShoppingCart = new PyShoppingCart();
				pyShoppingCart.setIds(UUIDUtils.getUuid());
				pyShoppingCart.setUserids(jsonObject.getString("userId").toString());
				pyShoppingCart.setGoodsIds(jsonObject.getString("goodsId").toString());
				pyShoppingCart.setGoodsNum(Short.valueOf(jsonObject.getString("goodsNum").toString()));
				pyShoppingCart.setVendorid("1");
				pyShoppingCart.setChecked("1");
				this.save(pyShoppingCart);
				pyShoppingCartList.add(pyShoppingCart);
			}
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
			data.put("pyShoppingCartList", pyShoppingCartList);
			responseInfo.setData(data);
		}catch(Exception e){
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("添加购物车失败");
		}
		return responseInfo;
	}

	@Override
	public ResponseInfo updatePyShoppingCart(JSONObject json) {
		ResponseInfo responseInfo = new ResponseInfo();
		try{
			JSONArray jSONArray =  json.getJSONArray("goodsList");
			for(int i=0;jSONArray.size()>i;i++){
				JSONObject jsonObject = jSONArray.getJSONObject(i);
				PyShoppingCart pyShoppingCart = new PyShoppingCart();
				pyShoppingCart.setIds(jsonObject.getString("ids").toString());
				pyShoppingCart.setUserids(jsonObject.getString("userId").toString());
				pyShoppingCart.setGoodsIds(jsonObject.getString("goodsId").toString());
				pyShoppingCart.setGoodsNum(Short.valueOf(jsonObject.getString("goodsNum").toString()));
				pyShoppingCart.setVendorid("1");
				pyShoppingCart.setChecked("1");
				this.update(pyShoppingCart);
			}
				responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
				responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}catch(Exception e){
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("更新购物车失败");
		}
		return responseInfo;
	}

	@Override
	public ResponseInfo deletePyShoppingCartById(JSONObject json) {
		ResponseInfo responseInfo = new ResponseInfo();
		try{
			JSONArray jSONArray =  json.getJSONArray("goodsList");
			for(int i=0;jSONArray.size()>i;i++){
				JSONObject jsonObject = jSONArray.getJSONObject(i);
				this.deleteById(jsonObject.getString("id").toString());
			}
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}catch(Exception e){
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error("删除购物车失败");
		}
		return responseInfo;
	}
	
}
