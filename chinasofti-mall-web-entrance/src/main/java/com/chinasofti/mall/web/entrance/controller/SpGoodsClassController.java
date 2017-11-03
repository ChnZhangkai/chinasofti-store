package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.SpGoodsClass;
import com.chinasofti.mall.web.entrance.feign.SpGoodsClassFeignClient;

/**
 * 商品分类服务消费
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class SpGoodsClassController {
	
	@Autowired
	private SpGoodsClassFeignClient spGoodsClassFeignClient;
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goods");
	}
	
	/**
	 * 列表及条件查询
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByGoodsClass(SpGoodsClass spGoodsClass,HttpServletRequest req){
		String jsonlist = spGoodsClassFeignClient.selectByGoodsClass(spGoodsClass);
		return jsonlist;
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/select/{ids}")
	public SpGoodsClass selectByGoodsClassById(@PathVariable String ids){
		SpGoodsClass spGoodsClass = spGoodsClassFeignClient.selectGoodsClassById(ids);
		return spGoodsClass;
	}
	
	/**
	 * 修改
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/update")
	public int updateGoodsClassById(SpGoodsClass spGoodsClass){
		int updateGoodsClass = spGoodsClassFeignClient.updateGoodsClass(spGoodsClass);
		return updateGoodsClass;
	}
	
	/**
	 * 根据ID删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete/{ids}")
	public int deleteGoodsClassById(@PathVariable String ids){
		int delById = spGoodsClassFeignClient.deleteGoodsClassById(ids);
		return delById;
	}
	
	/**
	 * 增加
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/save")
	public int saveGoodsClass(MultipartHttpServletRequest multipartHttpServletRequest){
		
//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		String basePath = System.getProperty("user.dir");
		String ImagePath = basePath  + "\\src\\main\\resources\\static\\images\\goods";
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("url");
		String imageName = multipartFile.getOriginalFilename();
		
		String fileName = ImagePath + File.separator + imageName;
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		SpGoodsClass spGoodsClass = new SpGoodsClass();
//		goodscategory.setIds(Integer.valueOf(multipartHttpServletRequest.getParameter("ids")));
//		goodscategory.setName(multipartHttpServletRequest.getParameter("name"));
//		goodscategory.setUrl("/images/goods/" + imageName);
//		goodscategory.setTitle(multipartHttpServletRequest.getParameter("title"));
		
//		int saveGoodsCategory = spGoodsClassFeignClient.saveGoodsClass(goodscategory);
		return 0;
	}
}
