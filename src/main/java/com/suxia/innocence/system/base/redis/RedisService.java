package com.suxia.innocence.system.base.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月24 14:21 星期四
 * @description TODO redis工具类
 */
@Component
public class RedisService {

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;

    /**
     * 默认过期时长，单位：秒
     */
    public static final Long DEFAULT_EXPIRE = 2 * 60 * 60L;

    /**
     * 不设置过期时长
     */
    public static final long NOT_EXPIRE = -1;

    public void setForString(Object key, Object value) {
        StringBuilder baseKey = new StringBuilder();
        baseKey.append("sys:").append(key);
        redisTemplate.opsForValue().set(baseKey, value);
    }

    public void setForStringWithTimeout(Object key, Object value) {
        StringBuilder baseKey = new StringBuilder();
        baseKey.append("sys:").append(key);
        redisTemplate.opsForValue().set(baseKey, value, DEFAULT_EXPIRE, TimeUnit.SECONDS);
    }

    public Object getForString(Object key) {
        StringBuilder baseKey = new StringBuilder();
        baseKey.append("sys:").append(key);
        return redisTemplate.opsForValue().get(baseKey);
    }

    public void delete(Object key) {
        StringBuilder baseKey = new StringBuilder();
        baseKey.append("sys:").append(key);
        redisTemplate.delete(baseKey);
    }
}

