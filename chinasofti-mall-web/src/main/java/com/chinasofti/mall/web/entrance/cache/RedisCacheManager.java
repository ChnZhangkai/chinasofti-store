/**
* @Title: RedisCacheManager.java
* @Package com.chinasofti.mall.web.entrance.cache
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaokunxiong
* @date 2017年11月22日 下午12:36:14 
* @version V1.0
*/
package com.chinasofti.mall.web.entrance.cache;

import javax.annotation.Resource;

import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;
import org.apache.shiro.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.chinasofti.mall.web.entrance.shiro.ShiroCache;

/**
 * @ClassName: RedisCacheManager
 * @Description: 实现shiro的cachemanager
 * @author xiaokunxiong
 * @date 2017年11月22日 下午12:36:14 
 *
 */
@Service 
public class RedisCacheManager implements CacheManager {
	
	@Resource
    private RedisTemplate<String, Object> redisTemplate;
	
	@Override
	public <K, V> Cache<K, V> getCache(String name) throws CacheException {
		System.err.println("name:"+name);
		return new ShiroCache<K, V>(name, redisTemplate);
	}
	
	public RedisTemplate<String, Object> getRedisTemplate() {
	        return redisTemplate;
	    }

	public void setRedisTemplate(RedisTemplate<String, Object> redisTemplate) {
	        this.redisTemplate = redisTemplate;
	    }
}
