package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.ueditor.ActionEnter;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsFeignClient;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodsCheck")
public class ChnGoodsCheckController {
	
	@Autowired
	ChnGoodsFeignClient chnGoodsFeignClient;
	
	@Autowired
	SpMerchantUserFeignClient spMerchantUserFeignClient;
	
	private static final String beforePath = System.getProperty("user.dir")  + "\\src\\main\\resources\\static\\data\\goods";
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goodscheck");
	}
	
	/**
	 * 商品添加页面查询商品分类
	 * @return
	 */
	@RequestMapping("/reqGoodsClassName")
	public String reqGoodsClassName(){
		
		ChnGoodsClass chnGoodsClass = new ChnGoodsClass();
		JSONObject goodsClass = chnGoodsFeignClient.selectByGoodsClass(chnGoodsClass);
		
		return goodsClass.toString();
		
	}
	
	/**
	 * 商品添加页查询商户名称
	 * @return
	 */
	@RequestMapping("/reqSpUserName")
	public String reqSpUserName(){
		
		SpMerchantUser spMerchantUser = new SpMerchantUser();
		JSONObject spUser = spMerchantUserFeignClient.selectBySpUser(spMerchantUser);
		
		return spUser.toString();
	}
	
	/**
	 * 列表及条件查询
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByGoodsCheck(ChnGoodsinfoCheck chnGoodsinfoCheck){
		JSONObject jsonlist = chnGoodsFeignClient.selectByGoodsCheck(chnGoodsinfoCheck);
		return jsonlist.toString();
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/select/{ids}")
	public ChnGoodsinfoCheck selectByGoodsCheckById(@PathVariable String ids){
		ChnGoodsinfoCheck chnGoodsinfoCheck = chnGoodsFeignClient.selectGoodsCheckById(ids);
		return chnGoodsinfoCheck;
	}
	
	/**
	 * 添加商品
	 * @return
	 */
	@RequestMapping("/addGoods")
	public String addGoods(HttpServletRequest request,ChnGoodsinfoCheck chnGoodsinfoCheck){
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("img");
		String imageName = multipartFile.getOriginalFilename();
		
		String fileName = beforePath + File.separator + imageName;
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		chnGoodsinfoCheck.setIds(UUID.randomUUID().toString().replace("-", ""));
		chnGoodsinfoCheck.setGoodsids(UUID.randomUUID().toString().replace("-", ""));
		
		return "保存成功";
	}
	
	/**
	 * 富文本编辑器多图保存
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/ueditor")
	@ResponseBody
	public void ueUpload(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		
		response.setContentType("application/json");  
        String rootPath = request.getSession().getServletContext().getRealPath("/");  
        try {  
            String exec = new ActionEnter(request, rootPath).exec();  
            PrintWriter writer = response.getWriter();  
            writer.write(exec);  
            writer.flush();  
            writer.close();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } 
		
	}
	
	
}









