package com.chinasofti.mall.goodscategory;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chinasofti.mall.goodscategory.mapper")
public class GoodsCategoryApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(GoodsCategoryApplication.class, args);
	}
	
}
