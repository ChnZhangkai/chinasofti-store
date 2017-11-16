package com.chinasofti.app.feign;



import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.app.hystrix.SpSendAddressFeignClientHystrix;
import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.ResponseInfo;





/**
* @ClassName: SpUserFeignClient
* @Description: 前端用户的feign消费类
* @author xiaozhiliang
* @date 
* @version
*/
@FeignClient(name = "userService" , fallback = SpSendAddressFeignClientHystrix.class)
public interface SpSendAddressFeignClient {
	
	
	/**
	 * 
	* @Title: findSendAddressList
	* @Description: 查询收件地址列表
	* @param 
	* @return: String
	* @throws:
	 */
	@RequestMapping(value = "/address/list")
	
	public ResponseInfo findSendAddressList(@RequestParam("userId") String userId);
	
	/**
	* @Title: address
	* @Description: 增加收件地址信息
	* @param: 
	* @return: String
	* @throws
	*/
	@RequestMapping(value = "/address/add")
	public ResponseInfo addSendAddress(@RequestBody(required=false) SpSendAddress spSendAddress);
	
	/**
	* @Title: address
	* @Description: 修改收件地址信息
	* @param: 
	* @return: String
	* @throws
	*/
	@RequestMapping(value = "/address/updata")
	public ResponseInfo updataSendAddress(@RequestBody(required=false) SpSendAddress spSendAddress);
	
	/**
	* @Title: address
	* @Description: 删除收件地址信息
	* @param: 
	* @return: String
	* @throws
	*/
	@RequestMapping(value = "/address/delete")
	public ResponseInfo deleteSendAddress(@RequestBody(required=false) SpSendAddress spSendAddress);
	
	
}
