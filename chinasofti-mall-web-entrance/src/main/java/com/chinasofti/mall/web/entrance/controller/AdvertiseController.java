package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.web.entrance.feign.AdvertiseFeignClient;
import net.sf.json.JSONObject;


@RestController
@RequestMapping("advertise")
public class AdvertiseController {

	@Autowired
	AdvertiseFeignClient advertiseFeignClient;

	private static final Logger logger = LoggerFactory.getLogger(AdvertiseController.class);
	
	private static final String basePath = System.getProperty("user.dir")  + "/src/main/resources/static/images/advertise";
	@RequestMapping("/index")
	public ModelAndView index() {
		return new ModelAndView("/advertise/advertise");
	}

	@RequestMapping("findAll")
	public List<AdvertiseContents> findAll() {
		return advertiseFeignClient.findAll();
	}

	@RequestMapping("findByPage")
	public String findByPage(@RequestParam Map<String, Object> map) {
		return advertiseFeignClient.findByPage(map);
	}

	@RequestMapping("deleteById")
	public String deleteById(@RequestParam String id) {
		return advertiseFeignClient.deleteById(id);
	}

	@RequestMapping("add")
	public String add(AdvertiseContents advertiseContents, MultipartFile file) {
		JSONObject jsonObject = new JSONObject();
		if (file.isEmpty()) {
			return jsonObject.put("errorMsg", "图片为空！！！").toString();
		}
		// 获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);
		// 重命名文件名
		fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffixName;
		File dest = new File(basePath + File.separator+ fileName);
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			advertiseContents.setImageurl("/images/advertise/"+ fileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info(">>>>>>>>>>>>>>>>>>>advertiseContents:" + advertiseContents);
		return advertiseFeignClient.add(advertiseContents);
	}
	
	@RequestMapping("update")
	public String update(AdvertiseContents advertiseContents) {
		logger.info(">>>>>>>>>>>>>>>>>>>advertiseContents:" + advertiseContents);
		return advertiseFeignClient.update(advertiseContents);
	}

}
