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
	public ResponseInfo findSendAddressList(String userId) {
		return new ResponseInfo();
	}

	@Override
	public ResponseInfo addSendAddress(SpSendAddress spSendAddress) {
		return new ResponseInfo();
	}
	
	@Override
	public ResponseInfo updataSendAddress(SpSendAddress spSendAddress) {
		return new ResponseInfo();
	}
	
	@Override
	public ResponseInfo deleteSendAddress(SpSendAddress spSendAddress) {
		return new ResponseInfo();
	}

	

	
}
