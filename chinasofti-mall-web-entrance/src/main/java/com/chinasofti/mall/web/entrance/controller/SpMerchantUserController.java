/**
 * 
 */
package com.chinasofti.mall.web.entrance.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.spuser.SpMerchantUser;
import com.chinasofti.mall.web.entrance.feign.SpMerchantUserFeignClient;

import net.sf.json.JSONObject;

/**
 * @ClassName: SpUserController.java
 * @Description: TODO
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
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/select/{ids}")
	public SpMerchantUser selectBySpUserById(@PathVariable String ids){
		SpMerchantUser spMerchantUser = spUserFeignClient.selectSpUserById(ids);
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
	public int spUserAdd(SpMerchantUser spMerchantUser) {
		spMerchantUser.setIds(UUID.randomUUID().toString().replace("-", ""));
		spMerchantUser.setUserIds("009890");
		spMerchantUser.setCreateOper("admins");
		spMerchantUser.setModifyOper("admins");
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
		spMerchantUser.setCreateDate(date.format(new Date()));
		SimpleDateFormat time = new SimpleDateFormat("HH:mm:ss");
		spMerchantUser.setCreateTime(time.format(new Date()));
		spMerchantUser.setUpdateby("admins");
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
	public int spUserUpdate(SpMerchantUser spMerchantUser) {
		spMerchantUser.setModifyOper("admins");
		spMerchantUser.setUpdateby("admins");
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		spMerchantUser.setUpdatetime(df.format(new Date()));
		return spUserFeignClient.spUserUpdate(spMerchantUser); 
	}
	
	
}
