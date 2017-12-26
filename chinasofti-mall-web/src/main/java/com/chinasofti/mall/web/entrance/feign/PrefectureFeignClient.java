package com.chinasofti.mall.web.entrance.feign;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.chinasofti.mall.common.entity.GoodsPrefecture;
import com.chinasofti.mall.common.entity.goods.ChnGoodsClass;
import com.chinasofti.mall.common.entity.goods.ChnGoodsOnline;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfo;
import com.chinasofti.mall.common.entity.goods.ChnGoodsinfoCheck;
import com.chinasofti.mall.web.entrance.hystrix.PrefectureFeignClientHystrix;

/**
* @ClassName: PrefectureFeignClient
* @Description: 专区服务的feign消费类
* @version
*/
@FeignClient(name = "Goods-Service",fallback = PrefectureFeignClientHystrix.class)
public interface PrefectureFeignClient {

	/**
	 * 根据ID查找专区
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/prefecture/select/{ids}" , method = RequestMethod.POST)
	public List<GoodsPrefecture> selectPrefectureById(@PathVariable("ids") String ids);
	/**
	 * 根据ids查询专区商品
	 */
	@RequestMapping(value="/prefecture/findGoods",method = RequestMethod.POST)
	public List<ChnGoodsOnline> findGoods(String ids);
	/**
	 * 根据ID删除专区
	 * @param ids
	 * @return
	 */
	@RequestMapping(value = "/prefecture/delete/{ids}" , method =RequestMethod.POST)
	public int deletePrefectureById(@PathVariable("ids") String ids);
	/**
	 * 根据商品goodsids删除商品
	 */
	@RequestMapping(value="/prefecture/deleteGoods/{goodsids}",method = RequestMethod.POST)
	public int deleteGoods(@PathVariable("goodsids") String goodsids);
	/**
	 * 
	 * 添加商品至专区
	 */
	@RequestMapping(value="/prefecture/addPrefectureGoods",method = RequestMethod.POST)
	public int addPrefectureGoods(@RequestBody(required = false) Map map);
	/**
	 * 根据ID修改专区
	 * @param goodsPrefecture
	 * @return
	 */
	@RequestMapping(value = "/prefecture/update" , method = RequestMethod.POST)
	public int updatePrefecture(@RequestBody(required = false) GoodsPrefecture goodsPrefecture);
	
	/**
	 * 增加专区
	 * @param goodsPrefecture
	 * @return
	 */
	@RequestMapping(value = "/prefecture/save" , method = RequestMethod.POST)
	public int savePrefecture(@RequestBody(required = false) GoodsPrefecture goodsPrefecture);
	/**
	 * 查询专区
	 */
	@RequestMapping(value="/prefecture/findAll" , method = RequestMethod.POST)
	public List<GoodsPrefecture> findAll();
}
