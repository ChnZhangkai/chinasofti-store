package com.chinasofti.mall.goodsorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.order.PyChildGoodsorder;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorderExample;
import com.chinasofti.mall.common.entity.order.PyChildGoodsorderExample.Criteria;
import com.chinasofti.mall.goodsorder.mapper.PyChildGoodsorderMapper;
import com.chinasofti.mall.goodsorder.service.ChildGoodsorderService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;


/**
* @ClassName: 	ChildGoodsorderServiceImpl
* @Description: 子订单service实现类
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月3日 上午11:49:43 
*/
@Service
public class ChildGoodsorderServiceImpl implements ChildGoodsorderService {
	
	@Autowired
	private PyChildGoodsorderMapper childGoodsorderMapper;

	@Override
	public int save(PyChildGoodsorder childGoodsorder) {
		
		return childGoodsorderMapper.insertSelective(childGoodsorder);
	}

	@Override
	public List<PyChildGoodsorder> findAll() {
		return null;
	}

	@Override
	public PyChildGoodsorder findById(String id) {
		
		return childGoodsorderMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		
		return childGoodsorderMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(PyChildGoodsorder childGoodsorder) {
		
		return childGoodsorderMapper.updateByPrimaryKeySelective(childGoodsorder);
	}

	@Override
	public JSONObject selectByChildorderClass(PyChildGoodsorder childGoodsorder) {
		String compare = "";
		
		JSONObject js = new JSONObject();
		PyChildGoodsorderExample example = new PyChildGoodsorderExample();
		Criteria criteria = example.createCriteria();
				
		if ((childGoodsorder.getTransactionid()) != null && !(childGoodsorder.getTransactionid()).equals(compare)) {
				criteria.andTransactionidLike("%" + childGoodsorder.getTransactionid() + "%");
			}
		if ((childGoodsorder.getMainorderIds()) != null && !(childGoodsorder.getMainorderIds()).equals(compare)) {
			criteria.andMainorderIdsLike("%" + childGoodsorder.getMainorderIds() + "%");
		}
		if ((childGoodsorder.getOrderType()) != null && !(childGoodsorder.getOrderType()).equals(compare)) {
			criteria.andOrderTypeLike("%" + childGoodsorder.getOrderType() + "%");
		}
		
		PageHelper.startPage(childGoodsorder.getPage(),childGoodsorder.getRows());
		List<PyChildGoodsorder> list = childGoodsorderMapper.selectByExample(example);

		js.put("rows", list);
		js.put("total", ((Page<PyChildGoodsorder>)list).getTotal());
		
		return js;
	}

	@Override
	public List<PyChildGoodsorder> selectAllTest() {
		
		return childGoodsorderMapper.selectAll();
	}
	

}
