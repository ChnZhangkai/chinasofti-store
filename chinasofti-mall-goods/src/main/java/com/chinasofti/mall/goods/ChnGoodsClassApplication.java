package com.chinasofti.mall.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chinasofti.mall.goods.mapper")
public class ChnGoodsClassApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChnGoodsClassApplication.class, args);
	}
	
}
