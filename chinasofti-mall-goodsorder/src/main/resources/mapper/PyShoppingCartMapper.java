package com.chinasofti.mall.goodsorder.mapper;

import java.util.List;

import com.chinasofti.mall.common.entity.PyShoppingCart;

public interface PyShoppingCartMapper {
    int deleteByPrimaryKey(String ids);

    int insert(PyShoppingCart record);

    int insertSelective(PyShoppingCart record);

    PyShoppingCart selectByPrimaryKey(String ids);

    int updateByPrimaryKeySelective(PyShoppingCart record);

    int updateByPrimaryKeyWithBLOBs(PyShoppingCart record);

    int updateByPrimaryKey(PyShoppingCart record);
    
    List<PyShoppingCart> getPyShoppingCartListByUserId(String userId);
    
}