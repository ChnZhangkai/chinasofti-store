package com.chinasofti.mall.goodsorder.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.entity.order.VendorShoppingcartVO;
import com.chinasofti.mall.common.utils.Constant;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.common.utils.UUIDUtils;
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
	

	public int save(PyShoppingCart goods) {
		return pyShoppingCartMapper.insert(goods);
	}

	public int update(PyShoppingCart goods) {
		return pyShoppingCartMapper.updateByPrimaryKey(goods);
	}

	@Override
	public List<VendorShoppingcartVO> queryPyShoppingCartListByUserId(String userId) {
	
		return  pyShoppingCartMapper.getPyShoppingCartListByUserId(userId);	
	}


	@Override
	public ResponseInfo savePyShoppingCart(PyShoppingCart goodsInfo) {
		ResponseInfo response = new ResponseInfo();
		
		PyShoppingCart shoppingCar = pyShoppingCartMapper.IsUserExistGoods(goodsInfo);

		if (shoppingCar != null) {
			goodsInfo.setId(shoppingCar.getId());
			goodsInfo.setGoodsNum(goodsInfo.getGoodsNum().add(shoppingCar.getGoodsNum()));
			pyShoppingCartMapper.updateByPrimaryKey(goodsInfo);
		} else {
			goodsInfo.setId(UUIDUtils.getUuid());
			goodsInfo.setPayStatus(Constant.PAY_STATUS);
			goodsInfo.setChecked(Constant.CHECKED);
			goodsInfo.setCreateTime(StringDateUtil.getStringTime());
			this.save(goodsInfo);
		}

		response.setRetCode(MsgEnum.SUCCESS.getCode());
		response.setRetMsg(MsgEnum.SUCCESS.getMsg());

		return response;
	}
	
	
	@Override
	public int updatePyShoppingCart(PyShoppingCart goodsInfo) {
		logger.info(goodsInfo.toString());
		return this.update(goodsInfo);	 
	}

	@Override
	public ResponseInfo deletePyShoppingCartById(List<PyShoppingCart> goodsList) {
		ResponseInfo responseInfo = new ResponseInfo();

		for (PyShoppingCart goods : goodsList) {
			
			int row = deleteById(goods.getId());
			if (row <= 0) {
				responseInfo.setRetCode(MsgEnum.ERROR.getCode());
				responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
				logger.error("删除购物车失败");
				break;
			}
			responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
			responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());

		}

		return responseInfo;
	}
	
}
