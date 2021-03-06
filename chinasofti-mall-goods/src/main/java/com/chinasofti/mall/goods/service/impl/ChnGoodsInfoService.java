package com.chinasofti.mall.goods.service.impl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.SpGoodsOptionSku;
import com.chinasofti.mall.common.entity.SpGoodsSku;
import com.chinasofti.mall.common.entity.goods.AttrVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsInfoVo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.SkuGoodsVo;
import com.chinasofti.mall.goods.mapper.ChnGoodsInfoMapper;
import com.chinasofti.mall.goods.mapper.SpGoodsOptionSkuMapper;
import com.chinasofti.mall.goods.mapper.SpGoodsSkuMapper;
import com.chinasofti.mall.goods.service.IChnGoodsInfoService;

@Service
public class ChnGoodsInfoService implements IChnGoodsInfoService{

	@Autowired
	private ChnGoodsInfoMapper goodsinfoMapper;
	@Autowired
	private SpGoodsSkuMapper spGoodsSkuMapper;

	public List<ChnGoodsinfo> selectByClassId(String goodsClassIds) {
		List<ChnGoodsinfo>result = goodsinfoMapper.selectByClassId(goodsClassIds);
		if(result==null){
			return result;
		}
		List<ChnGoodsinfo>responseLis =dealResultData(result);
		return responseLis;
		
	}
	
	public ChnGoodsInfoVo selectByGoodsId(String ids) {
		ChnGoodsInfoVo result= goodsinfoMapper.selectByPrimaryKey(ids);
		if(result==null){
			return result;
		}
		ChnGoodsInfoVo responseVo = dealResultData(result);
		
		return responseVo;
		
	}
    //处理多个图片路径用；号分隔的情况
	private ChnGoodsInfoVo dealResultData(ChnGoodsInfoVo result) {
		List<String> fileList = new ArrayList<String>();

		String[] newFilePath = result.getFilepath().split(";");
		for (String file : newFilePath) {
			fileList.add(file);
		}
		result.setFilepath(fileList.toString());
		return result;
	}

		/**
	     * 根据关键字查询商品列表
	     * @param record
	     * @return
	     */
		@Override
		public List<ChnGoodsinfo> selectByNameOrother(ChnGoodsinfo goodsInfo) {
			List<ChnGoodsinfo>result = goodsinfoMapper.selectByNameOrother(goodsInfo);
			if(result==null){
				return result;
			}
			List<ChnGoodsinfo>responseLis =dealResultData(result);
			return responseLis;
			
		}
		//处理多个图片路径用；号分隔的情况
		private List<ChnGoodsinfo> dealResultData(List<ChnGoodsinfo> result) {	
			List<ChnGoodsinfo>response=new ArrayList<ChnGoodsinfo>();
			for(ChnGoodsinfo chnGoodsinfo:result){
				List<String> fileList = new ArrayList<String>();
				
				String[] newFilePath = chnGoodsinfo.getFilepath().split(";");
				for (String file : newFilePath) {
					fileList.add(file);
				}
				chnGoodsinfo.setFilepath(fileList.get(0));
				response.add(chnGoodsinfo);
			}
			return response;
		}

	/**
	 * 根据商品Id查询商品信息
	 * 
	 * @param ids
	 * @return ChnGoodsinfo
	 */
	@Override
	public ChnGoodsinfo checkGoodsInfoById(String ids) {
		return goodsinfoMapper.selectByGoodsId(ids);
	}

	@Override
	public List<SkuGoodsVo> findSkuByGoodsIds(String ids) {
		List<SkuGoodsVo> skuList = spGoodsSkuMapper.findSkuByGoodsIds(ids);
		for(SkuGoodsVo sku:skuList) {
			String optionIds = sku.getSkuOptionIds();
			String[] idsList = optionIds.split(";");
			for(String ids2:idsList) {
				AttrVo attrVo = spGoodsSkuMapper.findSkuByOptionIds(ids2);
				sku.getAttrList().add(attrVo);
			}
		}
		return skuList;		
	}

	
	
}
