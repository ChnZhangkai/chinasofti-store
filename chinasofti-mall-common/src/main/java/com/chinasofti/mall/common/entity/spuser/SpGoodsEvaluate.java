package com.chinasofti.mall.common.entity.spuser;


import com.chinasofti.mall.common.utils.PageBean;

public class SpGoodsEvaluate extends PageBean{
	
	private String ids;
	
	private String userid;//用户
	
	private String isEvaluate;//0:未评论 1：已评论
	
	private String transactionId;//订单号

	private String goodsids;//商品ID

	private String imagepath;//评论图片路径
	
    private String goodspath;//商品图片路径
    
    private String goodsfile;//商品标题
    
    private int count;//得分
	
	private String content;//评论文;
	
	private String nickname;//用户昵称
	
	private String createtime;
	
	private int useful;
	
	private String remark1;
	
	private String remark2;
	
	private String remark3;
	
	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	

	public String getCreatetime() {
		return createtime;
	}

	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}

	public int getUseful() {
		return useful;
	}

	public void setUseful(int useful) {
		this.useful = useful;
	}

	public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
    

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}

	public String getGoodsids() {
		return goodsids;
	}

	public void setGoodsids(String goodsids) {
		this.goodsids = goodsids;
	}


	public String getGoodspath() {
		return goodspath;
	}

	public void setGoodspath(String goodspath) {
		this.goodspath = goodspath;
	}

	public String getGoodsfile() {
		return goodsfile;
	}

	public void setGoodsfile(String goodsfile) {
		this.goodsfile = goodsfile;
	}

	public String getIsEvaluate() {
		return isEvaluate;
	}

	public void setIsEvaluate(String isEvaluate) {
		this.isEvaluate = isEvaluate;
	}
	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	@Override 
	public String toString() {
		return "SpGoodsEvaluate [ids=" + ids + ", userid=" + userid + ", isEvaluate=" + isEvaluate + ", transactionId="
				+ transactionId + ", goodsids=" + goodsids + ", imagepath=" + imagepath + ", goodspath=" + goodspath
				+ ", goodsfile=" + goodsfile + ", count=" + count + ", content=" + content + ", nickname=" + nickname
				+ ", createtime=" + createtime + "]";
	}
	

}
