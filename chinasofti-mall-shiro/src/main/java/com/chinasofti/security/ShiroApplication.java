/**
* @Title: ShiroApplication.java
* @Package com.chinasofti.security
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaokunxiong
* @date 2017年11月2日 下午5:10:34 
* @version V1.0
*/
package com.chinasofti.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName: ShiroApplication
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author xiaokunxiong
 * @date 2017年11月2日 下午5:10:34 
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.chinasofti.security.mapper")
public class ShiroApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShiroApplication.class, args);
	}

}
