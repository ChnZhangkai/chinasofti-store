package com.chinasofti.mall.batch.reader;

import com.chinasofti.mall.batch.constants.Constants;
import com.chinasofti.mall.batch.mapper.PyBigGoodsOrderMapper;
import com.chinasofti.mall.batch.mapper.PyChildGoodsOrderMapper;
import com.chinasofti.mall.batch.mapper.PyMainGoodsOrderMapper;
import com.chinasofti.mall.batch.util.DateUtils;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CancelGoodsOrdersReader implements ItemReader<PyBigGoodsorder> {

    private Logger logger = LoggerFactory.getLogger(CancelGoodsOrdersReader.class);

    @Autowired
    private PyBigGoodsOrderMapper pyBigGoodsorderMapper;

    @Autowired
    private PyMainGoodsOrderMapper pyMainGoodsOrderMapper;

    @Autowired
    private PyChildGoodsOrderMapper pyChildGoodsOrderMapper ;

    private String handleDate;

    @Override
    public PyBigGoodsorder read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        logger.info("handleDate的值为: " + handleDate);

        logger.info("7天前的日期是: " + DateUtils.getSubSevenDays(handleDate));

        String beginTime = DateUtils.getSubSevenDays(handleDate) + Constants.TIME_PATTERN_1;
        String endTime = handleDate + Constants.TIME_PATTERN_1;
        /**
         * 检索相关的大订单
         */
        List<PyBigGoodsorder> bigOrderList = pyBigGoodsorderMapper.selectOrderNotPay(beginTime, endTime);
        /**
         * 大订单的流水号保存到bigOrderIds里面
         */
        List<String> bigOrderIds = new ArrayList<String>();
        if (bigOrderList != null && bigOrderList.size() > 0) {
            for (PyBigGoodsorder bigOrder :
                    bigOrderList) {
                bigOrderIds.add(bigOrder.getTransactionid());
            }
        }
        /**
         * 根据大订单的流水号查询主订单并且保存到 Constants.pyMainGoodsorderList
         */
        if (bigOrderIds != null && bigOrderIds.size() > 0) {
            List<PyMainGoodsorder> mainOrderList = pyMainGoodsOrderMapper.findListByMainId(bigOrderIds);
            if(mainOrderList!=null&&mainOrderList.size()>0){
                Constants.pyMainGoodsorderList.addAll(mainOrderList);
                List<PyChildGoodsorder> childOrderList = pyChildGoodsOrderMapper.findListByMainId(mainOrderList);
                if (childOrderList!=null&&childOrderList.size()>0){
                    Constants.pyChildGoodsorderList.addAll(childOrderList) ;
                }
            }

        }

        if (bigOrderList != null && bigOrderList.size() > 0) {
            return bigOrderList.remove(0);
        } else {
            return null;
        }
    }


    public void setHandleDate(String handleDate) {
        this.handleDate = handleDate;
    }

}
