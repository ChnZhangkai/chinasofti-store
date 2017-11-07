package com.chinasofti.mall.web.entrance.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * SpringBoot配置相对路径
 * @author Administrator
 *
 */
@Configuration
public class MyWebAppConfigurer extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/myresources/**").addResourceLocations("classpath:/myresources/");
		super.addResourceHandlers(registry);
	}
}
