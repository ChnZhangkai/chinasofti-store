package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.ChnGoodsClass;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsClassFeignClient;

import net.sf.json.JSONObject;

/**
 * 商品分类服务消费
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class ChnGoodsClassController {
	
	@Autowired
	private ChnGoodsClassFeignClient chnGoodsClassFeignClient;
	
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
	public String selectByGoodsClass(ChnGoodsClass chnGoodsClass){
		JSONObject jsonlist = chnGoodsClassFeignClient.selectByGoodsClass(chnGoodsClass);
		return jsonlist.toString();
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/select/{ids}")
	public ChnGoodsClass selectByGoodsClassById(@PathVariable String ids){
		ChnGoodsClass chnGoodsClass = chnGoodsClassFeignClient.selectGoodsClassById(ids);
		return chnGoodsClass;
	}
	
	/**
	 * 修改
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/update")
	public int updateGoodsClassById(ChnGoodsClass chnGoodsClass){
		int updateGoodsClass = chnGoodsClassFeignClient.updateGoodsClass(chnGoodsClass);
		return updateGoodsClass;
	}
	
	/**
	 * 根据ID删除分类,并删除图片
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete/{ids}")
	public int deleteGoodsClassById(@PathVariable String ids){
		ChnGoodsClass delImg = chnGoodsClassFeignClient.selectGoodsClassById(ids);
		String beforePath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\data\\goods";
		String relWay = delImg.getImg();
		String imageName = relWay.substring(relWay.lastIndexOf("/")+1);
		String imgUrl = beforePath + File.separator + imageName;
		File file = new File(imgUrl);
		if (file.exists()) {
			file.delete();
		}
		int delById = chnGoodsClassFeignClient.deleteGoodsClassById(ids);
		return delById;
	}
	
	/**
	 * 增加分类,并保存图片到项目文件中
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/save")
	public int saveGoodsClass(MultipartHttpServletRequest multipartHttpServletRequest){
		
//		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		String basePath = System.getProperty("user.dir");
		String ImagePath = basePath  + "\\src\\main\\resources\\static\\data\\goods";
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
		
		ChnGoodsClass chnGoodsClass = new ChnGoodsClass();
		chnGoodsClass.setIds(UUID.randomUUID().toString().replace("-", ""));;
		chnGoodsClass.setName(multipartHttpServletRequest.getParameter("name"));
		chnGoodsClass.setCommons(multipartHttpServletRequest.getParameter("commons"));
		chnGoodsClass.setStates(multipartHttpServletRequest.getParameter("states"));
		chnGoodsClass.setImg("/data/goods/" + imageName);
		chnGoodsClass.setCreateBy("Mrzhang");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		chnGoodsClass.setCreateTime(df.format(new Date()));
		int chngoodsClass = chnGoodsClassFeignClient.saveGoodsClass(chnGoodsClass);
		return chngoodsClass;
	}
}
