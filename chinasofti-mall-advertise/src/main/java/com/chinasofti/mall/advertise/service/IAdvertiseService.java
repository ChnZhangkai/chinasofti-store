package com.chinasofti.mall.advertise.service;

import java.util.Map;

import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import com.chinasofti.mall.common.service.IBaseService;
/**
 * 
* @ClassName: IAdvertiseService
* @Description: AdvertiseService接口
* @author kanmeng
* @date 2017年11月2日 下午2:19:55 
* @version
 */
public interface IAdvertiseService extends IBaseService<CmsAdContentsWithBLOBs> {
	/**
	 * 
	* @Title: findByPage
	* @Description: 分页查询
	* @param @param paraMap
	* @param @return    参数
	* @return String    返回类型
	* @throws
	 */
	public String findByPage(Map<String,Object> paramMap);
}
