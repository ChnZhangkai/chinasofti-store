package com.chinasofti.mall.batch.reader;

import com.chinasofti.mall.batch.constants.Constants;
import com.chinasofti.mall.batch.mapper.PyBigGoodsOrderMapper;
import com.chinasofti.mall.batch.util.DateUtils;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CancelGoodsOrdersReader implements ItemReader<PyBigGoodsorder> {

    private Logger logger = LoggerFactory.getLogger(CancelGoodsOrdersReader.class);

    @Autowired
    private PyBigGoodsOrderMapper pyBigGoodsorderMapper;

    private String handleDate;

    public PyBigGoodsorder read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        logger.info("handleDate的值为: " + handleDate);

        logger.info("7天前的日期是: " + DateUtils.getSubSevenDays(handleDate));

        String beginTime = DateUtils.getSubSevenDays(handleDate) + Constants.TIME_PATTERN_1;
        String endTime = handleDate + Constants.TIME_PATTERN_1;
        /**
         * 检索相关的大订单
         */
        List<PyBigGoodsorder> bigOrderList = pyBigGoodsorderMapper.selectOrderNotPay(beginTime, endTime);

        if (bigOrderList != null && bigOrderList.size() > 0) {
            return bigOrderList.remove(0);
        } else {
            return null;
        }
    }

    public void setHandleDate(String handleDate) {
        this.handleDate = DateUtils.transFormatToyyyyMMdd(handleDate);
    }

}
