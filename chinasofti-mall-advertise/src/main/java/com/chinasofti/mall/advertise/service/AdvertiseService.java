package com.chinasofti.mall.advertise.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.chinasofti.mall.advertise.mapper.CmsAdContentsMapper;
import com.chinasofti.mall.common.entity.CmsAdContentsExample;
import com.chinasofti.mall.common.entity.CmsAdContentsWithBLOBs;
import com.chinasofti.mall.common.service.IBaseService;
/**
* @ClassName: AdvertiseService
* @Description: TODO(这里用一句话描述这个类的作用)
* @author kanmeng
* @date 2017年11月1日 下午10:27:58 
* @version 1.0
 */
@Service
public class AdvertiseService implements IBaseService<CmsAdContentsWithBLOBs> {

	@Autowired
	CmsAdContentsMapper advertiseMapper;

	@Override
	public int save(CmsAdContentsWithBLOBs t) {
		return advertiseMapper.insertSelective(t);
	}

	@Override
	public List<CmsAdContentsWithBLOBs> findAll() {
		CmsAdContentsExample cmsAdContentsExample = new CmsAdContentsExample();
		cmsAdContentsExample.createCriteria().andStatesEqualTo("1");
		return advertiseMapper.selectByExampleWithBLOBs(cmsAdContentsExample);
	}

	@Override
	public CmsAdContentsWithBLOBs findById(String id) {
		CmsAdContentsExample cmsAdContentsExample = new CmsAdContentsExample();
		cmsAdContentsExample.createCriteria().andStatesEqualTo("1").andIdsEqualTo(id);
		List<CmsAdContentsWithBLOBs> list = advertiseMapper.selectByExampleWithBLOBs(cmsAdContentsExample);
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}
		return null;	
	}

	@Override
	public int deleteById(String id) {
		return advertiseMapper.fackDelete(id);
	}

	@Override
	public int update(CmsAdContentsWithBLOBs t) {
		return advertiseMapper.updateByPrimaryKeyWithBLOBs(t);
	}

}
