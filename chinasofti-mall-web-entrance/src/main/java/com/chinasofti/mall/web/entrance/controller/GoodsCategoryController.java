package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.Goodscategory;
import com.chinasofti.mall.web.entrance.feign.GoodsCategoryFeignClient;

/**
 * 商品分类服务消费
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class GoodsCategoryController {
	
	@Autowired
	private GoodsCategoryFeignClient goodsCategoryFeignClient;
	
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
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByGoodsCategory(Goodscategory goodscategory){
		
		String jsonlist = goodsCategoryFeignClient.selectByGoodsCategory(goodscategory);
		return jsonlist;
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/select/{ids}")
	public Goodscategory selectByGoodsCategoryId(@PathVariable Integer ids){
		Goodscategory goodscategory = goodsCategoryFeignClient.selectById(ids);
		return goodscategory;
	}
	
	/**
	 * 修改
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping("/update")
	public int updateGoodsCategoryById(Goodscategory goodscategory){
		int updateGoodsCategoryById = goodsCategoryFeignClient.updateGoodsCategoryById(goodscategory);
		return updateGoodsCategoryById;
	}
	
	/**
	 * 根据ID删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete/{ids}")
	public int deleteGoodsCategoryById(@PathVariable Integer ids){
		int delById = goodsCategoryFeignClient.deleteGoodsCategory(ids);
		return delById;
	}
	
	/**
	 * 增加
	 * @param goodscategory
	 * @return
	 */
	@RequestMapping("/save")
	public int saveGoodsCategory(MultipartHttpServletRequest multipartHttpServletRequest){
		
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
		
		Goodscategory goodscategory = new Goodscategory();
		goodscategory.setIds(Integer.valueOf(multipartHttpServletRequest.getParameter("ids")));
		goodscategory.setName(multipartHttpServletRequest.getParameter("name"));
		goodscategory.setUrl("/images/goods/" + imageName);
		goodscategory.setTitle(multipartHttpServletRequest.getParameter("title"));
		
		int saveGoodsCategory = goodsCategoryFeignClient.saveGoodsCategory(goodscategory);
		return saveGoodsCategory;
	}
}
