package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.AdvertiseContents;
import com.chinasofti.mall.common.entity.AdvertisePosition;
import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.web.entrance.feign.AdvertiseFeignClient;

import net.sf.json.JSONObject;


@RestController
@RequestMapping("advertise")
public class AdvertiseController {

	@Autowired
	AdvertiseFeignClient advertiseFeignClient;
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	private static final Logger logger = LoggerFactory.getLogger(AdvertiseController.class);
	
	@Value("${file.save.path}")
	private String filePath;
	
	@Value("${file.query.url}")
	private String fileUrl;
	
	//private static final String basePath = System.getProperty("user.dir")  + "/src/main/resources/static/data/advertise";
	
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
		String findByPage = advertiseFeignClient.findByPage(map);
		
		return findByPage;
	}

	@RequestMapping("deleteById")
	public String deleteById(@RequestParam String id) {
		return advertiseFeignClient.deleteById(id);
	}

	@RequestMapping("add")
	public String add(AdvertiseContents advertiseContents, MultipartFile file,HttpSession session) {
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
		File dest = new File(filePath + File.separator + "advertise" + File.separator+ fileName);
		logger.info("上传的path：" + dest.getPath());
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			advertiseContents.setImageurl(fileUrl + File.separator+"advertise"+File.separator + fileName);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//存入创建者信息
		PtUser user = (PtUser) session.getAttribute("user");
		advertiseContents.setCreateBy(user.getUsername());
		advertiseContents.setCreateTime(sdf.format(new Date()));
		logger.info(">>>>>>>>>>>>>>>>>>>advertiseContents:" + advertiseContents);
		return advertiseFeignClient.add(advertiseContents);
	}
	
	@RequestMapping("update")
	public String update(AdvertiseContents advertiseContents, MultipartFile file,HttpSession session) {
		//JSONObject jsonObject = new JSONObject();
		if (!file.isEmpty()) {
			//return jsonObject.put("errorMsg", "图片为空！！！").toString();
			// 获取文件名
			String fileName = file.getOriginalFilename();
			logger.info("上传的文件名为：" + fileName);
			// 获取文件的后缀名
			String suffixName = fileName.substring(fileName.lastIndexOf("."));
			logger.info("上传的后缀名为：" + suffixName);
			// 重命名文件名
			fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffixName;
			File dest = new File(filePath + File.separator+"advertise"+File.separator+ fileName);
			// 检测是否存在目录
			if (!dest.getParentFile().exists()) {
				dest.getParentFile().mkdirs();
			}
			try {
				file.transferTo(dest);
				advertiseContents.setImageurl(fileUrl + "/advertise/" + fileName);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
			
		PtUser user = (PtUser) session.getAttribute("user");
		advertiseContents.setUpdateBy(user.getUsername());
		advertiseContents.setUpdateTime(sdf.format(new Date()));
		logger.info(">>>>>>>>>>>>>>>>>>>advertiseContents:" + advertiseContents);
		return advertiseFeignClient.update(advertiseContents);
	}
	
	/**
	 * 
	* @Title: publicAdvertise
	* @Description: 发布广告和取消发布
	* @param map
	* @return: String
	* @throws:
	 */
	@RequestMapping(value="pubOrCanAdvertise",method=RequestMethod.POST)
	public String pubOrCanAdvertise(@RequestParam Map<String,Object> map){
		logger.info("publicAdvertise>>>>>>>>>>>>>>>>>>>map:" + map.toString());
		return advertiseFeignClient.pubOrCanAdvertise(map);
	}
	
	/**
	 * 
	* @Title: findAdPostionAll
	* @Description: 查出所有广告位置
	* @param map
	* @return: List<AdvertisePosition>
	* @throws:
	 */
	@RequestMapping(value="findAdPostionAll",method=RequestMethod.GET)
	public List<AdvertisePosition> findAdPostionAll(@RequestParam Map<String,Object> map) {
		return advertiseFeignClient.findAdPostionAll();
	}	

}
