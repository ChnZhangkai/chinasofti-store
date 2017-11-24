package com.chinasofti.mall.common.entity.spuser;


public class SpSendAddress {
	/*
	 * 地址ID 
	 **/
	private String addressId;
	
	/*
	 * 用户ID
	 **/
	private String userId;
	
	/*
	 * 收件人姓名
	 * */
	private String name;
	/*
	 * 收件人手机号码
	 * */
	private String mobile;
	/*
	 * 邮编
	 * */
	private String zipCode;
	/*
	 * 省
	 * */
	private String province;
	/*
	 * 市
	 * */
	private String city;
	/*
	 * 行政区
	 * */
	private String district;
	/*
	 * 街道
	 * */
	private String street;
	/*
	 * 地址
	 * */
	private String address;
	
	private String createTime;
	
	public String getAddressId() {
		return addressId;
	}
	public void setAddressId(String addressId) {
		this.addressId = addressId;
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
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	
	
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	@Override
	public String toString() {
		return "SpSendAddress [addressId=" + addressId + ", userId=" + userId + ", name=" + name + ", mobile=" + mobile
				+ ", zipCode=" + zipCode + ", province=" + province + ", city=" + city + ", district=" + district
				+ ", street=" + street + ", address=" + address + ", createTime=" + createTime + "]";
	}
	
	
}
