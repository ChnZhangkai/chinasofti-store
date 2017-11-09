package com.chinasofti.mall.user.mapper;

import com.chinasofti.mall.common.entity.PtOperator;
import com.chinasofti.mall.common.entity.PtOperatorExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PtOperatorMapper {
    int countByExample(PtOperatorExample example);

    int deleteByExample(PtOperatorExample example);

    int deleteByPrimaryKey(String ids);

    int insert(PtOperator record);

    int insertSelective(PtOperator record);

    List<PtOperator> selectByExample(PtOperatorExample example);

    PtOperator selectByPrimaryKey(String ids);

    int updateByExampleSelective(@Param("record") PtOperator record, @Param("example") PtOperatorExample example);

    int updateByExample(@Param("record") PtOperator record, @Param("example") PtOperatorExample example);

    int updateByPrimaryKeySelective(PtOperator record);

    int updateByPrimaryKey(PtOperator record);
}