package com.chinasofti.mall.web.entrance.hystrix;

import com.chinasofti.mall.common.entity.PtOperator;
import com.chinasofti.mall.web.entrance.feign.PtOperatorFeignClient;
/** 
 *  
 * @ClassName: PtOperatorFeignClientHystrix.java
 * @Description: TODO
 * @author 黄佳喜
 * @Date: 2017年11月14日 上午11:23:08
 * @parma <T>
 */
public class PtOperatorFeignClientHystrix implements PtOperatorFeignClient{

	@Override
	public String add(PtOperator ptOperator) {
		return "--";
	}

	@Override
	public int update(PtOperator ptOperator) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(PtOperator ptOperator) {
		// TODO Auto-generated method stub
		return 0;
	}

	
}
