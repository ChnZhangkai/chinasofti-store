package com.chinasofti.mall.goodsorder.mapper;

import com.chinasofti.mall.common.entity.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.PyMainGoodsorderExample;
import com.chinasofti.mall.common.entity.PyMainGoodsorderWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyMainGoodsorderMapper {
    int countByExample(PyMainGoodsorderExample example);

    int deleteByExample(PyMainGoodsorderExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PyMainGoodsorderWithBLOBs record);

    int insertSelective(PyMainGoodsorderWithBLOBs record);

    List<PyMainGoodsorderWithBLOBs> selectByExampleWithBLOBs(PyMainGoodsorderExample example);

    List<PyMainGoodsorder> selectByExample(PyMainGoodsorderExample example);

    PyMainGoodsorderWithBLOBs selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PyMainGoodsorderWithBLOBs record, @Param("example") PyMainGoodsorderExample example);

    int updateByExampleWithBLOBs(@Param("record") PyMainGoodsorderWithBLOBs record, @Param("example") PyMainGoodsorderExample example);

    int updateByExample(@Param("record") PyMainGoodsorder record, @Param("example") PyMainGoodsorderExample example);

    int updateByPrimaryKeySelective(PyMainGoodsorderWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(PyMainGoodsorderWithBLOBs record);

    int updateByPrimaryKey(PyMainGoodsorder record);
}