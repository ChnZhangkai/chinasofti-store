package com.chinasofti.mall.web.entrance.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.order.ChildorderCondition;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.utils.JxlsExcelView;
import com.chinasofti.mall.web.entrance.feign.ChildGoodsorderFeign;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @ClassName: 	ChildGoodsorderController
* @Description: 主订单消费端controller
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 下午5:41:08 
*/
@RestController
@RequestMapping("childorder")
public class ChildGoodsorderController {
	
	@Autowired
	private ChildGoodsorderFeign childGoodsorderFeign;
	
	
	/**
	* @Title: selectByPrimaryKey
	* @Description: 通过主键查询
	* @param ids
	* @return PyChildGoodsorder
	* @throws
	*/
	@RequestMapping("select/{ids}")
	public PyChildGoodsorder selectByPrimaryKey(@PathVariable String ids){
		
		return childGoodsorderFeign.findById(ids);
		
	}
	
	/**
	* @Title: selectAll
	* @Description: 条件查询
	* @param ChildGoodsorder
	* @return List<PyChildGoodsorder>
	* @throws
	*/
	@RequestMapping(value="list", method = RequestMethod.POST)
	public String selectAll(PyChildGoodsorder childGoodsorder){
		JSONObject jsonlist = childGoodsorderFeign.selectByChildorderClass(childGoodsorder);
		return jsonlist.toString();
	}
	
	
	/**
	* @Title: orderAdd
	* @Description: 添加主订单
	* @param ChildGoodsorder
	* @return  String
	* @throws
	*/
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String orderAdd(PyChildGoodsorder childGoodsorder) {
		childGoodsorderFeign.add(childGoodsorder);
		return "add";
	}

	/**
	* @Title: orderDeleteById
	* @Description: 通过主键删除
	* @param ids
	* @return String
	* @throws
	*/
	@RequestMapping(value = "delete/{ids}")
	public String orderDeleteById(@PathVariable String ids) {

		return childGoodsorderFeign.deleteById(ids);

	}
	
	
	/**
	* @Title: orderUpdate
	* @Description: 更改
	* @param ChildGoodsorder
	* @return String
	* @throws
	*/
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String orderUpdate(PyChildGoodsorder childGoodsorder) {

		return childGoodsorderFeign.update(childGoodsorder);

	}
	
	@RequestMapping(value="selectall", method = RequestMethod.POST)
	public String selectByChildorderCondition(ChildorderCondition childorderCondition){
		JSONObject jsonlist = childGoodsorderFeign.selectByChildorderCondition(childorderCondition);
		return jsonlist.toString();
	}
	
	/**
	 * 商品子订单导出
	 * @param ChildorderCondition
	 * @return
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping("/export")
	 public ModelAndView export(@RequestParam("model") String model, PyChildGoodsorder childGoodsorder)  { 
		// 1：准备数据  
		JSONObject jsonlist = childGoodsorderFeign.selectByChildorderClass(childGoodsorder);
		System.out.println("子订单管理:"+jsonlist.toString());
	    //JsonObject格式 转List格式
	    JSONArray jsonArray = jsonlist.getJSONArray("rows");
	    List<PyChildGoodsorder> childOrderList = (List<PyChildGoodsorder>) JSONArray.toCollection(jsonArray, PyChildGoodsorder.class);
	     System.out.println("订单："+childOrderList);
	    
	        // 2：数据放置到jxls需要的map中  
	        Map<String,Object> modal = new HashMap<String,Object>();    
	        modal.put("childOrders", childOrderList);
	          
	        // 3：导出文件  
	        return new ModelAndView(new JxlsExcelView(model,"子订单管理"), modal);  	
	}

}
