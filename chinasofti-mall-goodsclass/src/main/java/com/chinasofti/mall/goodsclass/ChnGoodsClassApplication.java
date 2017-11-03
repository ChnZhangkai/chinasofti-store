package com.chinasofti.mall.goodsclass;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chinasofti.mall.goodsclass.mapper")
public class ChnGoodsClassApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChnGoodsClassApplication.class, args);
	}
	
}
