/*package com.chinasofti.security.config;

import java.io.IOException;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.jagregory.shiro.freemarker.ShiroTags;

import freemarker.template.TemplateException;

*//**
 * @ClassName: CustomFreeMarkerConfigure
 * @Description: 编写自己的freemarker模板,集成shiroTags标签
 * @author xiaokunxiong
 * @date 2017年11月6日 下午3:46:41 
 *
 *//*
@Configuration
public class CustomFreeMarkerConfigure extends FreeMarkerConfigurer {
	@Override
	public void afterPropertiesSet() throws IOException, TemplateException {
		super.afterPropertiesSet();
		this.getConfiguration().setSharedVariable("shiro", new ShiroTags());
	}

}
*/