package com.chinasofti.app.hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.chinasofti.app.feign.SpSendAddressFeignClient;
import com.chinasofti.mall.common.entity.spuser.SpSendAddress;
import com.chinasofti.mall.common.utils.ResponseInfo;

/**
 * 
* @ClassName: SpUserFeignClientHystrix
* @Description: 熔断类
* @author xiaozhiliang
* @date 2017年11月9日 
* @version
 */
@Component
public class SpSendAddressFeignClientHystrix implements SpSendAddressFeignClient{

	@Override
	public List<SpSendAddress> findSendAddressList(String userId) {
		return new ArrayList<SpSendAddress>();
	}
 
	@Override
	public int addSendAddress(SpSendAddress spSendAddress) {
		return 0;
	}
	
	@Override
	public int updataSendAddress(SpSendAddress spSendAddress) {
		return 0;
	}
	
	@Override
	public int deleteSendAddress(SpSendAddress spSendAddress) {
		return 0;
	}

	

	
}
