package com.chinasofti.mall.goodsorder.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
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
	

	public int save(PyShoppingCart t) {
		return pyShoppingCartMapper.insert(t);
	}

	public int update(PyShoppingCart goods) {
		return pyShoppingCartMapper.updateByPrimaryKey(goods);
	}

	@Override
	public ResponseInfo queryPyShoppingCartListByUserId(String userId) {
		ResponseInfo responseInfo = new ResponseInfo();
		Map<String, Object> data = new HashMap<String, Object>();

		try {
			List<VendorShoppingcartVO> pyShoppingCartList = pyShoppingCartMapper.getPyShoppingCartListByUserId(userId);
			if (pyShoppingCartList != null) {
				List<Map<String, List<ChnGoodsinfo>>> vendorList = pakacgeReponseData(pyShoppingCartList);
				data.put("pyShoppingCartList", vendorList);
				responseInfo.setData(data);
				responseInfo.setRetCode(MsgEnum.SUCCESS.getCode());
				responseInfo.setRetMsg(MsgEnum.SUCCESS.getMsg());
			} else {
				responseInfo.setRetCode(MsgEnum.SERVER_ERROR.getCode());
				responseInfo.setRetMsg("购物车内无商品！");
			}

		} catch (Exception e) {
			responseInfo.setRetCode(MsgEnum.ERROR.getCode());
			responseInfo.setRetMsg(MsgEnum.ERROR.getMsg());
			logger.error(userId + "：查询购物车失败");
		}
		return responseInfo;
	}

	private List<Map<String, List<ChnGoodsinfo>>> pakacgeReponseData(List<VendorShoppingcartVO> pyShoppingCartList) {
		//存放商户下相关商品List的Map
		Map<String,  List<ChnGoodsinfo>> vendorMap = new HashMap<String,  List<ChnGoodsinfo>>();
		//存放所有商户的信息的List
		List<Map<String, List<ChnGoodsinfo>>>vendorList =new ArrayList<Map<String, List<ChnGoodsinfo>>>();
		
		
		String vendorNm =null;
		for(VendorShoppingcartVO shopgoods :pyShoppingCartList){
			 vendorNm = shopgoods.getVendorId()+"#"+shopgoods.getVendorSnm();
			 List<ChnGoodsinfo> goodsList=vendorMap.get(vendorNm);
			 if(goodsList==null){
				 goodsList= new ArrayList<ChnGoodsinfo>();
			 }	
			ChnGoodsinfo buyGoods = new ChnGoodsinfo(); 
			buyGoods.setIds(shopgoods.getId());
			buyGoods.setGoodsId(shopgoods.getGoodsId());
			buyGoods.setVendorids(shopgoods.getVendorId());
			buyGoods.setTitle(shopgoods.getGoodsName());
			buyGoods.setFilepath(Constant.HOST_URL+shopgoods.getFilepath());
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


	@Override
	public ResponseInfo savePyShoppingCart(List<PyShoppingCart>goodsList) {
		ResponseInfo responseInfo = new ResponseInfo();
		if(goodsList.size()>0){
			for(PyShoppingCart goods:goodsList){
				PyShoppingCart shoppingCar = pyShoppingCartMapper.IsUserExistGoods(goods);
				
				if(shoppingCar != null){
					goods.setId(shoppingCar.getId());
					goods.setGoodsNum(goods.getGoodsNum().add(shoppingCar.getGoodsNum()));
					pyShoppingCartMapper.updateByPrimaryKeySelective(goods);
				}else{
					goods.setId(UUIDUtils.getUuid());
					goods.setPayStatus(Constant.PAY_STATUS);
					goods.setChecked(Constant.CHECKED);
					goods.setCreateTime(StringDateUtil.getStringTime());
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
	public ResponseInfo updatePyShoppingCart(PyShoppingCart goodsInfo) {
		ResponseInfo responseInfo = new ResponseInfo();
			if(goodsInfo != null){
			
				this.update(goodsInfo);
				logger.info(goodsInfo.toString());
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
					int row = deleteById(goods.getId());
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
