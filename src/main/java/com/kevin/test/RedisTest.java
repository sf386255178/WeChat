package com.kevin.test;

import com.kevin.util.RedisUtil;
import com.kevin.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * AUTHOR:Kevin Ding
 * TIME:2019/10/23
 * TODO:redis测试类
 */
public class RedisTest {
    @Resource
    private RedisUtil redisUtil;

//    RedisUtil util = new RedisUtil();
//    @Test
    public  void set(){
//        redisUtil.set("redis_key","redis_value");
        String key = "key_test";
        String value = "value_test";
        RedisUtil util = new RedisUtil();
        util.set(key,value);


    }

//    public void get(){
//        String value = redisUtil.get("redis_key");
//        System.out.println(value);
//    }
public static void main(String[] args) {
    Map param = null;
    System.out.println("null".equals(param));
}

}