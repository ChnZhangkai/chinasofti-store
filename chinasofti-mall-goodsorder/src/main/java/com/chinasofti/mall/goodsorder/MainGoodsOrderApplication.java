package com.chinasofti.mall.goodsorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
* @ClassName: 	MainGoodsOrderApplication
* @Description: 主订单模块启动类
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 下午5:53:19 
*/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chinasofti.mall.goodsorder.mapper")
public class MainGoodsOrderApplication {
	 
	public static void main(String[] args) {
		
		SpringApplication.run(MainGoodsOrderApplication.class, args);
	}

}
