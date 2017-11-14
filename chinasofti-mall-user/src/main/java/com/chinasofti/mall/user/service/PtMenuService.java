package com.chinasofti.mall.user.service;

import java.util.List;

import com.chinasofti.mall.common.entity.PtMenu;
import com.chinasofti.mall.common.service.IBaseService;

public interface PtMenuService extends IBaseService<PtMenu>{

	List<PtMenu> getMenu(String pids);

}
