package com.chinasofti.mall.advertise.service;

import java.util.Map;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.service.IBaseService;
/**
 * 
* @ClassName: IAdvertiseService
* @Description: AdvertiseService接口
* @author KanM
* @date 2017年11月2日 下午2:19:55 
* @version
 */
public interface IAdvertiseService extends IBaseService<AdvertiseContents> {
	/**
	 * 
	* @Title: findByPage
	* @Description: 分页查询
	* @param paramMap
	* @return: String
	* @throws:
	 */
	public String findByPage(Map<String,Object> paramMap);
}
