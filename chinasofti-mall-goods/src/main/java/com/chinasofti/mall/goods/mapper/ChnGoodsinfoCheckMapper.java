package com.chinasofti.mall.goods.mapper;

import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheckExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChnGoodsinfoCheckMapper {
    int countByExample(ChnGoodsinfoCheckExample example);

    int deleteByExample(ChnGoodsinfoCheckExample example);

    int deleteByPrimaryKey(String ids);

    int insert(ChnGoodsinfoCheck record);

    int insertSelective(ChnGoodsinfoCheck record);

    List<ChnGoodsinfoCheck> selectByExample(ChnGoodsinfoCheckExample example);

    ChnGoodsinfoCheck selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") ChnGoodsinfoCheck record, @Param("example") ChnGoodsinfoCheckExample example);

    int updateByExample(@Param("record") ChnGoodsinfoCheck record, @Param("example") ChnGoodsinfoCheckExample example);

    int updateByPrimaryKeySelective(ChnGoodsinfoCheck record);

    int updateByPrimaryKey(ChnGoodsinfoCheck record);
    
    List<ChnGoodsinfoCheck> findAll(ChnGoodsinfoCheck chnGoodsinfoCheck);
    
    
}