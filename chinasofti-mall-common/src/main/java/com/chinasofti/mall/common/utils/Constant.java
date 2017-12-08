package com.chinasofti.mall.common.utils;

public class Constant {
	
	public static final String IS_PARENT = "true";
	//支付状态 0  未支付 1 已支付 2 取消 
	public static final String PAY_STATUS = "0";
	//商品选中状态1选中 0未选择
	public static final Boolean CHECKED = false;
	//商品图片URL
	//public static final String HOST_URL ="http://192.168.1.238";
	//status : 订单状态: 0 待付款  1 待发货 2 待收货 3 交易成功  4 交易关闭（已删除） 5 交易关闭（已取消） 6 交易关闭（退款成功）
	/** 待付款 */
	public static final String STATUS_PENDING = "0";
	/** 付款 待发货*/
	public static final String STATUS_PENDING_DELIVERY = "1";
	/** 待收货 */
	public static final String STATUS_RECEIVED = "2";
	/** 交易完成 */
	public static final String STATUS_SUCCESS = "3";
	/** 交易关闭（已删除） */
	public static final String STATUS_CLOSED = "4";
	/** 交易关闭（已取消） */
	public static final String STATUS_CANCEL = "5";
	/** 交易关闭（退款成功） */
	public static final String STATUS_REFUND = "6";
	
	/** *  订单状态 1 有效*/
    public static final String STATUS_ABLE = "1";
    /** *  订单状态 0 无效*/
    public static final String STATUS_UNABLE = "0";
    
    //支付状态 0  未支付 1 已支付 2 取消 
    /** *  订单的支付状态 0 未支付 */
    public static final String PAY_STATUS_NOT = "0";
    /** *  订单的支付状态 1 已支付 */
    public static final String PAY_STATUS_OK = "1";
    /** *  订单的支付状态 2 已取消 */
    public static final String PAY_STATUS_CANCLE = "2";
    /** *  订单的支付状态 3 被删除 */
    public static final String PAY_STATUS_DELETE = "3";
    
    /** *  账号已被注册 */
    public static final String SPUSERID_EXIST_CODE = "400010";
    public static final String SPUSERID_EXIST_MSG = "该账号已被注册";
    
    /** *  账号或密码错误 */
    public static final String SPUSERID_PASSWORD_ERROR = "400020";
    public static final String SPUSERID_PASSWORD_MSG = "账号或密码错误";
    
    /** *  请输入正确的手机号码 */
    public static final String SPADDRESS_MOBILE_ERROR = "600010";
    public static final String SPADDRESS_MOBILE_MSG = "请输入正确的手机号码";
    
    /** *  请输入完整的省市区*/
    public static final String SPADDRESS_PROVINCECITY_ERROR = "600011";
    public static final String SPADDRESS_PROVINCECITY_MSG = "请输入完整的省市区";
    
    /** *  请输入正确的地址*/
    public static final String SPADDRESS_INFO_ERROR = "600012";
    public static final String SPADDRESS_INFO_MSG = "请输入正确的地址";
    
   
}
