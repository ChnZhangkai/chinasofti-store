package com.chinasofti.mall.sp.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication//入口
@EnableDiscoveryClient//向服务中心注册
@MapperScan("com.chinasofti.mall.sp.user.mapper")
public class SpUserApplication {
	
	public static void main(String[] args) {
		
		SpringApplication.run(SpUserApplication.class, args);
	}

}