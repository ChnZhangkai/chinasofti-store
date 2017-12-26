package com.chinasofti.mall.web.entrance.hystrix;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.web.entrance.feign.PrefectureFeignClient;

@Component
public class PrefectureFeignClientHystrix implements PrefectureFeignClient{

	@Override
	public int deletePrefectureById(String ids) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updatePrefecture(GoodsPrefecture goodsPrefecture) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int savePrefecture(GoodsPrefecture goodsPrefecture) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<GoodsPrefecture> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GoodsPrefecture> selectPrefectureById(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ChnGoodsOnline> findGoods(String ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addPrefectureGoods(Map map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteGoods(String goodsids) {
		// TODO Auto-generated method stub
		return 0;
	}

}
