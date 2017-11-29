package com.chinasofti.mall.batch.reader;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import com.chinasofti.mall.batch.bean.PyBigGoodsorder;
import com.chinasofti.mall.batch.constants.Constants;
import com.chinasofti.mall.batch.mapper.PyBigGoodsorderMapper;
import com.chinasofti.mall.batch.util.DateUtils;
public class CancelGoodsOrdersReader implements ItemReader<PyBigGoodsorder>{
	
	private Logger logger = LoggerFactory.getLogger(CancelGoodsOrdersReader.class);
	
	@Autowired
	private PyBigGoodsorderMapper pyBigGoodsorderMapper ;

	private String handleDate ;

	@Override
	public PyBigGoodsorder read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
		logger.info("handleDate的值为: "+handleDate);
		
		logger.info("7天前的日期是: "+DateUtils.getSubSevenDays(handleDate));
		
		String beginTime = DateUtils.getSubSevenDays(handleDate) + Constants.TIME_PATTERN_1 ;
		String endTime = handleDate + Constants.TIME_PATTERN_1 ;
		
		List<PyBigGoodsorder> list = pyBigGoodsorderMapper.selectOrderNotPay(beginTime,endTime) ;
		if(list!=null && list.size()>0){
			return list.remove(0);
		}else{
			return null ;
		}
	}


	public void setHandleDate(String handleDate) {
		this.handleDate = handleDate;
	}
	
}
