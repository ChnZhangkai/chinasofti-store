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

import com.chinasofti.mall.common.entity.order.MainorderCondition;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.JxlsExcelView;
import com.chinasofti.mall.web.entrance.feign.MainGoodsorderFeign;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
* @ClassName: 	MainGoodsorderController
* @Description: 主订单消费端controller
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 下午5:41:08 
*/
@RestController
@RequestMapping("mainorder")
public class MainGoodsorderController {
	
	@Autowired
	private MainGoodsorderFeign mainGoodsorderFeign;
	
	
	/**
	* @Title: getView
	* @Description: 跳转订单页面
	* @return ModelAndView
	* @throws
	*/
	@RequestMapping("/index")
	public ModelAndView getView() {
		return  new ModelAndView("/order/goodsorder");
	}
	
	/**
	* @Title: selectByPrimaryKey
	* @Description: 通过主键查询
	* @param ids
	* @return PyMainGoodsorder
	* @throws
	*/
	@RequestMapping("select/{ids}")
	public PyMainGoodsorder selectByPrimaryKey(@PathVariable String ids){
		
		return mainGoodsorderFeign.findById(ids);
		
	}
	
	/**
	* @Title: selectAll
	* @Description: 条件查询
	* @param mainGoodsorder
	* @return List<PyMainGoodsorder>
	* @throws
	*/
	@RequestMapping(value="/list", method = RequestMethod.POST)
	public String selectAll(PyMainGoodsorder mainGoodsorder){
		JSONObject jsonlist = mainGoodsorderFeign.selectByMainorderClass(mainGoodsorder);
		return jsonlist.toString();
	}
	
	
	/**
	* @Title: orderAdd
	* @Description: 添加主订单
	* @param mainGoodsorder
	* @return  String
	* @throws
	*/
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String orderAdd(PyMainGoodsorder mainGoodsorder) {
		mainGoodsorderFeign.add(mainGoodsorder);
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

		return mainGoodsorderFeign.deleteById(ids);

	}
	
	
	/**
	* @Title: orderUpdate
	* @Description: 更改
	* @param mainGoodsorder
	* @return String
	* @throws
	*/
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String orderUpdate(PyMainGoodsorder mainGoodsorder) {

		return mainGoodsorderFeign.update(mainGoodsorder);

	}
	
	@RequestMapping(value="selectall", method = RequestMethod.POST)
	public String selectByMainorderCondition(MainorderCondition mainorderCondition){
		JSONObject jsonlist = mainGoodsorderFeign.selectByMainorderCondition(mainorderCondition);
		return jsonlist.toString();
	}
	
	
	/**
	 * 商品主订单导出
	 * @param PyMainGoodsorder
	 * @return
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping("/export")
	 public ModelAndView export(@RequestParam("model") String model, PyMainGoodsorder mainGoodsorder)  { 
		// 1：准备数据  
		JSONObject jsonlist = mainGoodsorderFeign.selectByMainorderClass(mainGoodsorder);
	    //JsonObject格式 转List格式
	    JSONArray jsonArray = jsonlist.getJSONArray("rows");
	    List<PyMainGoodsorder> mainOrderList = (List<PyMainGoodsorder>) JSONArray.toCollection(jsonArray, PyMainGoodsorder.class);
	     System.out.println("订单："+mainOrderList);
	    for (PyMainGoodsorder order : mainOrderList) {
	    	   //订单状态
	        	if ("0".equals(order.getStatus())) {
	        		order.setStatus("已删除");
				}else if ("1".equals(order.getStatus())) {
					order.setStatus("未发货");
				}else if ("2".equals(order.getStatus())) {
					order.setStatus("已发货");
				}else if ("3".equals(order.getStatus())) {
					order.setStatus("已收货");
				}
	        	//支付状态
	        	if("0".equals(order.getPayStatus())){
	        		order.setPayStatus("未支付");
	        	}else if("1".equals(order.getPayStatus())){
	        		order.setPayStatus("已支付");
	        	}else if("2".equals(order.getPayStatus())){
	        		order.setPayStatus("已取消");
	        	}
	        	//订单类型
	        	if("0".equals(order.getPayway())){
	        		order.setPayStatus("未支付");
	        	}else if("1".equals(order.getPayStatus())){
	        		order.setPayStatus("已支付");
	        	}
	        	//支付渠道
	        	if ("1".equals(order.getPayway())) {
					order.setPayway("微信");
				}else if("".equals(order.getPayway())){
					order.setPayway("支付宝");
				}
	        	//清算状态
	        	if ("0".equals(order.getSettleStatues())) {
	        		order.setSettleStatues("未清算");
				}else if("1".equals(order.getSettleStatues())){
					order.setSettleStatues("清算成功");
				}else if("2".equals(order.getSettleStatues())){
					order.setSettleStatues("清算失败");
				}else if("3".equals(order.getSettleStatues())){
					order.setSettleStatues("清算中...");
				}
			}
	        // 2：数据放置到jxls需要的map中  
	        Map<String,Object> modal = new HashMap<String,Object>();    
	        modal.put("mainOders", mainOrderList);
	          
	        // 3：导出文件  
	        return new ModelAndView(new JxlsExcelView(model,"主订单管理"), modal);  	
	}

}
