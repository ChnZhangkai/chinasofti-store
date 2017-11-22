package com.chinasofti.mall.goodsorder.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.goodsorder.mapper.PyShoppingCartMapper;
import com.chinasofti.mall.goodsorder.service.PyShoppingCartService;

@Service
public class PyShoppingCartServiceImpl implements PyShoppingCartService{
	
	private static final Logger logger = LoggerFactory.getLogger(PyShoppingCartServiceImpl.class);
	
	@Autowired
	private PyShoppingCartMapper pyShoppingCartMapper;




	public int deleteById(String id) {
		return pyShoppingCartMapper.deleteByPrimaryKey(id);
	}
	

	public int save(PyShoppingCart t) {
		return pyShoppingCartMapper.insert(t);
	}

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
	public ResponseInfo savePyShoppingCart(List<PyShoppingCart>goodsList) {
		ResponseInfo responseInfo = new ResponseInfo();
		if(goodsList.size()>0){
			for(PyShoppingCart goods:goodsList){
				PyShoppingCart shoppingCar = pyShoppingCartMapper.IsUserExistGoods(goods);
				
				if(shoppingCar != null){
					goods.setGoodsNum(goods.getGoodsNum().add(shoppingCar.getGoodsNum()));
					pyShoppingCartMapper.updateByPrimaryKeySelective(goods);
				}else{
					goods.setIds(UUID.randomUUID().toString());
					goods.setPayStatus(Constant.PAY_STATUS);
					goods.setChecked(Constant.CHECKED);
					goods.setCreateTime(StringDateUtil.convertToSqlShortFormat(new Date().toString()));
					this.save(goods);
				}
			}
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}else{
			responseInfo.setRetCode(MsgEnum.SERVER_ERROR.getCode());
			responseInfo.setRetMsg("请选择要添加购物车的商品！");
			return responseInfo;
		}

		return responseInfo;
	}

	@Override
	public ResponseInfo updatePyShoppingCart(List<PyShoppingCart>goodsList) {
		ResponseInfo responseInfo = new ResponseInfo();
			if(goodsList.size()>0){
			for(int i=0;goodsList.size()>i;i++){
				PyShoppingCart goods = goodsList.get(i);
				
				this.update(goods);
			}
				responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
				responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
			}else{
				
				responseInfo.setRetCode(MsgEnum.ERROR.getCode());
				responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
				return responseInfo;
			}
			
		return responseInfo;
	}

	@Override
	public ResponseInfo deletePyShoppingCartById(List<PyShoppingCart> goodsList) {
		ResponseInfo responseInfo = new ResponseInfo();
		try {
			if (goodsList.size() > 0) {
				for (int i = 0; goodsList.size() > i; i++) {
					PyShoppingCart goods = goodsList.get(i);
					int row = deleteById(goods.getIds());
					if (row <= 0) {
						responseInfo.setRetCode(MsgEnum.ERROR.getCode());
						responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
						logger.error("删除购物车失败");
					}else{
						responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
						responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
					}

				}
				
			}

		} catch (Exception e) {
			responseInfo.setRetCode(MsgEnum.SERVER_ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.SERVER_ERROR.getMsg());
			logger.error("服务异常，删除购物车失败！");
		}
		return responseInfo;
	}
	
}
