package com.chinasofti.mall.goods.service;

import java.util.List;
import java.util.Map;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.AdvertisePosition;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.common.utils.ResponseInfo;
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
	
	public int pubOrCanAdvertise(Map<String, Object> map);
	/**
	 * 根据位置Id查询广告信息
	 * @param positionId
	 * @return
	 */
	public List<AdvertiseContents> queryAdvertiseList(String positionId) ;
	
	public ResponseInfo queryAdvertise(String positionId);
	/**
	 * 
	* @Title: findAdPostionAll
	* @Description: 查询所有位置广告位置信息
	* @return: List<AdvertisePosition>
	* @throws:
	 */
	public List<AdvertisePosition> findAdPostionAll();
}
