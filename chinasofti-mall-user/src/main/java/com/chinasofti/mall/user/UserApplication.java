package com.chinasofti.mall.user;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan("com.chinasofti.mall.user.mapper")
@EnableDiscoveryClient
@EnableTransactionManagement //开启事务支持
public class UserApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(UserApplication.class, args);
	}

}
