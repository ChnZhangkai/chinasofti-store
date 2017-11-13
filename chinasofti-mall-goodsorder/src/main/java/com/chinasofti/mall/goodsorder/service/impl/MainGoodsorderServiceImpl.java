package com.chinasofti.mall.goodsorder.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.order.MainorderCondition;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorder;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorderExample;
import com.chinasofti.mall.common.entity.order.PyMainGoodsorderExample.Criteria;
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
		
		String compare = "";
		
		JSONObject js = new JSONObject();
		PyMainGoodsorderExample example = new PyMainGoodsorderExample();
		Criteria criteria = example.createCriteria();
				
		if ((mainGoodsorder.getTransactionid()) != null && !(mainGoodsorder.getTransactionid()).equals(compare)) {
				criteria.andTransactionidLike("%" + mainGoodsorder.getTransactionid() + "%");
			}
		
		if ((mainGoodsorder.getBigorderId()) != null && !(mainGoodsorder.getBigorderId()).equals(compare)) {
			criteria.andBigorderIdLike("%" + mainGoodsorder.getBigorderId() + "%");
		}
		
		if ((mainGoodsorder.getPayStatus()) != null && !(mainGoodsorder.getPayStatus()).equals(compare)) {
			criteria.andPayStatusLike("%" + mainGoodsorder.getPayStatus() + "%");
		}
		
		if ((mainGoodsorder.getContName()) != null && !(mainGoodsorder.getContName()).equals(compare)) {
			criteria.andContNameLike("%" + mainGoodsorder.getContName() + "%");
		}
		
		if ((mainGoodsorder.getPayway()) != null && !(mainGoodsorder.getPayway()).equals(compare)) {
			criteria.andPaywayLike("%" + mainGoodsorder.getPayway() + "%");
		}

		PageHelper.startPage(mainGoodsorder.getPage(),mainGoodsorder.getRows());
		List<PyMainGoodsorder> list = mainGoodsorderMapper.selectByExample(example);

		js.put("rows", list);
		js.put("total", ((Page<PyMainGoodsorder>)list).getTotal());
		
		return js;
	}

	@Override
	public JSONObject selectByMainorderCondition(MainorderCondition mainorderCondition) {
		JSONObject js = new JSONObject();
		PageHelper.startPage(mainorderCondition.getPage(),mainorderCondition.getRows());
		List<PyMainGoodsorder> list = mainGoodsorderMapper.selectByMainorderCondition(mainorderCondition);

		js.put("rows", list);
		js.put("total", ((Page<PyMainGoodsorder>)list).getTotal());
		
		return js;
	}

}
