package com.chinasofti.mall.user.mapper;

import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUser;
import com.chinasofti.mall.common.entity.ptroleuser.PtRoleUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PtRoleUserMapper {
    int countByExample(PtRoleUserExample example);

    int deleteByExample(PtRoleUserExample example);
    
    int deleteByPrimaryKey(String ids);
    
    int deleteByUserIds(String ids);

    int insert(PtRoleUser record);

    int insertSelective(PtRoleUser record);

    List<PtRoleUser> selectByExample(PtRoleUserExample example);

    int updateByExampleSelective(@Param("record") PtRoleUser record, @Param("example") PtRoleUserExample example);

    int updateByExample(@Param("record") PtRoleUser record, @Param("example") PtRoleUserExample example);
}