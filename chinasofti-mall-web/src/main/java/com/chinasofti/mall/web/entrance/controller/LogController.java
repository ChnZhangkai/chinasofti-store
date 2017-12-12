package com.chinasofti.mall.web.entrance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.LogOperator;
import com.chinasofti.mall.web.entrance.service.LogService;
import com.github.pagehelper.Page;

import net.sf.json.JSONObject;

/**
 * @ClassName: LogController.java
 * @Description: 系统日志(操作日志与异常日志)
 * @author 张凯
 * @Date: 2017年12月7日 上午10:55:16
 * @parma <T>
 */
@RestController
@RequestMapping("/log")
public class LogController {
	
	@Autowired
	private LogService logService;
	
	@RequestMapping("/operator")
	public ModelAndView toUser() {
		return new ModelAndView("/log/logOperator");
	}
	
	/**
	 * 查询操作日志
	 * @return
	 */
	@RequestMapping("/findAllOperator")
	public String findAllOperator(LogOperator logOperator){
		JSONObject js = new JSONObject();
		
		List<LogOperator> list = logService.selectByLogOperator(logOperator);
		js.put("rows", list);
		js.put("total", ((Page<LogOperator>)list).getTotal());
		
		return js.toString();
	}
	
}
