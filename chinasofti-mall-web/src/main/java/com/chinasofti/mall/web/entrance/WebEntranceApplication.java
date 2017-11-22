package com.chinasofti.mall.web.entrance;

import javax.annotation.PostConstruct;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import com.jagregory.shiro.freemarker.ShiroTags;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

import cn.org.rapid_framework.freemarker.directive.BlockDirective;
import cn.org.rapid_framework.freemarker.directive.ExtendsDirective;
import cn.org.rapid_framework.freemarker.directive.OverrideDirective;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
@MapperScan("com.chinasofti.mall.web.entrance.mapper")
public class WebEntranceApplication {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }
  
 /* @Bean("jasyptStringEncryptor")
  public StringEncryptor stringEncryptor() {
      PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
      SimpleStringPBEConfig config = new SimpleStringPBEConfig();
      config.setPassword("password");
      config.setAlgorithm("PBEWithMD5AndDES");
      config.setKeyObtentionIterations("1000");
      config.setPoolSize("1");
      config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
      config.setStringOutputType("base64");
      encryptor.setConfig(config);
      return encryptor;
  }*/
  public static void main(String[] args) {
    SpringApplication.run(WebEntranceApplication.class, args);
  }
  
  /*
   * freemark模板页面继承
   */
  @Configuration
	public class FreemarkerConfig {
	    @Autowired
	    freemarker.template.Configuration configuration;
	    
	    @PostConstruct
	    public void setSharedVariable(){
	        configuration.setSharedVariable("block", new BlockDirective());
	        configuration.setSharedVariable("override", new OverrideDirective());
	        configuration.setSharedVariable("extends", new ExtendsDirective());
	        configuration.setSharedVariable("shiro", new ShiroTags());
	    }
	}
}
