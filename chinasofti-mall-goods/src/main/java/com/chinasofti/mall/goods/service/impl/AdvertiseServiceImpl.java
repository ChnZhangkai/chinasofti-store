package com.chinasofti.mall.goods.service.impl;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.AdvertiseContentsExample;
import com.chinasofti.mall.goods.mapper.AdvertiseContentsMapper;
import com.chinasofti.mall.goods.service.IAdvertiseService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import net.sf.json.JSONObject;

/**
 * @ClassName: AdvertiseService
 * @Description: IAdvertiseService实现类
 * @author KanM
 * @date 2017年11月1日 下午10:27:58
 * @version 1.0
 */
@Service
public class AdvertiseServiceImpl implements IAdvertiseService {

	@Autowired
	AdvertiseContentsMapper advertiseMapper;

	@Override
	public int save(AdvertiseContents advertiseContents) {
		advertiseContents.setIds(UUID.randomUUID().toString().replaceAll("-", ""));
		//advertiseContents.setBeginTime((DateUtil.DadeFormat(advertiseContents.getBeginTime()))); 
		//advertiseContents.setEndTime((DateUtil.DadeFormat(advertiseContents.getEndTime())));
		return advertiseMapper.insertSelective(advertiseContents);
	}

	@Override
	public List<AdvertiseContents> findAll() {
		AdvertiseContentsExample cmsAdContentsExample = new AdvertiseContentsExample();
		// cmsAdContentsExample.createCriteria().andStatesEqualTo("1");
		return advertiseMapper.selectByExample(cmsAdContentsExample);
	}

	@Override
	public AdvertiseContents findById(String id) {
		// AdvertiseContentsExample cmsAdContentsExample = new
		// AdvertiseContentsExample();
		// cmsAdContentsExample.createCriteria().andStatesEqualTo("1").andIdsEqualTo(id);
		// List<AdvertiseContents> list =
		// advertiseMapper.selectByExample(cmsAdContentsExample);
		// if (list != null && !list.isEmpty()) {
		// return list.get(0);
		// }
		return advertiseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		return advertiseMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int update(AdvertiseContents t) {
		return advertiseMapper.updateByPrimaryKeySelective(t);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String findByPage(Map<String, Object> paramMap) {
		JSONObject js = new JSONObject();
		AdvertiseContentsExample advertiseContentsExample = new AdvertiseContentsExample();
		// 条件判断
		if (paramMap.containsKey("title")) {
			if (null != paramMap.get("title") && !"".equals(paramMap.get("title"))) {
				advertiseContentsExample.createCriteria().andTitleLike("%" + paramMap.get("title").toString() + "%");
			}
		}
		;
		if (paramMap.containsKey("type")) {
			if (null != paramMap.get("type") && !"".equals(paramMap.get("type"))) {
				advertiseContentsExample.createCriteria().andTypeEqualTo(paramMap.get("type").toString());
			}

		}
		;
		if (paramMap.containsKey("positionId")) {
			if (null != paramMap.get("positionId") && !"".equals(paramMap.get("positionId"))) {
				advertiseContentsExample.createCriteria().andPositionIdEqualTo(paramMap.get("positionId").toString());
			}
		}
		;
		// 排序
		if (paramMap.containsKey("sort") && (paramMap.containsKey("order"))) {
			if (null != paramMap.get("sort") && !"".equals(paramMap.get("sort")) && null != paramMap.get("order")
					&& !"".equals(paramMap.get("order"))) {
				advertiseContentsExample.setOrderByClause(paramMap.get("sort") + " " + paramMap.get("order"));
			}
		}
		// 执行分页查询
		PageHelper.startPage(Integer.parseInt(paramMap.get("page").toString()),
				Integer.parseInt(paramMap.get("rows").toString()));
		List<AdvertiseContents> list = advertiseMapper.selectByExample(advertiseContentsExample);
		js.put("rows", list);
		js.put("total", ((Page) list).getTotal());
		return js.toString();
	}

	@Override
	public int pubOrCanAdvertise(Map<String, Object> map) {
		return advertiseMapper.pubOrCanAdvertise(map);

	}

	@Override
	/**
	 * 根据位置Id查找广告列表和单条广告
	 * @throws Exception 
	 */
	public List<AdvertiseContents> queryAdvertiseList(String positionId){

		return advertiseMapper.selectAdvertiseList(positionId);
	} 

	

	@Override
	public AdvertiseContents queryAdvertise(String positionId){

		return advertiseMapper.selectSingleAdvertise(positionId);
	} 

}
