package com.chinasofti.mall.goodsorder.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.order.PyShoppingCart;
import com.chinasofti.mall.common.entity.order.VendorShoppingcartVO;

public interface PyShoppingCartMapper {
	public int deleteByPrimaryKey(PyShoppingCart record);

	public int insert(PyShoppingCart record);

	public int insertSelective(PyShoppingCart record);

	public PyShoppingCart selectByPrimaryKey(String ids);

	public int updateByPrimaryKeyWithBLOBs(PyShoppingCart record);

	public int updateByPrimaryKeySelective(PyShoppingCart record);

	public int updateByPrimaryKey(PyShoppingCart record);

	public List<VendorShoppingcartVO> getPyShoppingCartListByUserId(@Param("userId") String userId);

	public PyShoppingCart IsUserExistGoods(PyShoppingCart record);
    
}