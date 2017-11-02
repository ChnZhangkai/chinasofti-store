package com.chinasofti.mall.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.common.entity.PtHrUserBakExample;


public interface PtHrUserBakMapper {
    int countByExample(PtHrUserBakExample example);

    int deleteByExample(PtHrUserBakExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PtHrUserBak record);

    int insertSelective(PtHrUserBak record);

    List<PtHrUserBak> selectByExample(PtHrUserBakExample example);

    PtHrUserBak selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PtHrUserBak record, @Param("example") PtHrUserBakExample example);

    int updateByExample(@Param("record") PtHrUserBak record, @Param("example") PtHrUserBakExample example);

    int updateByPrimaryKeySelective(PtHrUserBak record);

    int updateByPrimaryKey(PtHrUserBak record);
}