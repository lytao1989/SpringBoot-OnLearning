package com.example;

import com.example.domain.User;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
public class RedisConfig
{
//    @Bean
//    JedisConnectionFactory jedisConnectionFactory()
//    {
//        return  new JedisConnectionFactory();
//    }

//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory)
//    {
//        RedisCacheConfiguration redisCacheConfiguration=RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofSeconds(100));
//        RedisCacheManager redisCacheManager = RedisCacheManager.builder(redisConnectionFactory).build();
//        return redisCacheManager;
//    }

    @Bean
    public RedisTemplate<String,User> redisTemplate(RedisConnectionFactory redisConnectionFactory)
    {
        RedisTemplate<String,User> template=new RedisTemplate<String,User>();
        template.setConnectionFactory(redisConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisObjectSerializer());

        return  template;
    }
}
