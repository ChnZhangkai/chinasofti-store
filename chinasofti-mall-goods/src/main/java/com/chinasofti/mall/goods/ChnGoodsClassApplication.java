package com.chinasofti.mall.goods;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chinasofti.mall.goods.mapper")
@ServletComponentScan
@EnableWebMvc
public class ChnGoodsClassApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ChnGoodsClassApplication.class, args);
	}
	
}
