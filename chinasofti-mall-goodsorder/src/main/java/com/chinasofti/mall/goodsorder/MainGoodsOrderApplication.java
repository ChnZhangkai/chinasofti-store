package com.chinasofti.mall.goodsorder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableDiscoveryClient
@MapperScan("com.chinasofti.mall.goodsorder.mapper")
public class MainGoodsOrderApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(MainGoodsOrderApplication.class, args);
	}

}
