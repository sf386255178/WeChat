package com.kevin.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/10/23
 * TODO:redis操作工具类
 */
//@Component
public class RedisUtil {
//    @Resource
//    private RedisTemplate<String,String> redisTemplate;
    static RedisTemplate<String,String> redisTemplate = new RedisTemplate<String, String>();
    /**
     * 读取缓存
     * @param key
     * @return
     */
    public  String get(final String key){
        return  redisTemplate.opsForValue().get(key);
    }

    /**
     * 写入缓存
     * @param key
     * @param value
     * @return
     */
    public static boolean set( String key,String value){
        boolean result = false;
        try{
            redisTemplate.opsForValue().set(key,value);
            result = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;
    }

    /**
     * 更新缓存
     * @param key
     * @param value
     * @return
     */
    public  boolean getAndSet(final String key,String value){
        boolean result = false;
        try {
            redisTemplate.opsForValue().getAndSet(key,value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 删除缓存
     * @param key
     * @return
     */
    public boolean delete(final String key){
        boolean result = false;
        try {
            redisTemplate.delete(key);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}