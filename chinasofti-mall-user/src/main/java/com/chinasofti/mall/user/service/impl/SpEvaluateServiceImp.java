package com.chinasofti.mall.user.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.chinasofti.mall.common.entity.spuser.SpGoodsEvaluate;
import com.chinasofti.mall.common.utils.UUIDUtils;
import com.chinasofti.mall.user.mapper.SpEvaluateMapper;
import com.chinasofti.mall.user.service.SpEvaluateService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import net.sf.json.JSONObject;

@Service
public class SpEvaluateServiceImp implements SpEvaluateService{
	
	Logger logger = LoggerFactory.getLogger(SpEvaluateServiceImp.class);
	@Autowired
	private SpEvaluateMapper spEvaluateMapper;
	
	@Value("${file.save.path}")
	private String filePath;
	
	@Value("${file.query.url}")
	private String fileUrl;
	
	// 未评论列表   查询已评论
	@Override
	public JSONObject selectEvaluateList(SpGoodsEvaluate spGoodsEvaluate)throws Exception{

		JSONObject js = new JSONObject();
		List<SpGoodsEvaluate> list = new ArrayList<SpGoodsEvaluate>();
		PageHelper.startPage(spGoodsEvaluate.getPage(),spGoodsEvaluate.getRows());
		String isEvaluate = spGoodsEvaluate.getIsEvaluate();//0:未评论 1：已评论
		logger.info("<<<<<<<<<<<<<>>>>>>>>>>"+spGoodsEvaluate.toString());
		logger.info("<<<<<<<<<<<<<isEvaluate>>>>>>>>>>"+isEvaluate);
		if("0".equals(isEvaluate)){
			list = spEvaluateMapper.selectNonEvaluateList(spGoodsEvaluate);
		}else if("1".equals(isEvaluate)){
			list = spEvaluateMapper.selectEvaluateList(spGoodsEvaluate);
		}
		js.put("rows", list);
		js.put("total", ((Page<SpGoodsEvaluate>)list).getTotal());
		return js;
		
	}
	
	//评论
	/*public int insertSelective(SpGoodsEvaluate spGoodsEvaluate,MultipartFile file)throws Exception{
		String imagepath = saveImage(file);
		if(imagepath !=null){//图片保存成功
			spGoodsEvaluate.setImagepath(imagepath);
			spGoodsEvaluate.setCreatetime(sdf.format(new Date()));
		}
		
		return 0;
	}*/
	
	@Override 
	@Transactional(readOnly=false,rollbackFor={RuntimeException.class, Exception.class})//启动事务
	public int insertSelective(SpGoodsEvaluate spGoodsEvaluate)throws Exception{
		spGoodsEvaluate.setCreatetime(UUIDUtils.nowTime());//评论时间
		spGoodsEvaluate.setIds(UUIDUtils.getUuid());
		int result = spEvaluateMapper.insertEvaluate(spGoodsEvaluate);//插人评论
		updateIsEvaluate(spGoodsEvaluate.getTransactionid());//修改评论状态
		return result;
	}
	
	//修改评论状态
	private int updateIsEvaluate(String transactionid)throws Exception {
		int result = spEvaluateMapper.updateIsEvaluate(transactionid);
		return result;	
	}
	
	
	@Override
	public JSONObject selectEvaluateAllList(SpGoodsEvaluate spGoodsEvaluate)throws Exception{

		JSONObject js = new JSONObject();
		PageHelper.startPage(spGoodsEvaluate.getPage(),spGoodsEvaluate.getRows());
		List<SpGoodsEvaluate> list = spEvaluateMapper.selectEvaluateAllList(spGoodsEvaluate);
		js.put("rows", list);
		js.put("total", ((Page<SpGoodsEvaluate>)list).getTotal());
		return js;
		
	}

	public String saveImage(MultipartFile file) {
		
		// 获取文件名
		String fileName = file.getOriginalFilename();
		logger.info("上传的文件名为：" + fileName);
		// 获取文件的后缀名
		String suffixName = fileName.substring(fileName.lastIndexOf("."));
		logger.info("上传的后缀名为：" + suffixName);
		// 重命名文件名
		fileName = UUID.randomUUID().toString().replaceAll("-", "") + suffixName;
		String imagepath=filePath + File.separator + "advertise" + File.separator+ fileName;
		File dest = new File(imagepath);
		logger.info("上传的path：" + dest.getPath());
		// 检测是否存在目录
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdirs();
		}
		try {
			file.transferTo(dest);
			return imagepath;
		} catch (IllegalStateException e) {
			e.printStackTrace();
			logger.info("IllegalStateException e="+e);
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			logger.info("IOException e="+e);
			return null;
		}
	}
}
