package com.chinasofti.mall.advertise.service.impl;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.advertise.mapper.AdvertiseContentsMapper;
import com.chinasofti.mall.advertise.service.IAdvertiseService;
import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.AdvertiseContentsExample;
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
	public int save(AdvertiseContents t) {
		return advertiseMapper.insertSelective(t);
	}

	@Override
	public List<AdvertiseContents> findAll() {
		AdvertiseContentsExample cmsAdContentsExample = new AdvertiseContentsExample();
		//cmsAdContentsExample.createCriteria().andStatesEqualTo("1");
		return advertiseMapper.selectByExample(cmsAdContentsExample);
	}

	@Override
	public AdvertiseContents findById(String id) {
		//AdvertiseContentsExample cmsAdContentsExample = new AdvertiseContentsExample();
		//cmsAdContentsExample.createCriteria().andStatesEqualTo("1").andIdsEqualTo(id);
		//List<AdvertiseContents> list = advertiseMapper.selectByExample(cmsAdContentsExample);
		//if (list != null && !list.isEmpty()) {
			//return list.get(0);
		//}
		return advertiseMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteById(String id) {
		//return advertiseMapper.fackDelete(id);
		return 0;
	}

	@Override
	public int update(AdvertiseContents t) {
		return advertiseMapper.updateByExample(t, new AdvertiseContentsExample());
	}

	@SuppressWarnings("rawtypes")
	@Override
	public String findByPage(Map<String, Object> paramMap) {
		JSONObject js = new JSONObject();
		AdvertiseContentsExample advertiseContentsExample = new AdvertiseContentsExample();
		//cmsAdContentsExample.createCriteria().andStatesEqualTo("1");
		advertiseContentsExample.setOrderByClause("ids ASC");
		PageHelper.startPage(Integer.parseInt(paramMap.get("pageNumber").toString()),
							Integer.parseInt(paramMap.get("pageSize").toString()));
		List<AdvertiseContents> list = advertiseMapper.selectByExample(advertiseContentsExample);
		js.put("rows", list);
		js.put("total", ((Page) list).getTotal());
		return js.toString();

	}

}
