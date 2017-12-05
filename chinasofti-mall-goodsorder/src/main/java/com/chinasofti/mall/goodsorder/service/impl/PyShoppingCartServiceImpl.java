package com.chinasofti.mall.goodsorder.service.impl;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.entity.order.VendorShoppingcartVO;
import com.chinasofti.mall.common.service.RequestParamService;
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



 
	public int deleteById(PyShoppingCart goods) { 
		return pyShoppingCartMapper.deleteByPrimaryKey(goods);
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
	public ResponseInfo savePyShoppingCart(List<PyShoppingCart>goodsList) {
		ResponseInfo response = new ResponseInfo();
		if (goodsList.size() == 0 || "".equals(goodsList)) {
			response.setRetCode(MsgEnum.SERVER_ERROR.getCode());
			response.setRetMsg("请选择要添加购物车的商品！");
			return response;
		}
		for (PyShoppingCart goods : goodsList) {
			// 参数校验
			ResponseInfo result = RequestParamService.packageWithAddShoppingCartParam(goods);
			if (result != null) {
				return result;
			}
			// 加上商品校验（弄一个通用的）

			PyShoppingCart shoppingCar = pyShoppingCartMapper.IsUserExistGoods(goods);

			if (shoppingCar != null) {
				goods.setId(shoppingCar.getId());
				goods.setGoodsNum(goods.getGoodsNum().add(shoppingCar.getGoodsNum()));
				pyShoppingCartMapper.updateByPrimaryKeySelective(goods);
			} else {
				goods.setId(UUIDUtils.getUuid());
				goods.setPayStatus(Constant.PAY_STATUS);
				goods.setChecked(Constant.CHECKED);
				goods.setCreateTime(StringDateUtil.getStringTime());
				this.save(goods);
			}

			response.setRetCode(MsgEnum.SUCCESS.getCode());
			response.setRetMsg(MsgEnum.SUCCESS.getMsg());
		}

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

		if (goodsList.size() == 0 || "".equals(goodsList)) {
			responseInfo.setRetCode(MsgEnum.SERVER_ERROR.getCode());
			responseInfo.setRetMsg("请选择要删除的商品！");
			return responseInfo;
		}
		for (PyShoppingCart goods : goodsList) {
			
			ResponseInfo result = RequestParamService.packageWithAddShoppingCartParam(goods);
			if (result != null) {
				return result;
			}
			int row = deleteById(goods);
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
