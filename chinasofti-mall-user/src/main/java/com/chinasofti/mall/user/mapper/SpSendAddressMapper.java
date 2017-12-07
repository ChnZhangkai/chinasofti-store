package com.chinasofti.mall.user.mapper;

import java.util.List;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.user.handler.MyException;


/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:05时13分47秒
 *
 */
public interface SpSendAddressMapper {
	
	public List<SpSendAddress> selectSentAddressList(String userId) throws MyException;
	
	public int insert(SpSendAddress spAddress) throws MyException;
	
	public int delete(SpSendAddress spAddress) throws MyException;
	
	public int update(SpSendAddress spAddress) throws MyException;

}
