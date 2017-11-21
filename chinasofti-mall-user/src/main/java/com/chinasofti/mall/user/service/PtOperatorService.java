package com.chinasofti.mall.user.service;
 
import com.chinasofti.mall.common.entity.PtOperator;

public interface PtOperatorService {

	String save(PtOperator ptOperator);

	int update(PtOperator ptOperator);

	int delete(String ids);

}
