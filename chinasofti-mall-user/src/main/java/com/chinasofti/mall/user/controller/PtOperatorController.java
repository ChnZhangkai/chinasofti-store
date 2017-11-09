package com.chinasofti.mall.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chinasofti.mall.common.entity.PtOperator;
import com.chinasofti.mall.user.service.PtOperatorService;

@RequestMapping("/ptoperator")
@RestController
public class PtOperatorController {
	@Autowired
	private PtOperatorService ptOperatorServiceImpl;
	
	@PostMapping("/save")
	public int save(PtOperator ptOperator) {
		return ptOperatorServiceImpl.save(ptOperator);
	}
}
