package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.baidu.ueditor.ActionEnter;
import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.common.entity.goods.GoodsFile;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsFeignClient;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;
import com.chinasofti.mall.web.entrance.service.impl.GoodsFileServiceImpl;

import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodsCheck")
public class ChnGoodsCheckController {
	
	@Autowired
	ChnGoodsFeignClient chnGoodsFeignClient;
	
	@Autowired
	SpMerchantUserFeignClient spMerchantUserFeignClient;
	
	@Autowired
	GoodsFileServiceImpl goodsFileService;
	
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
	 * 商品页面查询商品图片
	 * @return
	 */
	@RequestMapping("/reqGoodsGoodsImgPath/{ids}")
	public String reqGoodsImgPath(@PathVariable String ids){
		
		GoodsFile goodsFile = goodsFileService.selectByGoodsIds(ids);
		
//		String filepath = goodsFile.getFilepath();
//		String newFilePath = filepath.substring(1);
		
		return goodsFile.getFilepath();
		
	}
	
	/**
	 * 商品添加页面查询商品分类
	 * @return
	 */
	@RequestMapping("/reqGoodsClassName")
	public String reqGoodsClassName(){
		
		ChnGoodsClass chnGoodsClass = new ChnGoodsClass();
		chnGoodsClass.setStates("1");
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
	 * 根据ID删除商品,并删除图片
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete/{ids}")
	public int deleteGoodsCheckById(@PathVariable String ids){
		
		//删除图片文件
		GoodsFile goodsFile = goodsFileService.selectByGoodsIds(ids);
		String filepath = goodsFile.getFilepath();
		String imgPath = beforePath + File.separator + filepath.substring(filepath.lastIndexOf("/")+1);
		File file = new File(imgPath);
		if (file.exists()) {
			file.delete();
		}
		//删除对应商品id的图片数据
		goodsFileService.deleteByGoodsIds(ids);
		//删除商品
		int delImg = chnGoodsFeignClient.deleteGoodsCheckById(ids);
		
		return delImg;
		
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
	public String addGoods(HttpServletRequest request,ChnGoodsinfoCheck chnGoodsinfoCheck,HttpSession session){
		
		MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
		
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("img");
		String imageName = multipartFile.getOriginalFilename();
		
		//文件上传
		String fileName = beforePath + File.separator + imageName;
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
		PtUser user = (PtUser) session.getAttribute("user");
		
		chnGoodsinfoCheck.setIds(UUIDUtils.getUuid());
		chnGoodsinfoCheck.setGoodsids(UUIDUtils.getUuid());
		chnGoodsinfoCheck.setReviewStatues("0");
		chnGoodsinfoCheck.setCreateBy(user.getUsername());
		chnGoodsinfoCheck.setCreateTime(sdf.format(new Date()));
		chnGoodsinfoCheck.setStartTime(StringDateUtil.convertToSqlFormat(chnGoodsinfoCheck.getStartTime()));
		chnGoodsinfoCheck.setEndTime(StringDateUtil.convertToSqlFormat(chnGoodsinfoCheck.getEndTime()));
		
		//保存商品信息(goodsCheck表)
		int goodsCheck = chnGoodsFeignClient.saveGoodsCheck(chnGoodsinfoCheck);
		//保存对应的图片信息(goodsFile表)
		GoodsFile goodsFile = new GoodsFile();
		goodsFile.setIds(UUIDUtils.getUuid());
		goodsFile.setGoodsids(chnGoodsinfoCheck.getGoodsids());
		goodsFile.setFilename(imageName);
		goodsFile.setFilepath("/data/goods/"+ imageName);
		goodsFile.setFiletype(imageName.substring(imageName.lastIndexOf(".")+1));
		goodsFileService.insert(goodsFile);
		
		return String.valueOf(goodsCheck);
	}
	
	/**
	 * 商品审核(0.提交审核,3.撤销审核,1.审核通过,2.审核拒绝)
	 * @param chnGoodsinfoCheck
	 * @return
	 */
	@RequestMapping("/updateGoodsCheckStatus")
	public int updateGoodsCheck(ChnGoodsinfoCheck chnGoodsinfoCheck){
		
		return chnGoodsFeignClient.updateGoodsCheckReviewStatus(chnGoodsinfoCheck);
		
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









