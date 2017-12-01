/**
 * 
 */
package com.chinasofti.mall.web.entrance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.common.utils.JxlsExcelView;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserController.java
 * @Description: 商户消费端controller
 * @author zhoushanshan
 * @Date: 2017年11月2日 下午4:51:30
 * @parma <T>
 */
@RestController
@RequestMapping("/spUser")
public class SpMerchantUserController {
    @Autowired
	private SpMerchantUserFeignClient spUserFeignClient;
    
    /**
	 * 返回主界面
	 * @return
	 */
    @RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/spuser/spuser");
	}
	
	/**
	 * 查询列表
	 * @param spMerchantUser
	 * @return
	 */
	@RequestMapping("/list")
	public String selectBySpUser(SpMerchantUser spMerchantUser){
		JSONObject jsonlist = spUserFeignClient.selectBySpUser(spMerchantUser);
		return jsonlist.toString();
		
	}
	
	/**
	 * 根据商户ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/queryVendorInfo")
	public SpMerchantUser selectBySpUserById(@RequestParam("vendorId") String vendorId){
		SpMerchantUser spMerchantUser = spUserFeignClient.selectSpUserById(vendorId);
		return spMerchantUser;
	}
	
	/**
	 * 通过主键删除
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "delete/{ids}")
	public String spuserDeleteById(@PathVariable String ids) {
		return spUserFeignClient.deleteById(ids);
	}
	
	/**
	 * 添加商户
	 * @param spMerchantUser
	 * @return
	 */

	@RequestMapping(value = "add", method = RequestMethod.POST)
	public int spUserAdd(SpMerchantUser spMerchantUser,HttpServletRequest request) {
	   //这里获取当前登录的用户信息
	   PtUser user=(PtUser)request.getSession().getAttribute("user");
	   	spMerchantUser.setIds(UUID.randomUUID().toString().replace("-", ""));
		spMerchantUser.setUserIds(user.getIds());
		spMerchantUser.setCreateOper(user.getUsername());
		spMerchantUser.setModifyOper(user.getUsername());
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		spMerchantUser.setCreateDate(date.format(new Date()));
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		spMerchantUser.setCreateTime(time.format(new Date()));
		spMerchantUser.setUpdateby(user.getUsername());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		spMerchantUser.setUpdatetime(df.format(new Date()));
		return spUserFeignClient.spUserAdd(spMerchantUser); 
	}
	
	
	
	/**
	 * 修改商户
	 * @param spMerchantUser
	 * @return
	 */
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public int spUserUpdate(SpMerchantUser spMerchantUser,HttpServletRequest request) {
	  //获取当前操作的用户信息
	    PtUser user=(PtUser)request.getSession().getAttribute("user");
	    System.out.println("当前登陆用户:"+user.getUsername());
		spMerchantUser.setModifyOper(user.getUsername());
		spMerchantUser.setUpdateby(user.getUsername());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		spMerchantUser.setUpdatetime(df.format(new Date()));
		return spUserFeignClient.spUserUpdate(spMerchantUser); 
	}
	
	
	/**
	 * 商户导出
	 * @param chnGoodsOnline
	 * @return
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping("/export")
	 public ModelAndView export(@RequestParam("model") String model, SpMerchantUser spMerchantUser)  {  
		// 1：准备数据  
		JSONObject jsonList = spUserFeignClient.selectBySpUser(spMerchantUser);
	    //JsonObject格式 转List格式
	    JSONArray jsonArray = jsonList.getJSONArray("rows");
	    List<SpMerchantUser> list = (List<SpMerchantUser>) JSONArray.toCollection(jsonArray, SpMerchantUser.class);
	       for (SpMerchantUser spUser : list) {
	        	if ("1".equals(spUser.getStatus())) {
	        		spUser.setStatus("已启用");
				}else{
					spUser.setStatus("未开启");
				}	
			}
	        // 2：数据放置到jxls需要的map中  
	        Map<String,Object> modal = new HashMap<String,Object>();    
	        modal.put("vendors", list);
	          
	        // 3：导出文件  
	        return new ModelAndView(new JxlsExcelView(model,"商户管理"), modal);  	
	}

	
}
