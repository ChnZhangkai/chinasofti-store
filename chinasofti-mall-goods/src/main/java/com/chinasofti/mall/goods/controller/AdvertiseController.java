package com.chinasofti.mall.goods.controller;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.chinasofti.mall.common.controller.BaseController;
import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.AdvertisePosition;
import com.chinasofti.mall.common.utils.MsgEnum;
import com.chinasofti.mall.common.utils.ResponseInfo;
import com.chinasofti.mall.goods.service.IAdvertiseService;

import net.sf.json.JSONObject;

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
public class AdvertiseController implements BaseController<AdvertiseContents> {

	@Autowired
	IAdvertiseService advertiseService;
	
	
	private static final Logger logger = LoggerFactory.getLogger(AdvertiseController.class);

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
	@RequestMapping("deleteById")
	public String deleteById(@RequestParam("id") String id) {
		JSONObject jsonObject = new JSONObject();
		int row = advertiseService.deleteById(id);
		if(row <= 0) {
			jsonObject.put("errorMsg", "删除失败！");			
		}else {
			jsonObject.put("success", "删除成功！");
		}
		return jsonObject.toString();
	}

	@Override
	@RequestMapping("update")
	public String update(@RequestBody(required=false) AdvertiseContents advertiseContents) {
		logger.info(">>>>>>>>>>>>>>>>>>>advertiseContents:"+advertiseContents);
		JSONObject jsonObject = new JSONObject();
		int row = advertiseService.update(advertiseContents);
		if(row <= 0) {
			jsonObject.put("errorMsg", "更新失败");			
		}
		return jsonObject.toString();
	}

	@Override
	@RequestMapping("add")
	public String add(@RequestBody(required=false) AdvertiseContents advertiseContents) {
		logger.info(">>>>>>>>>>>>>>>>>>>advertiseContents:"+advertiseContents);
		JSONObject jsonObject = new JSONObject();
		int row = advertiseService.save(advertiseContents);
		if(row <= 0) {
			jsonObject.put("errorMsg", "添加失败");			
		}
		return jsonObject.toString();
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
	public String findByPage(@RequestParam Map<String, Object> map) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>map:"+map.toString());
		//return advertiseService.findByPage(map);
		return advertiseService.findByPage(map);
		
	}
	
	@RequestMapping("pubOrCanAdvertise")
	public String pubOrCanAdvertise(@RequestParam Map<String, Object> map) {
		logger.info(">>>>>>>>>>>>>>>>>>>>>>map:" + map.toString());
			JSONObject jsonObject = new JSONObject();
			int row = advertiseService.pubOrCanAdvertise(map);
			if (row <= 0) {
				jsonObject.put("errorMsg", "操作失败");
			}
			return jsonObject.toString();
	}
	/**
	* @Title: findAdPostionAll
	* @Description: 查询所有位置
	* @return: List<AdvertisePosition>
	* @throws:
	 */
	@RequestMapping("findAdPostionAll")
	public List<AdvertisePosition> findAdPostionAll() {
		return advertiseService.findAdPostionAll();
	}
	

	
	@RequestMapping("batchAdd")
	public void batchAdd() {
		AdvertiseContents t = new AdvertiseContents();
		for (int i = 1; i < 200; i++) {
			if (i % 2 == 0) {
				t.setTitle("测试广告");
				t.setStates("1");
			} else if (i % 2 == 1) {
				t.setTitle("首页广告");
				t.setStates("0");
			} else {
				t.setTitle("首页广告");
				t.setStates("0");
			}
			t.setImageurl("data/advertise/0c3dd0f09b824d419764943285659512.jpg");
			t.setIds(String.valueOf(i));
			t.setUrl("www.huateng.com");
			t.setDescs(BigDecimal.valueOf(i));
			t.setContens("单广告");
			t.setCategoryName("生鲜水果");
			t.setPositionName("首页轮播");
			t.setBeginTime("2017-08-23 00:00:00");
			t.setEndTime("2017-08-24 00:00:00");
			t.setCreateBy("jack");
			t.setType("1");
			t.setUpdateBy("tony");
			t.setUpdateTime("2017-08-29 00:00:00");
			t.setCreateTime("2017-07-26 00:00:00");
			advertiseService.save(t);
		}

	}
/**
 * 根据位置ID查找广告
 * @param advertiseContents
 * @return
 */
	@RequestMapping("findAdvertiseList/{positionId}")
	public ResponseInfo findAdvertiseList(@PathVariable String positionId) {
		return advertiseService.queryAdvertiseList(positionId);
	}

	
	@RequestMapping("findAdvertise/{positionId}")
	public ResponseInfo findAdvertise(@PathVariable String positionId) {
		return advertiseService.queryAdvertise(positionId);
	}

}
