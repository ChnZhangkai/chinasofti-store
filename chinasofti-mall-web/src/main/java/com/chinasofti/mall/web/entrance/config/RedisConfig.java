/**
* @Title: RedisConfig.java
* @Package com.chinasofti.mall.web.entrance.config
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaokunxiong
* @date 2017年11月22日 上午11:49:18 
* @version V1.0
*/
package com.chinasofti.mall.web.entrance.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.chinasofti.mall.web.entrance.cache.RedisObjectSerializer;

/**
 * @ClassName: RedisConfig
 * @Description: redisTemplate配置
 * @author xiaokunxiong
 * @date 2017年11月22日 上午11:49:18 
 *
 */

@Configuration
public class RedisConfig {
	
	   @Bean
	   public CacheManager cacheManager(@Qualifier("redisTemplate") RedisTemplate<Object, Object> redisTemplate) {
	        RedisCacheManager cacheManager = new RedisCacheManager(redisTemplate);
	        cacheManager.setDefaultExpiration(1800);
	        return cacheManager;
	    }
	    
	    @Bean(name="redisTemplate")
	    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory factory) {
	        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
	        template.setConnectionFactory(factory);
	        template.setKeySerializer(new StringRedisSerializer());
	        template.setValueSerializer(new RedisObjectSerializer());
	        return template;
	    }

}
