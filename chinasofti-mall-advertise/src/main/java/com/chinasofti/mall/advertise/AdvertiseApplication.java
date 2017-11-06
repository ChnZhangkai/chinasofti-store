package com.chinasofti.mall.advertise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.chinasofti.mall.advertise.mapper")
public class AdvertiseApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdvertiseApplication.class, args);
	}
}
