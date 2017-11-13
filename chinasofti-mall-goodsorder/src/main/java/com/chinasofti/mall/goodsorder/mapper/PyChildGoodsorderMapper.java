package com.chinasofti.mall.goodsorder.mapper;

import com.chinasofti.mall.common.entity.order.ChildorderCondition;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorderExample;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyChildGoodsorderMapper {
    int countByExample(PyChildGoodsorderExample example);

    int deleteByExample(PyChildGoodsorderExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PyChildGoodsorder record);

    int insertSelective(PyChildGoodsorder record);

    List<PyChildGoodsorder> selectByExample(PyChildGoodsorderExample example);

    PyChildGoodsorder selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PyChildGoodsorder record, @Param("example") PyChildGoodsorderExample example);

    int updateByExample(@Param("record") PyChildGoodsorder record, @Param("example") PyChildGoodsorderExample example);

    int updateByPrimaryKeySelective(PyChildGoodsorder record);

    int updateByPrimaryKey(PyChildGoodsorder record);
    
    List<PyChildGoodsorder> selectByChildorderCondition(ChildorderCondition childorderCondition);
}