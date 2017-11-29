package com.chinasofti.mall.batch.validate;

import java.util.Map;

import org.springframework.batch.core.JobParameter;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.job.DefaultJobParametersValidator;

import com.chinasofti.mall.batch.constants.Constants;
import com.chinasofti.mall.batch.util.DateUtils;

public class CancelGoodsOrdersJobParamsValidate extends DefaultJobParametersValidator {
	
	@Override
	public void validate(JobParameters parameters) throws JobParametersInvalidException {
		
		if (parameters == null) {
			throw new JobParametersInvalidException("The JobParameters can not be null");
		}
		
		Map<String, JobParameter> paramsMap = parameters.getParameters() ;

		/**
		 * 验证日期格式是否正确
		 */
		if(paramsMap.get(Constants.PARAM_1)!=null){
			String handleDate = (String) paramsMap.get(Constants.PARAM_1).getValue();
			Boolean validateResult = DateUtils.isValidDate(handleDate);
			if(!validateResult){
				throw new JobParametersInvalidException(handleDate+" 格式不对!");
			}
		}else{
			throw new JobParametersInvalidException("入参没有设置:"+Constants.PARAM_1);
		}
		
	}
}
