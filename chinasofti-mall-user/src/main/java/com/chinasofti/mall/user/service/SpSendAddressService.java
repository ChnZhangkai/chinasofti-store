package com.chinasofti.mall.user.service;

import java.util.List;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.service.IBaseService;
import com.chinasofti.mall.user.handler.MyException;

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
	
	public List<SpSendAddress> querySentAddressList(String userId)throws MyException;
	
	public int insertSendAddress(SpSendAddress spSendAddress)throws MyException;
	
	public int updateSendAddress(SpSendAddress spSendAddress)throws MyException;
	
	public int deleteSendAddress(SpSendAddress spSendAddress)throws MyException;
	

}
