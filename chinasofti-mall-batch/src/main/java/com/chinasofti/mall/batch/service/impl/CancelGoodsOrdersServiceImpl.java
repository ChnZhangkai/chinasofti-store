package com.chinasofti.mall.batch.service.impl;

import com.chinasofti.mall.batch.mapper.ChnGoodsInfoMapper;
import com.chinasofti.mall.batch.mapper.PyBigGoodsOrderMapper;
import com.chinasofti.mall.batch.mapper.PyChildGoodsOrderMapper;
import com.chinasofti.mall.batch.mapper.PyMainGoodsOrderMapper;
import com.chinasofti.mall.batch.service.CancelGoodsOrdersService;
import com.chinasofti.mall.batch.util.DateUtils;
import com.chinasofti.mall.common.entity.order.PyBigGoodsorder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CancelGoodsOrdersServiceImpl implements CancelGoodsOrdersService {

    private Logger logger = LoggerFactory.getLogger(CancelGoodsOrdersServiceImpl.class);

    @Autowired
    private PyBigGoodsOrderMapper pyBigGoodsorderMapper;

    @Autowired
    private PyMainGoodsOrderMapper pyMainGoodsOrderMapper;

    @Autowired
    private PyChildGoodsOrderMapper pyChildGoodsOrderMapper;

    @Autowired
    private ChnGoodsInfoMapper chnGoodsInfoMapper;

    public void updatePaywayStatus(PyBigGoodsorder pyBigGodsOrder) throws Exception {
        try {
            String updateTime = DateUtils.getCurrentTime();

            /**
             * 更新大订单 PAY_STATUS
             */
            this.pyBigGoodsorderMapper.updatePaywayStatus(pyBigGodsOrder);

//            /**
//             * 更新py_main_gooodsorder
//             * 	PAY_STATUS
//             *  UPDATETIME
//             */
//            List<PyMainGoodsorder> mainGoodsOrderList = this.pyMainGoodsOrderMapper.findListByMainId(pyBigGodsOrder);
//
//            if (mainGoodsOrderList != null && mainGoodsOrderList.size() > 0) {
//                for (PyMainGoodsorder pyMainGoodsorder :
//                        mainGoodsOrderList) {
//                    pyMainGoodsorder.setPayStatus(Constants.PAY_STATUS_2);
//                    pyMainGoodsorder.setUpdatetime(updateTime);
//                    /**
//                     * 更新主订单表
//                     */
//                    this.pyMainGoodsOrderMapper.updateMainGoodsOrder(pyMainGoodsorder);
//                }
//                /**
//                 * 检索子订单
//                 */
//                List<PyChildGoodsorder> childGoodsOrderList = this.pyChildGoodsOrderMapper.findListByMainId(mainGoodsOrderList);
//
//                if (childGoodsOrderList != null && childGoodsOrderList.size() > 0) {
//
//                    for (PyChildGoodsorder pyChildGoodsorder :
//                            childGoodsOrderList) {
//                        /**
//                         * 检索商品信息
//                         */
//                        ChnGoodsinfo chnGoodsinfo = this.chnGoodsInfoMapper.findGoodsInfoByChildOrder(pyChildGoodsorder);
//                        /**
//                         * 更新chn_goodsinfo
//                         * 	STORE_NUM
//                         *  UPDATE_BY
//                         *  UPDATE_TIME
//                         *  TOTAL_TRADE
//                         */
//                        if (chnGoodsinfo != null) {
//                            //原库存
////                            int orignStoreNum = chnGoodsinfo.getStoreNum() ;
//                            //原总销量
//                            BigDecimal orignTotalTrade = chnGoodsinfo.getTotalTrade() ;
//
//                            //当前子订单的商品数量
////                            int goodsNum = pyChildGoodsorder.getGoodsNum() ;
//
//                            //新库存
////                            int newStoreNum = orignStoreNum + goodsNum ;
//                            //新总销量
//                            BigDecimal newTotalTrade = orignTotalTrade.subtract(new BigDecimal(goodsNum)) ;
//                            /**
//                             * newTotalTrade < 0
//                             * 设为 0
//                             */
//
//                            if(newTotalTrade.compareTo(new BigDecimal(0)) != 1){
//                                newTotalTrade = new BigDecimal(0) ;
//                            }
//
////                             chnGoodsinfo.setStoreNum(newStoreNum);
//                            chnGoodsinfo.setTotalTrade(newTotalTrade);
//                            chnGoodsinfo.setUpdateBy("CancelGoodsOrdersJob");
//                            chnGoodsinfo.setUpdateTime(updateTime);
//
////                            this.chnGoodsInfoMapper.updateChnGoodsInfo(chnGoodsinfo);
//                        }
//                    }
//                }
//
//            }

        } catch (Exception e) {
            logger.error(e.getMessage());
            throw new Exception("CancelGoodsOrdersService.updatePaywayStatus()更新支付状态失败!");
        }
    }
}
