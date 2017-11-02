package com.chinasofti.mall.user.service;

import java.util.List;
import com.chinasofti.mall.common.entity.PtHrUserBak;
import com.chinasofti.mall.common.service.IBaseService;

public interface PrHrUserService extends IBaseService<PtHrUserBak>{

	List<PtHrUserBak> selectByExample(PtHrUserBak ptHrUserBak);

}
