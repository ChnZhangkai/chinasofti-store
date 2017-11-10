package com.chinasofti.mall.goodsorder.mapper;

import com.chinasofti.mall.common.entity.order.PyPayorder;
import com.chinasofti.mall.common.entity.order.PyPayorderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PyPayorderMapper {
    int countByExample(PyPayorderExample example);

    int deleteByExample(PyPayorderExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PyPayorder record);

    int insertSelective(PyPayorder record);

    List<PyPayorder> selectByExample(PyPayorderExample example);

    PyPayorder selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PyPayorder record, @Param("example") PyPayorderExample example);

    int updateByExample(@Param("record") PyPayorder record, @Param("example") PyPayorderExample example);

    int updateByPrimaryKeySelective(PyPayorder record);

    int updateByPrimaryKey(PyPayorder record);
}