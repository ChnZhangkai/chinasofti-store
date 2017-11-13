/**
 * 
 */
package com.chinasofti.mall.common.entity.goods;

import java.math.BigDecimal;

import com.chinasofti.mall.common.utils.PageBean;
 
public class ChnGoodsOnline extends PageBean{
	//商品分类
	private String classId;//分类Id
	private String name;//分类名称
	private String img;//商品图片
	//商品信息
	private String goodsids;//商品编号
	private String title;//商品名称
	private String goodsCommons;//商品描述
	private BigDecimal price;//商品价格
    private BigDecimal disPrice;//优惠比例
    private String standard;//商品规格
    private String content;//展示内容
    private BigDecimal storeNum;//库存
    private String reviewDesc;//审核原因
    private String reviewStatues;//审核状态
    private String status;//商品状态
    private String startTime;//开始时间
    private String endTime;//结束时间
    private String onlineTime;//上架时间
    private String leaveTime;//下架时间
    private BigDecimal orgPrice;//商品原价
    private String type;//商品类型
    //商户信息
	private String vendorId;//商户Id
	private String vendorFnm;//商户全称
	private String vendorSnm;//商户简称
	private String chargeman;//商户负责人
	private String mobile;//联系电话
	private String address;//通讯地址
	private String belongSiteName;//拓展网点名称
	private String servicePhone;//售后电话
	private String venderIntro;//商户介绍
    private String venderExplain;//售后说明

	/**
	 * @return the classId
	 */
	public String getClassId() {
		return classId;
	}
	/**
	 * @param classId the classId to set
	 */
	public void setClassId(String classId) {
		this.classId = classId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the img
	 */
	public String getImg() {
		return img;
	}
	/**
	 * @param img the img to set
	 */
	public void setImg(String img) {
		this.img = img;
	}
	

	/**
	 * @return the goodsids
	 */
	public String getGoodsids() {
		return goodsids;
	}
	/**
	 * @param goodsids the goodsids to set
	 */
	public void setGoodsids(String goodsids) {
		this.goodsids = goodsids;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the goodsCommons
	 */
	public String getGoodsCommons() {
		return goodsCommons;
	}
	/**
	 * @param goodsCommons the goodsCommons to set
	 */
	public void setGoodsCommons(String goodsCommons) {
		this.goodsCommons = goodsCommons;
	}
	/**
	 * @return the price
	 */
	public BigDecimal getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	/**
	 * @return the disPrice
	 */
	public BigDecimal getDisPrice() {
		return disPrice;
	}
	/**
	 * @param disPrice the disPrice to set
	 */
	public void setDisPrice(BigDecimal disPrice) {
		this.disPrice = disPrice;
	}
	/**
	 * @return the standard
	 */
	public String getStandard() {
		return standard;
	}
	/**
	 * @param standard the standard to set
	 */
	public void setStandard(String standard) {
		this.standard = standard;
	}
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}
	/**
	 * @return the storeNum
	 */
	public BigDecimal getStoreNum() {
		return storeNum;
	}
	/**
	 * @param storeNum the storeNum to set
	 */
	public void setStoreNum(BigDecimal storeNum) {
		this.storeNum = storeNum;
	}
	/**
	 * @return the reviewDesc
	 */
	public String getReviewDesc() {
		return reviewDesc;
	}
	/**
	 * @param reviewDesc the reviewDesc to set
	 */
	public void setReviewDesc(String reviewDesc) {
		this.reviewDesc = reviewDesc;
	}
	/**
	 * @return the reviewStatues
	 */
	public String getReviewStatues() {
		return reviewStatues;
	}
	/**
	 * @param reviewStatues the reviewStatues to set
	 */
	public void setReviewStatues(String reviewStatues) {
		this.reviewStatues = reviewStatues;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return startTime;
	}
	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	/**
	 * @return the endTime
	 */
	public String getEndTime() {
		return endTime;
	}
	/**
	 * @param endTime the endTime to set
	 */
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	/**
	 * @return the onlineTime
	 */
	public String getOnlineTime() {
		return onlineTime;
	}
	/**
	 * @param onlineTime the onlineTime to set
	 */
	public void setOnlineTime(String onlineTime) {
		this.onlineTime = onlineTime;
	}
	/**
	 * @return the leaveTime
	 */
	public String getLeaveTime() {
		return leaveTime;
	}
	/**
	 * @param leaveTime the leaveTime to set
	 */
	public void setLeaveTime(String leaveTime) {
		this.leaveTime = leaveTime;
	}
	/**
	 * @return the orgPrice
	 */
	public BigDecimal getOrgPrice() {
		return orgPrice;
	}
	/**
	 * @param orgPrice the orgPrice to set
	 */
	public void setOrgPrice(BigDecimal orgPrice) {
		this.orgPrice = orgPrice;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the vendorId
	 */
	public String getVendorId() {
		return vendorId;
	}
	/**
	 * @param vendorId the vendorId to set
	 */
	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}
	/**
	 * @return the vendorFnm
	 */
	public String getVendorFnm() {
		return vendorFnm;
	}
	/**
	 * @param vendorFnm the vendorFnm to set
	 */
	public void setVendorFnm(String vendorFnm) {
		this.vendorFnm = vendorFnm;
	}
	/**
	 * @return the vendorSnm
	 */
	public String getVendorSnm() {
		return vendorSnm;
	}
	/**
	 * @param vendorSnm the vendorSnm to set
	 */
	public void setVendorSnm(String vendorSnm) {
		this.vendorSnm = vendorSnm;
	}
	/**
	 * @return the chargeman
	 */
	public String getChargeman() {
		return chargeman;
	}
	/**
	 * @param chargeman the chargeman to set
	 */
	public void setChargeman(String chargeman) {
		this.chargeman = chargeman;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the belongSiteName
	 */
	public String getBelongSiteName() {
		return belongSiteName;
	}
	/**
	 * @param belongSiteName the belongSiteName to set
	 */
	public void setBelongSiteName(String belongSiteName) {
		this.belongSiteName = belongSiteName;
	}
	/**
	 * @return the servicePhone
	 */
	public String getServicePhone() {
		return servicePhone;
	}
	/**
	 * @param servicePhone the servicePhone to set
	 */
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}
	/**
	 * @return the venderIntro
	 */
	public String getVenderIntro() {
		return venderIntro;
	}
	/**
	 * @param venderIntro the venderIntro to set
	 */
	public void setVenderIntro(String venderIntro) {
		this.venderIntro = venderIntro;
	}
	/**
	 * @return the venderExplain
	 */
	public String getVenderExplain() {
		return venderExplain;
	}
	/**
	 * @param venderExplain the venderExplain to set
	 */
	public void setVenderExplain(String venderExplain) {
		this.venderExplain = venderExplain;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ChnGoodsOnline [ classId=" + classId + ", name=" + name + ", "
				+ "img=" + img + ", goodsId=" + goodsids + ", title=" + title + ", goodsCommons=" + goodsCommons
				+ ", price=" + price + ", disPrice=" + disPrice + ", standard=" + standard + ", content=" + content
				+ ", storeNum=" + storeNum + ", reviewDesc=" + reviewDesc + ", reviewStatues=" + reviewStatues
				+ ", status=" + status + ", startTime=" + startTime + ", endTime=" + endTime + ", onlineTime="
				+ onlineTime + ", leaveTime=" + leaveTime + ", orgPrice=" + orgPrice + ", type=" + type + ", "
						+ " vendorId=" + vendorId + ", vendorFnm=" + vendorFnm + ", vendorSnm=" + vendorSnm
				+ ", chargeman=" + chargeman + ", mobile=" + mobile + ", address=" + address + ", belongSiteName="
				+ belongSiteName + ", servicePhone=" + servicePhone + ", venderIntro=" + venderIntro
				+ ", venderExplain=" + venderExplain + "]";
	}
    
    
	
}
