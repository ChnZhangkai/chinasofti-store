package com.chinasofti.mall.web.entrance.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.chinasofti.mall.common.entity.PtUser;
import com.chinasofti.mall.common.entity.Tree;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.utils.StringDateUtil;
import com.chinasofti.mall.web.entrance.feign.ChnGoodsFeignClient;

import net.sf.json.JSONObject;

/**
 * 商品分类服务消费
 * @author Administrator
 *
 */
@RestController
@RequestMapping("/goods")
public class ChnGoodsClassController {
	
	@Autowired
	private ChnGoodsFeignClient chnGoodsClassFeignClient;
	
	@Value("${file.save.path}")
	private String filePath;
	
	@Value("${file.query.url}")
	private String fileUrl;
	
	/**
	 * 返回主界面
	 * @return
	 */
	@RequestMapping("/index")
	public ModelAndView toIndex(){
		return new ModelAndView("/goods/goodsclass");
	}
	
	//新分类界面
	@RequestMapping("/goodsClass")
	public ModelAndView toGoodsClass(){
		return new ModelAndView("/goods/newGoodsClass");
	}
	
	/**
	 * 列表及条件查询
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/list")
	public String selectByGoodsClass(ChnGoodsClass chnGoodsClass){
		JSONObject jsonlist = chnGoodsClassFeignClient.selectByGoodsClass(chnGoodsClass);
		return jsonlist.toString();
	}
	
	/**
	 * 新商品分类查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/findGoodsClass")
	@ResponseBody
	public List<Tree> findGoodsClass(String id){
		if (id == null) {
			id = "0";
		}
		List<ChnGoodsClass> classList = chnGoodsClassFeignClient.findGoodsClass(id);
		Tree tree = new Tree();
		List<Tree> treeList = new ArrayList<>();
		for (ChnGoodsClass chnGoodsClass : classList) {
			List<ChnGoodsClass> childrenGoodsClass = chnGoodsClassFeignClient.findGoodsClass(chnGoodsClass.getIds());
			List<Tree> treeList2 = new ArrayList<>();
			for (ChnGoodsClass chnGoodsClass2 : childrenGoodsClass) {
				List<ChnGoodsClass> childrenGoodsClass3 = chnGoodsClassFeignClient.findGoodsClass(chnGoodsClass2.getIds());
				List<Tree> treeList3 = new ArrayList<>();
				for (ChnGoodsClass chnGoodsClass3 : childrenGoodsClass3) {
					Tree tree3 = new Tree();
					tree3.setId(chnGoodsClass3.getIds());
					tree3.setText(chnGoodsClass3.getName());
					tree3.setIconCls(chnGoodsClass3.getLogo());
					tree3.setStates(chnGoodsClass3.getStates());
					treeList3.add(tree3);
				}
				Tree tree2 = new Tree();
				tree2.setId(chnGoodsClass2.getIds());
				tree2.setText(chnGoodsClass2.getName());
				tree2.setIconCls(chnGoodsClass2.getLogo());
				tree2.setChildren(treeList3);
				tree2.setStates(chnGoodsClass2.getStates());
				treeList2.add(tree2);
			}
			tree.setId(chnGoodsClass.getIds());
			tree.setText(chnGoodsClass.getName());
			tree.setIconCls(chnGoodsClass.getLogo());
			tree.setChildren(treeList2);
			tree.setStates(chnGoodsClass.getStates());
			treeList.add(tree);
		}
		
		return treeList;
	}
	
	/**
	 * 查询子节点
	 * @return
	 */
	@RequestMapping("/findGoodsClassChildren")
	@ResponseBody
	public String findGoodsClassChildren(){
		
		return "";
	}
	
	/**
	 * 根据ID查询
	 * @param ids
	 * @return
	 */
	@RequestMapping("/select/{ids}")
	public ChnGoodsClass selectByGoodsClassById(@PathVariable String ids){
		ChnGoodsClass chnGoodsClass = chnGoodsClassFeignClient.selectGoodsClassById(ids);
		return chnGoodsClass;
	}
	
	/**
	 * 修改
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/update")
	public int updateGoodsClassById(ChnGoodsClass chnGoodsClass,MultipartHttpServletRequest multipartHttpServletRequest,HttpSession session){

		MultipartFile multipartFile = multipartHttpServletRequest.getFile("uimg");
		String imageName = multipartFile.getOriginalFilename();
		String fileName = filePath + File.separator + "goodsclass" + File.separator + imageName;
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
			String delImg = chnGoodsClass.getImg();
			String delImgname = delImg.substring(delImg.lastIndexOf("/")+1);
			String delImgUrl = filePath + File.separator + "goodsclass" + File.separator + delImgname;
			File file = new File(delImgUrl);
			if (file.exists()) {
				file.delete();
			}
			//存储新图片路径
			chnGoodsClass.setImg(fileUrl +"/goodsclass/" + imageName);
		}
		
		PtUser user = (PtUser) session.getAttribute("user");
		chnGoodsClass.setUpdateBy(user.getUsername());
		chnGoodsClass.setUpdateTime(StringDateUtil.convertDateToLongString(new Date()));
		int updateGoodsClass = chnGoodsClassFeignClient.updateGoodsClass(chnGoodsClass);
		return updateGoodsClass;
	}
	
	/**
	 * 修改名称
	 * @return
	 */
	@RequestMapping("/updateGoodsClassName")
	public int updateGoodsClassName(ChnGoodsClass chnGoodsClass,HttpSession session){
		PtUser user = (PtUser) session.getAttribute("user");
		chnGoodsClass.setUpdateBy(user.getUsername());
		chnGoodsClass.setUpdateTime(StringDateUtil.convertDateToLongString(new Date()));
		int updateGoodsClass = chnGoodsClassFeignClient.updateGoodsClass(chnGoodsClass);
		return updateGoodsClass;
	}
	
	/**
	 * 根据ID删除分类,并删除图片
	 * @param ids
	 * @return
	 */
	@RequestMapping("/delete/{ids}")
	public int deleteGoodsClassById(@PathVariable String ids){
		ChnGoodsClass delImg = chnGoodsClassFeignClient.selectGoodsClassById(ids);
		String relWay = delImg.getImg();
		if (relWay != null) {
			String imageName = relWay.substring(relWay.lastIndexOf("/")+1);
			String imgUrl = filePath + File.separator + "goodsclass" + File.separator + imageName;
			File file = new File(imgUrl);
			if (file.exists()) {
				file.delete();
			}
		}
		int delById = chnGoodsClassFeignClient.deleteGoodsClassById(ids);
		return delById;
	}
	
	/**
	 * 增加分类,并保存图片到项目文件中
	 * @param spGoodsClass
	 * @return
	 */
	@RequestMapping("/save")
	public int saveGoodsClass(MultipartHttpServletRequest multipartHttpServletRequest,HttpSession session){
		
		MultipartFile multipartFile = multipartHttpServletRequest.getFile("img"); 
		String imageName = multipartFile.getOriginalFilename();
		
		String fileName = filePath + File.separator + "goodsclass" + File.separator + imageName;
		File file = new File(fileName);
		try {
			multipartFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PtUser user = (PtUser) session.getAttribute("user");
		ChnGoodsClass chnGoodsClass = new ChnGoodsClass();
		chnGoodsClass.setIds(UUID.randomUUID().toString().replace("-", ""));
		chnGoodsClass.setPids(multipartHttpServletRequest.getParameter("pid"));
		chnGoodsClass.setName(multipartHttpServletRequest.getParameter("name"));
		chnGoodsClass.setCommons(multipartHttpServletRequest.getParameter("commons"));
		chnGoodsClass.setStates(multipartHttpServletRequest.getParameter("states"));
		chnGoodsClass.setImg(fileUrl + "/goodsclass/" + imageName);
		chnGoodsClass.setCreateBy(user.getUsername());
		chnGoodsClass.setCreateTime(StringDateUtil.convertDateToLongString(new Date()));
		int chngoodsClass = chnGoodsClassFeignClient.saveGoodsClass(chnGoodsClass);
		return chngoodsClass;
	}
}
