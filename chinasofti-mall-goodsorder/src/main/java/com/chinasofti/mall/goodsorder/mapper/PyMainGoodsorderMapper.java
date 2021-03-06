package com.chinasofti.mall.goodsorder.mapper;

import com.chinasofti.mall.common.entity.order.MainorderCondition;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyMainGoodsorderMapper {
	
    int countByExample(PyMainGoodsorderExample example);

    int deleteByExample(PyMainGoodsorderExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PyMainGoodsorder record);

    int insertSelective(PyMainGoodsorder record);

    List<PyMainGoodsorder> selectByExample(PyMainGoodsorderExample example);

    PyMainGoodsorder selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PyMainGoodsorder record, @Param("example") PyMainGoodsorderExample example);

    int updateByExample(@Param("record") PyMainGoodsorder record, @Param("example") PyMainGoodsorderExample example);

    int updateByPrimaryKeySelective(PyMainGoodsorder record);

    int updateByPrimaryKey(PyMainGoodsorder record);
    
    List<PyMainGoodsorder> selectByMainorderCondition(MainorderCondition mainorderCondition);
    
    List<PyMainGoodsorder> selectByUserIds(String userIds);

	List<PyMainGoodsorder> selectByBigGoodsorderIds(String transactionid);

	int updateByBigGoodsorder(String transactionid);

	int updateOrderByPay(String transactionid);
    
}