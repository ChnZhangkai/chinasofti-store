package com.chinasofti.mall.common.entity.goods;


public class ChnGoodsInfoVo extends ChnGoodsinfo{

	private String vendorSnm;
	
	private String servicePhone;
	
	private String venderIntro;

    private String venderExplain;
    
    
	private String filepath;

	public String getVendorSnm() {
		return vendorSnm;
	}

	public void setVendorSnm(String vendorSnm) {
		this.vendorSnm = vendorSnm;
	}


	public String getVenderIntro() {
		return venderIntro;
	}
 
	public void setVenderIntro(String venderIntro) {
		this.venderIntro = venderIntro;
	}

	public String getVenderExplain() {
		return venderExplain;
	}

	public void setVenderExplain(String venderExplain) {
		this.venderExplain = venderExplain;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getServicePhone() {
		return servicePhone;
	}

	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

}
