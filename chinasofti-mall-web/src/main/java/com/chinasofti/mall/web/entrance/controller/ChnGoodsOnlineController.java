package com.chinasofti.mall.web.entrance.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.GoodsFile;
import com.chinasofti.mall.common.utils.JxlsExcelView;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsFeignClient;
import com.chinasofti.mall.web.entrance.service.impl.GoodsFileServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/goodsOnline")
public class ChnGoodsOnlineController{
	
	@Autowired
	ChnGoodsFeignClient chnGoodsFeignClient;
	
	@Autowired
	GoodsFileServiceImpl goodsFileService;
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goodsonline");
	}
	
	
	/**
	 * 列表及条件查询
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByGoodsOnline(ChnGoodsOnline chnGoodsOnline){
		JSONObject jsonlist = chnGoodsFeignClient.selectByGoodsOnline(chnGoodsOnline);
		return jsonlist.toString();
	}
	
	/**
	 * 商品页面查询商品图片
	 * @return
	 */
	@RequestMapping("/reqGoodsImgPath/{ids}")
	public String reqGoodsImgPath(@PathVariable String ids){
		GoodsFile goodsFile = goodsFileService.selectByGoodsIds(ids);
		
		return goodsFile.getFilepath();
		
	}
	
	
	/**
	 * 商品状态修改
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping("/updateGoodsStatus")
	public int updateGoodsStatus(ChnGoodsOnline chnGoodsOnline){
		return chnGoodsFeignClient.updateGoodsStatus(chnGoodsOnline);
		
	}
	
	/**
	 * 商品库存修改
	 * @param chnGoodsOnline
	 * @return
	 */
	@RequestMapping("/update")
	public int updateStore(ChnGoodsOnline chnGoodsOnline){
		return chnGoodsFeignClient.updateStore(chnGoodsOnline);
		
	}
	
	/**
	 * 商品在线数据导出
	 * @param chnGoodsOnline
	 * @return
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping("/export")
	 public ModelAndView export(@RequestParam("model") String model, ChnGoodsOnline chnGoodsOnline)  {  
		// 1：准备数据  
		JSONObject jsonList = chnGoodsFeignClient.selectByGoodsOnline(chnGoodsOnline);
	    //JsonObject格式 转List格式
	    JSONArray jsonArray = jsonList.getJSONArray("rows");
	    List<ChnGoodsOnline> onlineList = (List<ChnGoodsOnline>) JSONArray.toCollection(jsonArray, ChnGoodsOnline.class);
	       for (ChnGoodsOnline goods : onlineList) {
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
	        	}
			}
	        // 2：数据放置到jxls需要的map中  
	        Map<String,Object> modal = new HashMap<String,Object>();    
	        modal.put("goodsOnlines", onlineList);
	          
	        // 3：导出文件  
	        return new ModelAndView(new JxlsExcelView(model,"商品在线管理"), modal);  	
	}

	
}
