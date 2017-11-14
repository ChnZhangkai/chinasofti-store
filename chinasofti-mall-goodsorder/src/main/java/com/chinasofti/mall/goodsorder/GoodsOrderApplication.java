package com.chinasofti.mall.goodsorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
* @ClassName: 	GoodsOrderApplication
* @Description: 订单模块启动类
* @author 		tanjl
* @Version 		V1.0
* @date 		2017年11月2日 下午5:53:19 
*/
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chinasofti.mall.goodsorder.mapper")
@EnableEurekaClient  
@EnableFeignClients //Feign支持
@EnableWebMvc
public class GoodsOrderApplication {
	 
	public static void main(String[] args) {
		
		SpringApplication.run(GoodsOrderApplication.class, args);
	}

}
