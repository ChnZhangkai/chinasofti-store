package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.web.entrance.feign.PrefectureFeignClient;

@RestController
@RequestMapping("/prefecture")
public class PrefectureController {

	@Value("${file.save.path}")
	private String filePath;
	
	@Value("${file.query.url}")
	private String fileUrl;
	@Autowired
	private PrefectureFeignClient prefectureFeignClient;
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/prefecture/prefecture");
	}
	/**
	 * 查询专区
	 */
	@RequestMapping("/findAll")
	public List<GoodsPrefecture> findAll(){
		List<GoodsPrefecture> list = prefectureFeignClient.findAll();
		return list;
	}
	/**
	 * 查询专区下面的商品
	 */
	@RequestMapping("/findGoods")
	public List<ChnGoodsOnline> findGoods(String ids){
		List<ChnGoodsOnline> goodsList = prefectureFeignClient.findGoods(ids);
		return goodsList;
	}
	/**
	 * 根据商品goodsids删除
	 */
	@RequestMapping("/deleteGoods/{goodsids}")
	public int deleteGoods(@PathVariable String goodsids){
		return prefectureFeignClient.deleteGoods(goodsids);
	}
	/**
	 * 添加商品至专区
	 */
	@RequestMapping(value="/addPrefectureGoods",method=RequestMethod.POST)
	public int addPrefectureGoods(@RequestParam Map map){
		GoodsPrefecture goodsPrefecture = new GoodsPrefecture();
		String ids = (String) map.get("ids");
		String goodsids = (String) map.get("goodsids");
		String states = (String) map.get("states");
		String name = (String) map.get("name");
		goodsPrefecture.setIds(ids);
		goodsPrefecture.setGoodsids(goodsids);
		goodsPrefecture.setStates(states);
		goodsPrefecture.setName(name);
		return prefectureFeignClient.savePrefecture(goodsPrefecture);
	}
	/**
	 * 修改
	 * @param goodsPrefecture
	 * @return
	 */
	@RequestMapping("/update")
	public int updatePrefectureById(GoodsPrefecture goodsPrefecture,MultipartHttpServletRequest multipartHttpServletRequest,HttpSession session){

		MultipartFile multipartFile = multipartHttpServletRequest.getFile("uimg");
		String imageName = multipartFile.getOriginalFilename();
		String fileName = filePath + File.separator + "prefecture" + File.separator + imageName;
		File fileSave = new File(fileName);
		
		if (!StringUtils.isEmpty(multipartFile.getOriginalFilename())) {
			
			//若选择了图片则保存新图片
			try {
				multipartFile.transferTo(fileSave);
			} catch (IllegalStateException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			//若选择了图片则删除旧图片
			String delImg = goodsPrefecture.getImg();
			String delImgname = delImg.substring(delImg.lastIndexOf("/")+1);
			String delImgUrl = filePath + File.separator + "prefecture" + File.separator + delImgname;
			File file = new File(delImgUrl);
			if (file.exists()) {
				file.delete();
			}
			//存储新图片路径
			goodsPrefecture.setImg(fileUrl +"/prefecture/" + imageName);
		}
		
		PtUser user = (PtUser) session.getAttribute("user");
		goodsPrefecture.setUpdateBy(user.getUsername());
		goodsPrefecture.setUpdateTime(StringDateUtil.convertDateToLongString(new Date()));
		int updatePrefecture = prefectureFeignClient.updatePrefecture(goodsPrefecture);
		return updatePrefecture;
	}
	/**
	 * 根据ID删除专区,并删除图片
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete/{ids}")
	public int deletePrefectureById(@PathVariable String ids){
//		GoodsPrefecture delImg = prefectureFeignClient.selectPrefectureById(ids);
		List<GoodsPrefecture> selectPrefectureById = prefectureFeignClient.selectPrefectureById(ids);
		for (GoodsPrefecture goodsPrefecture : selectPrefectureById) {
			String relWay = goodsPrefecture.getImg();
			if (relWay != null) {
				String imageName = relWay.substring(relWay.lastIndexOf("/")+1);
				String imgUrl = filePath + File.separator + "prefecture" + File.separator + imageName;
				File file = new File(imgUrl);
				if (file.exists()) {
					file.delete();
				}
			}
		}
		int delById = prefectureFeignClient.deletePrefectureById(ids);
		return delById;
	}
	/**
	 * 增加专区,并保存图片到项目文件中
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/save")
	public int savePrefecture(MultipartHttpServletRequest multipartHttpServletRequest,HttpSession session){
		
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("img"); 
		String imageName = multipartFile.getOriginalFilename();
		
		String fileName = filePath + File.separator + "prefecture" + File.separator + imageName;
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PtUser user = (PtUser) session.getAttribute("user");
		GoodsPrefecture prefecture = new GoodsPrefecture();
		prefecture.setIds(UUID.randomUUID().toString().replace("-", ""));
		prefecture.setName(multipartHttpServletRequest.getParameter("name"));
		prefecture.setCommons(multipartHttpServletRequest.getParameter("commons"));
		prefecture.setStates(multipartHttpServletRequest.getParameter("states"));
		prefecture.setImg(fileUrl + "/prefecture/" + imageName);
		prefecture.setCreateBy(user.getUsername());
		prefecture.setCreateTime(StringDateUtil.convertDateToLongString(new Date()));
		int i = prefectureFeignClient.savePrefecture(prefecture);
		return i;
	}
}
