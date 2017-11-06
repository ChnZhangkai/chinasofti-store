package com.chinasofti.mall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@MapperScan("com.chinasofti.mall.user.mapper")
@EnableDiscoveryClient
public class UserApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserApplication.class, args);
	}

}
