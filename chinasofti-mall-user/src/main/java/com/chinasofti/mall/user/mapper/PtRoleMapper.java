package com.chinasofti.mall.user.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

import com.chinasofti.mall.common.entity.PtRole;
import com.chinasofti.mall.common.entity.PtRoleExample;
import com.chinasofti.mall.common.entity.PtRoleOperator;

public interface PtRoleMapper {
    int countByExample(PtRoleExample example);

    int deleteByExample(PtRoleExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PtRole record);

    int insertSelective(PtRole record);

    List<PtRole> selectByExampleWithBLOBs(PtRoleExample example);

    List<PtRole> selectByExample(PtRoleExample example);

    PtRole selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PtRole record, @Param("example") PtRoleExample example);

    int updateByExampleWithBLOBs(@Param("record") PtRole record, @Param("example") PtRoleExample example);

    int updateByExample(@Param("record") PtRole record, @Param("example") PtRoleExample example);

    int updateByPrimaryKeySelective(PtRole record);

    int updateByPrimaryKeyWithBLOBs(PtRole record);

    int updateByPrimaryKey(PtRole record);
    
    int add2(String[] arr);
    
    List<String> getRoleMenuids(String roleId);
    
    List<String> getRoleOperatorIds(String roleId);

	int insertRoleOperator(PtRoleOperator roleOperator);

	int deleteByRoleIds(String ids);
    
}