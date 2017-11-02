package com.chinasofti.mall.advertise.controller;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.chinasofti.mall.advertise.service.IAdvertiseService;
import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.AdvertiseContents;

/**
 * 
* @ClassName: AdvertiseController
* @Description: 广告服务controller
* @author KanM
* @date 2017年11月1日 下午10:44:48 
* @version
 */
@RestController
@RequestMapping("advertise")
public class AdvertiseController implements BaseController<AdvertiseContents>{
	
	@Autowired
	IAdvertiseService advertiseService;

	@Override
	@RequestMapping("findAll")
	public List<AdvertiseContents> findAll() {
		return advertiseService.findAll();
	}
	
	@Override
	@RequestMapping("findById/{id}")
	public AdvertiseContents findById(@PathVariable String id) {
		return advertiseService.findById(id);
	}
	
	@Override
	@RequestMapping("deleteById/{id}")
	public String deleteById(@PathVariable String id) {
		advertiseService.deleteById(id);
		return "";
	}

	@Override
	@RequestMapping("update")
	public String update(AdvertiseContents t) {
		 advertiseService.update(t);
		return "";
	}

	@Override
	@RequestMapping("add")
	public String add(AdvertiseContents t) {
		advertiseService.save(t);
		return "";
	}
	/**
	 * 
	* @Title: findByPage
	* @Description: 分页查询
	* @param map
	* @return: String
	* @throws:
	 */
	@RequestMapping("findByPage")
	public String findByPage(@RequestParam Map<String,Object> map) {
		//Map<String,Object> map = new HashMap<>();
		//map.put("pageSize",pageSize );
		//map.put("pageNumber", pageNumber);
		return advertiseService.findByPage(map);
	}
	
	@RequestMapping("batchAdd")
	public void batchAdd() {
		AdvertiseContents t = new AdvertiseContents();
		for(int i=0; i<100; i++) {
			t.setIds(String.valueOf(i));
			t.setUrl("www.baidu.com"+i);
			t.setTitle("分类广告"+i);
			t.setStates("1");
			t.setDescs(BigDecimal.valueOf(i));
			t.setContens("单广告"+i);
			t.setCategoryName("生鲜水果"+i);
			t.setImageurl("www.test.com"+i);
			t.setPositionName("首页");
			t.setBeginTime("2017-08-23 00:"+i);
			t.setEndTime("2017-08-24 00:"+i);
			advertiseService.save(t);
		}
		
	}
}
