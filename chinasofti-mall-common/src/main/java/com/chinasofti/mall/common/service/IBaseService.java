package com.chinasofti.mall.common.service;

import java.util.List;

/**
 * 
 * @ClassName: IBaseService
 * @Description: 公共service
 * @author KanM
 * @date 2017年11月1日 下午12:25:28
 * @param <T>
 */
public interface IBaseService<T> {
	
	/**
	* @Title: save
	* @Description: 增加
	* @param @param t	实体对象
	* @param @return    参数
	* @return int    返回类型
	* @throws
	*/
	public int save(T t);

	/**
	* @Title: findAll
	* @Description: 查询所有
	* @param @return    参数
	* @return List<T>    返回类型
	* @throws
	*/
	public List<T> findAll();

	/**
	* @Title: findById
	* @Description: 通过id查询
	* @param @param id
	* @param @return    参数
	* @return T    返回类型
	* @throws
	*/
	public T findById(String id);

	/**
	* @Title: deleteById
	* @Description: 通过id删除
	* @param @param id
	* @param @return    参数
	* @return int    返回类型
	* @throws
	*/
	public int deleteById(String id);

	/**
	* @Title: update
	* @Description: 更新
	* @param @param t 实体对象
	* @param @return    参数
	* @return int    返回类型
	* @throws
	*/
	public int update(T t);
}
