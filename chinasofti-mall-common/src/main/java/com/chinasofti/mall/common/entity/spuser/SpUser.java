package com.chinasofti.mall.common.entity.spuser;


public class SpUser {
	/*
	 *IDS 
	 **/
	private String ids;
	/*
	 *用户ID 不能为空；
	 * */
	private String userId;
	/*
	 * 用户名
	 * */
	private String name;
	/*
	 * 手机号码
	 * */
	private String mobile;
	/*
	 * 昵称
	 * */
	private String nickName;
	/*
	 * 性别
	 * */
	private String sex;
	/*
	 * 密码
	 * */
	private String password;
	/*
	 * 邮箱
	 * */
	private String email;
	/*
	 * 头像
	 * */
	private String headimgUrl;
	/*
	 * 省
	 * */
	private String province;
	/*
	 * 市
	 * */
	private String city;
	/*
	 * 国家
	 * */
	private String country;
	/*
	 * 行政区
	 * */
	private String district;
	/*
	 * 街道
	 * */
	private String street;
	/*
	 * 区域
	 * */
	private String area;
	/*
	 * 地址
	 * */
	private String address;
	/*
	 * 状态
	 * */
	private String  status;
	/*
	 * 登记日期
	 * */
	private String registeTime;
	/*
	 * 创建日期
	 * */
	private String createTime;
	/*
	 * 绑定手机号时间
	 * */
	private String bindPhoneTime;
	
	private boolean flag; 
	public String getIds() {
		return ids;
	}
	public void setIds(String ids) {
		this.ids = ids;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHeadimgUrl() {
		return headimgUrl;
	}
	public void setHeadimgUrl(String headimgUrl) {
		this.headimgUrl = headimgUrl;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getRegisteTime() {
		return registeTime;
	}
	public void setRegisteTime(String registeTime) {
		this.registeTime = registeTime;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public String getBindPhoneTime() {
		return bindPhoneTime;
	}
	public void setBindPhoneTime(String bindPhoneTime) {
		this.bindPhoneTime = bindPhoneTime;
	}
	
	
	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	@Override
	public String toString() {
		return "SpUser [userId=" + userId + ", name=" + name + ", nickName=" + nickName + ", sex=" + sex + "]";
	}
	
	
	
}
