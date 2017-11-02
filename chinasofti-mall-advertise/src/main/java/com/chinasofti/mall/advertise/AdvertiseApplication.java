package com.chinasofti.mall.advertise;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.chinasofti.mall.advertise.mapper")
public class AdvertiseApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(AdvertiseApplication.class, args);
	}
}
