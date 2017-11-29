package com.chinasofti.mall.goodsorder.mapper;

import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyBigGoodsorderMapper {
    int countByExample(PyBigGoodsorderExample example);

    int deleteByExample(PyBigGoodsorderExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PyBigGoodsorder record);

    int insertSelective(PyBigGoodsorder record);

    List<PyBigGoodsorder> selectByExample(PyBigGoodsorderExample example);

    PyBigGoodsorder selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PyBigGoodsorder record, @Param("example") PyBigGoodsorderExample example);

    int updateByExample(@Param("record") PyBigGoodsorder record, @Param("example") PyBigGoodsorderExample example);

    int updateByPrimaryKeySelective(PyBigGoodsorder record);

    int updateByPrimaryKey(PyBigGoodsorder record);
    
    List<PyBigGoodsorder> selectByUserIds(String userId);
}