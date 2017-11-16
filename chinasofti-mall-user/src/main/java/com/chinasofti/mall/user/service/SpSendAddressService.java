package com.chinasofti.mall.user.service;

import java.util.List;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.service.IBaseService;

/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:04时52分20秒
 *
 */
public interface SpSendAddressService extends IBaseService<SpSendAddress>{
	
	/**
	 * @param spSendAddress
	 * @return
	 */
	
	public List<SpSendAddress> querySentAddressList(String userId);
	
	public int insertSendAddress(SpSendAddress spSendAddress);
	
	public int updateSendAddress(SpSendAddress spSendAddress);
	
	public int deleteSendAddress(SpSendAddress spSendAddress);
	

}
