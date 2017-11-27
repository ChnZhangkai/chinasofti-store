package com.chinasofti.mall.goodsorder.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.order.MainorderCondition;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.goodsorder.handler.MyException;
import com.chinasofti.mall.goodsorder.mapper.PyMainGoodsorderMapper;
import com.chinasofti.mall.goodsorder.service.MainGoodsorderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

/**
* @ClassName: 	MainGoodsorderServiceImpl
* @Description: 主订单Service实现类
*
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 上午11:20:19 
*
*/
@Service
public class MainGoodsorderServiceImpl implements MainGoodsorderService {
	
	@Autowired
	private PyMainGoodsorderMapper mainGoodsorderMapper;
	
	public int insertMainGoodsorderList(List<PyMainGoodsorder> mainList)throws MyException{
		return mainGoodsorderMapper.batchInsertPyMainGoodsorder(mainList);
	}

	@Override
	public int save(PyMainGoodsorder mainGoodsorder) {
		
		return mainGoodsorderMapper.insertSelective(mainGoodsorder);
	}

	@Override
	public List<PyMainGoodsorder> findAll() {
		return null;
	}

	@Override
	public PyMainGoodsorder findById(String id) {
		
		return mainGoodsorderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		
		return mainGoodsorderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(PyMainGoodsorder mainGoodsorder) {
		
		return mainGoodsorderMapper.updateByPrimaryKeySelective(mainGoodsorder);
	}
	
	@Override
	public JSONObject selectByExample(PyMainGoodsorder mainGoodsorder){
		
		JSONObject js = new JSONObject();
				
		if (!StringUtils.isEmpty(mainGoodsorder.getOrderTime())) {
			mainGoodsorder.setOrderTime(StringDateUtil.convertToSqlFormat(mainGoodsorder.getOrderTime()));
		}
		if (!StringUtils.isEmpty(mainGoodsorder.getSettleTime())) {
			mainGoodsorder.setSettleTime(StringDateUtil.convertToSqlFormat(mainGoodsorder.getSettleTime()));
		}
		PageHelper.startPage(mainGoodsorder.getPageNumber(),mainGoodsorder.getPageSize());
		List<PyMainGoodsorder> list = mainGoodsorderMapper.selectByExample(mainGoodsorder);

		js.put("rows", list);
		js.put("total", ((Page<PyMainGoodsorder>)list).getTotal());
		
		return js;
	}

	@Override
	public JSONObject selectByMainorderCondition(MainorderCondition mainorderCondition) {
		JSONObject js = new JSONObject();
		
		if(mainorderCondition.getMinPayTime() != null && !mainorderCondition.getMinPayTime().equals("")){
			mainorderCondition.setMinPayTime(StringDateUtil.convertToSqlFormat(mainorderCondition.getMinPayTime()));
		}
		if(mainorderCondition.getMaxPayTime() != null && !mainorderCondition.getMaxPayTime().equals("")){
			mainorderCondition.setMaxPayTime(StringDateUtil.convertToSqlFormat(mainorderCondition.getMaxPayTime()));
		}
		if(mainorderCondition.getSettleTimeFee() !=null && !mainorderCondition.getSettleTimeFee().equals("")){
			mainorderCondition.setSettleTimeFee(StringDateUtil.convertToSqlShortFormat(mainorderCondition.getSettleTimeFee()));
		}
		
		PageHelper.startPage(mainorderCondition.getPage(),mainorderCondition.getRows());
		List<PyMainGoodsorder> list = mainGoodsorderMapper.selectByMainorderCondition(mainorderCondition);

		js.put("rows", list);
		js.put("total", ((Page<PyMainGoodsorder>)list).getTotal());
		
		return js;
	}

	@Override
	public PyMainGoodsorder selectBybigorderId(String bigorderId) {
		PyMainGoodsorderExample example = new PyMainGoodsorderExample();
		example.createCriteria().andBigorderIdEqualTo(bigorderId);
		return mainGoodsorderMapper.selectByExample(example).get(0);
	}

	@Override
	public List<PyMainGoodsorder> selectByUserIds(String userIds) {
		PyMainGoodsorderExample example = new PyMainGoodsorderExample();
		example.createCriteria().andUserIdsEqualTo(userIds);
		return mainGoodsorderMapper.selectByExample(example);
	}

}
