package com.chinasofti.mall.user.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.common.entity.PtOperator;
import com.chinasofti.mall.user.mapper.PtOperatorMapper;
import com.chinasofti.mall.user.service.PtOperatorService;


@Service
public class PtOperatorServiceImpl implements PtOperatorService{
	@Autowired
	private PtOperatorMapper operatorMapper;

	@Override
	public String save(PtOperator ptOperator) {
		String str = getIds();
		ptOperator.setIds(str);
		ptOperator.setCreateby("admin");
		ptOperator.setOperator("admin-1");
		ptOperator.setCreatetime(getStringTime());
		operatorMapper.insertSelective(ptOperator);
		return str;
	}

	@Override
	public int update(PtOperator ptOperator) {
		ptOperator.setUpdateby("user");
		ptOperator.setUpdatetime(getStringTime());
		return operatorMapper.updateByPrimaryKeySelective(ptOperator);
	}

	@Override
	public int delete(String ids) {
		return operatorMapper.deleteByPrimaryKey(ids);
	}

	
	private String getIds() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}
	
	private String getStringTime() {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(new Date());
	}
}
