/**
* @Title: ShiroCache.java
* @Package com.chinasofti.mall.web.entrance.shiro
* @Description: TODO(用一句话描述该文件做什么)
* @author xiaokunxiong
* @date 2017年11月22日 上午11:59:03 
* @version V1.0
*/
package com.chinasofti.mall.web.entrance.shiro;

import org.apache.shiro.cache.Cache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.shiro.cache.CacheException;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @ClassName: ShiroCache
 * @Description: 实现缓存共享
 * @author xiaokunxiong
 * @date 2017年11月22日 上午11:59:03 
 *
 */

@SuppressWarnings("unchecked")
public  class ShiroCache<K,V> implements Cache<K,V> {
	
	private static final String REDIS_SHIRO_CACHE = "shiro-cache:";
    private String cacheKey;
    private RedisTemplate<K, V> redisTemplate;
    private long globExpire = 30;

    @SuppressWarnings("rawtypes")
    public ShiroCache(String name, RedisTemplate client) {
        this.cacheKey = REDIS_SHIRO_CACHE + name + ":";
        this.redisTemplate = client;
    }
    
    /** 
     * 通过key（pricipals）来获取对应的缓存对象（AuthorizationInfo）授权对象 
     *shiro需要的key的类型为Object，V的类型为AuthorizationInfo对象 
     */ 

    @Override
    public V get(K key) throws CacheException {
    	System.err.println("=======================获取缓存对象，从缓存中读取权限信息");
    	redisTemplate.boundValueOps(getCacheKey(key)).expire(globExpire, TimeUnit.MINUTES);
        return redisTemplate.boundValueOps(getCacheKey(key)).get();
    }
    
    /** 
     * 将权限info对象信息加入缓存中 
     */ 

    @Override
    public V put(K key, V value) throws CacheException {
    	System.err.println("=======================把权限对象加入到缓存");
    	//先根据key（pricipals）获取缓存中的权限信息
    	V old = get(key);
    	//再添加权限信息info到缓存
        redisTemplate.boundValueOps(getCacheKey(key)).set(value);
        return old;
    }
    /** 
     * 将权限信息从缓存中删除 
     */
    @Override
    public V remove(K key) throws CacheException {
        V old = get(key);
        redisTemplate.delete(getCacheKey(key));
        return old;
    }

    @Override
    public void clear() throws CacheException {
        redisTemplate.delete(keys());
    }

    @Override
    public int size() {
        return keys().size();
    }

    @Override
    public Set<K> keys() {
        return redisTemplate.keys(getCacheKey("*"));
    }

    @Override
    public Collection<V> values() {
        Set<K> set = keys();
        List<V> list = new ArrayList<>();
        for (K s : set) {
            list.add(get(s));
        }
        return list;
    }

    private K getCacheKey(Object k) {
        return (K) (this.cacheKey + k);
    }

}
