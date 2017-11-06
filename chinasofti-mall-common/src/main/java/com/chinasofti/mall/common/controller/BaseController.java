package com.chinasofti.mall.common.controller;

import java.util.List;
/**
 * 
* @ClassName: BaseController
* @Description: 公共controller
* @author KanM
* @date 2017年11月1日 上午12:08:42 
* @param <T>
 */
public interface BaseController<T> {
	
	//public abstract String getPath();
	
	//public abstract IBaseService<T> getService();

	/**
	* @Title: findAll
	* @Description: 查询所有
	* @return List<T>
	* @throws
	*/
	public List<T> findAll( );
	
	/**
	* @Title: findById
	* @Description: 通过id查询
	* @param id
	* @return T
	* @throws
	*/
	public T findById(String id);	
	/**
	* @Title: deleteById
	* @Description: 根据id删除
	* @param id
	* @return String
	* @throws
	*/
	public String deleteById(String id);	
	/**
	* @Title: update
	* @Description: 更新
	* @param t
	* @return String
	* @throws
	*/
	public String update(T t);
	
	/**
	* @Title: add
	* @Description: 添加
	* @param t
	* @return String
	* @throws
	*/
	public String add(T t);
}
