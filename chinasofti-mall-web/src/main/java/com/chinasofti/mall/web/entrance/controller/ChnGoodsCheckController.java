package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
import com.chinasofti.mall.common.utils.JxlsExcelView;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsFeignClient;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;
import com.chinasofti.mall.web.entrance.service.impl.GoodsFileServiceImpl;

import net.sf.json.JSONArray;
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
		System.out.println("图片:"+goodsFile);
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
	public int addGoods(HttpServletRequest request,ChnGoodsinfoCheck chnGoodsinfoCheck,HttpSession session){
        MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest) request;  
		MultipartFile multipartFile = multipartRequest.getFile("img");
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
		
		PtUser user = (PtUser) session.getAttribute("user");
		
		
		chnGoodsinfoCheck.setIds(UUIDUtils.getUuid());
		chnGoodsinfoCheck.setGoodsids(UUIDUtils.getUuid());
		chnGoodsinfoCheck.setReviewStatues("0");
		chnGoodsinfoCheck.setCreateBy(user.getUsername());
		chnGoodsinfoCheck.setCreateTime(StringDateUtil.getStringTime());
		chnGoodsinfoCheck.setStartTime(StringDateUtil.getStringTime());
		chnGoodsinfoCheck.setEndTime(StringDateUtil.getStringTime());
		
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
		
		return goodsCheck;
	}
	
	
	
	/**
	 * 修改商品
	 * @return
	 */
	@RequestMapping("/updateGoods")
	public int updateGoods(HttpServletRequest request,ChnGoodsinfoCheck chnGoodsinfoCheck,HttpSession session){
		System.out.println("updateGoods:"+chnGoodsinfoCheck);
		MultipartHttpServletRequest multipartRequest =  (MultipartHttpServletRequest) request;  
		MultipartFile multipartFile = multipartRequest.getFile("img");
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
		
		PtUser user = (PtUser) session.getAttribute("user");
		
		chnGoodsinfoCheck.setReviewStatues("0");
		chnGoodsinfoCheck.setUpdateBy(user.getUsername());
		chnGoodsinfoCheck.setUpdateTime(StringDateUtil.getStringTime());
		chnGoodsinfoCheck.setStartTime(StringDateUtil.getStringTime());
		chnGoodsinfoCheck.setEndTime(StringDateUtil.getStringTime());
		
		//保存商品信息(goodsCheck表)
		int goodsCheck = chnGoodsFeignClient.updateGoodsCheck(chnGoodsinfoCheck);
		//保存对应的图片信息(goodsFile表)
		GoodsFile goodsFile = new GoodsFile();
		goodsFile.setFilename(imageName);
		goodsFile.setFilepath("/data/goods/"+ imageName);
		goodsFile.setFiletype(imageName.substring(imageName.lastIndexOf(".")+1));
		goodsFileService.updateByPrimaryKeySelective(goodsFile);
		
		return goodsCheck;
	}
	
	/**
	 * 商品审核(0.提交审核,3.撤销审核,1.审核通过,2.审核拒绝)
	 * @param chnGoodsinfoCheck
	 * @return
	 */
	@RequestMapping("/updateGoodsCheckStatus")
	public int updateGoodsCheck(HttpServletRequest request,ChnGoodsinfoCheck chnGoodsinfoCheck){
		PtUser user=(PtUser)request.getSession().getAttribute("user");
		chnGoodsinfoCheck.setReviewBy(user.getUsername());
		chnGoodsinfoCheck.setReviewTime(StringDateUtil.getStringTime());
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
	
	
	/**
	 * 商品审核数据导出
	 * @param chnGoodsOnline
	 * @return
	 * */
	@RequestMapping("/export")
	@SuppressWarnings("unchecked")
	 public ModelAndView export(@RequestParam("model") String model,ChnGoodsinfoCheck chnGoodsinfoCheck) {
		// 1：准备数据  
		JSONObject jsonList = chnGoodsFeignClient.selectByGoodsCheck(chnGoodsinfoCheck);
	    System.out.println("商品审核JsonList:"+jsonList);
	    //JsonObject格式 转List格式
	    JSONArray jsonArray = jsonList.getJSONArray("rows");
	    List<ChnGoodsinfoCheck> checkList = (List<ChnGoodsinfoCheck>) JSONArray.toCollection(jsonArray, ChnGoodsinfoCheck.class);
	     
	        for (ChnGoodsinfoCheck goods : checkList) {
	        	if ("1".equals(goods.getStatus())) {
					goods.setStatus("已上架");
				}else{
					goods.setStatus("已下架");
				}
	        	if("0".equals(goods.getType())){
	        		goods.setType("普通商品");
	        	}else{
	        		goods.setType("活动商品");
	        	}if("1".equals(goods.getReviewStatues())){
	        		goods.setReviewStatues("审核通过");
	        	}else if("0".equals(goods.getReviewStatues())){
	        		goods .setReviewStatues("待申请审核");
	        	}else if("2".equals(goods.getReviewStatues())){
	        		goods .setReviewStatues("审核拒绝");
	        	}else{
	        		goods .setReviewStatues("待审核");
	        	}
			}
	  
	        // 2：数据放置到jxls需要的map中  
	       Map<String,Object> modal = new HashMap<String,Object>();    
	        modal.put("goodsChecks", checkList);
	          
	        // 3：导出文件  
	       return new ModelAndView(new JxlsExcelView(model,"商品审核管理"), modal);  	
	}
	
}









