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
	public int save(PtOperator ptOperator) {
		ptOperator.setIds(UUID.randomUUID().toString().replaceAll("-", ""));
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		ptOperator.setCreatetime(time);
		ptOperator.setUpdatetime(time);
		return operatorMapper.insertSelective(ptOperator);
	}

}
