package com.chinasofti.mall.user.mapper;

import java.util.List;

import com.chinasofti.mall.common.entity.spuser.SpSendAddress;


/**
 * @author: xiaozhiliang
 * @Date:   2017年11月08日:05时13分47秒
 *
 */
public interface SpSendAddressMapper {
	
	List<SpSendAddress> selectSentAddressList(String userId);
	
	int insert(SpSendAddress spAddress);
	
	int delete(SpSendAddress spAddress);
	
	int update(SpSendAddress spAddress);

}
