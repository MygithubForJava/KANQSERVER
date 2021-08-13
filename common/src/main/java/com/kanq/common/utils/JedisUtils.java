package com.kanq.common.utils;

import cn.hutool.core.util.ObjectUtil;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.swing.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@Data
public class JedisUtils {

    private  static String host;
    private  static Integer port;
    private static Integer maxIdle;
    private static Long maxWait;
    private  static Integer minIdle;

    @Value("${spring.redis.host}")
    public  void setHost(String value) { host=value; }
    @Value("${spring.redis.port}")
    public  void setPort(Integer value) { port=value; }
    @Value("${spring.redis.jedis.pool.max-idle}")
    public  void setMaxIdle(Integer value) { maxIdle=value; }
    @Value("${spring.redis.jedis.pool.max-wait}")
    public  void setMaxWait(Long value) { maxWait=value; }
    @Value("${spring.redis.jedis.pool.min-idle}")
    public  void setMinIdle(Integer value) { minIdle=value; }


    private  static volatile JedisPool jedisPool = null;

    @PostConstruct
    public static void init(){
        if (jedisPool==null){
            JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
            jedisPoolConfig.setMaxIdle(maxIdle);
            jedisPoolConfig.setMaxWaitMillis(maxWait);
            jedisPoolConfig.setMinIdle(minIdle);
            jedisPoolConfig.setTestOnBorrow(false);
            jedisPoolConfig.setTestOnReturn(true);
            jedisPoolConfig.setMaxTotal(1000);
            jedisPool = new JedisPool(jedisPoolConfig, host, port, 100);
        }
    }


    private static void returnJedis(Jedis jedis){
        if (ObjectUtil.isNotEmpty(jedis)&&ObjectUtil.isNotEmpty(jedisPool)){
            jedisPool.returnResource(jedis);
        }
    }


    /**
     *delkey
     * @param key
     */
    public static void delKey(String key){
        Jedis jedis = jedisPool.getResource();
        jedis.del(key);
        returnJedis(jedis);
    }

    /**
     * 设置key值
     * @param key
     * @param value
     */
    public static void setValue(String key,String value){
        Jedis jedis = jedisPool.getResource();
        jedis.set(key,value);
        returnJedis(jedis);
    }


    public static void setValue(String key, Map value){
        Jedis jedis = jedisPool.getResource();
        jedis.hmset(key,value);
        returnJedis(jedis);
    }

    public static String getStringValue(String key){
        Jedis jedis = jedisPool.getResource();
        String s = jedis.get(key);
        returnJedis(jedis);
        return s;
    }
    public static Map<String,String> getMapValue(String key){
        Jedis jedis = jedisPool.getResource();
        Map<String, String> stringStringMap = jedis.hgetAll(key);
        returnJedis(jedis);
        return stringStringMap;
    }

    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public static boolean existKey(String key){
        Jedis jedis = jedisPool.getResource();
        Boolean exists = jedis.exists(key);
        returnJedis(jedis);
       return exists;
    }

    /**
     * 重命名KEY
     * @param oldKey
     * @param newKey
     * @return
     */
    public static String rename(String oldKey, String newKey) {
        Jedis jedis = jedisPool.getResource();
        String result = jedis.rename(oldKey, newKey);
        returnJedis(jedis);
        return result;
    }

    /**
     * 设置失效时间
     * @param key
     * @param seconds
     */
    public static void expire(String key, Long seconds) {
        Jedis jedis = jedisPool.getResource();
        jedis.expire(key,seconds);
        returnJedis(jedis);
    }
    public static Long getExpireTime(String key) {
        Jedis jedis = jedisPool.getResource();
        Long ttl = jedis.ttl(key);
        returnJedis(jedis);
        return ttl;
    }

    public static Long getExpireRemainingTime(String key) {
        Jedis jedis = jedisPool.getResource();
        Long ttl = jedis.pttl(key);
        returnJedis(jedis);
        return ttl;
    }
    /**
     * 删除失效时间
     * @param key
     */
    public static void persist(String key) {
        Jedis jedis = jedisPool.getResource();
        jedis.persist(key);
        returnJedis(jedis);
    }
}
