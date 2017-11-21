package com.chinasofti.mall.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.PtUserExample;

public interface PtUserMapper {
    int countByExample(PtUserExample example);

    int deleteByExample(PtUserExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PtUser record);

    int insertSelective(PtUser record);

    List<PtUser> selectByExampleWithBLOBs(PtUserExample example);

    List<PtUser> selectByExample(PtUserExample example);

    PtUser selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PtUser record, @Param("example") PtUserExample example);

    int updateByExampleWithBLOBs(@Param("record") PtUser record, @Param("example") PtUserExample example);

    int updateByExample(@Param("record") PtUser record, @Param("example") PtUserExample example);

    int updateByPrimaryKeySelective(PtUser record);

    int updateByPrimaryKeyWithBLOBs(PtUser record);

    int updateByPrimaryKey(PtUser record);
}