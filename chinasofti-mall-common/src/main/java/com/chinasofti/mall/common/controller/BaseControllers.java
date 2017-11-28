/**
 * 
 */
package com.chinasofti.mall.common.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.utils.JxlsExcelView;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @ClassName: BaseControllers.java
 * @Description: TODO
 * @author zhoushanshan
 * @Date: 2017年11月24日 上午10:39:10
 * @parma <T>
 */
@RestController
public class BaseControllers<T>{

	/**
	* @Title: export
	* @Description: 导出数据
	* @return 
	* @throws
	*/
	
	 @SuppressWarnings("unchecked")
	 @RequestMapping("/export")
	public ModelAndView export(@RequestParam("model") String model,@RequestParam("jsonList") JSONObject jsonList, T t)  {  
		
		 System.out.println("父类方法！！！");
	    //JsonObject格式 转List格式
	    JSONArray jsonArray = jsonList.getJSONArray("rows");
	    List<T> onlineList = (List<T>) JSONArray.toCollection(jsonArray, getClass());
	    // 2：数据放置到jxls需要的map中  
        Map<String,Object> modal = new HashMap<String,Object>();    
        modal.put("tttt", onlineList);
	     
		// 3：导出文件  
	        return new ModelAndView(new JxlsExcelView(model,"模板名称"), modal);  	
	 }
}
