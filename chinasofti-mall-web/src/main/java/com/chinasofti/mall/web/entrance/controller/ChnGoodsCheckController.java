package com.chinasofti.mall.web.entrance.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.ueditor.ActionEnter;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsClassFeignClient;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodscheck")
public class ChnGoodsCheckController {
	
	@Autowired
	ChnGoodsClassFeignClient chnGoodsClassFeignClient;
	
	@Autowired
	SpMerchantUserFeignClient spMerchantUserFeignClient;
	
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
		JSONObject goodsClass = chnGoodsClassFeignClient.selectByGoodsClass(chnGoodsClass);
		
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
	 * 富文本编辑器多图保存
	 * @return 
	 * @throws UnsupportedEncodingException 
	 */
	@RequestMapping("/ueditor")
	@ResponseBody
	public String ueUpload(HttpServletRequest request,HttpServletResponse response) throws UnsupportedEncodingException{
		
		//这里就是把controller.jsp代码copy下来
        request.setCharacterEncoding( "utf-8" );
        response.setHeader("Content-Type" , "text/html");
        String roolPath = request.getSession().getServletContext().getRealPath("/");
        String configStr = new ActionEnter(request, roolPath).exec();
        return configStr;
		
	}
	
	
}









