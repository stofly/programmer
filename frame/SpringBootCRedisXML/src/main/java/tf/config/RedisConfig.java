package tf.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 配置文件版
 * @author stf
 */
@Configuration
public class RedisConfig {

    /**
     * 创建 JedisPoolConfig 对象。 在该对象中完成一些链接池注解配置
     *
     * @return
     *
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis.pool")
    JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        return jedisPoolConfig;
    }

    /**
     * 创建 JedisConnectionFactory： 注解配置 redis 链接信息
     *
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.redis")
    JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPoolConfig(config);
        return jedisConnectionFactory;
    }

    /**
     * 创建 RedisTemplate:用于执行 Redis 操作的方法
     *
     * @param factory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(JedisConnectionFactory factory) {
        //关联
        RedisTemplate<String, Object> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setConnectionFactory(factory);
        //为 key 设置序列化器
        objectObjectRedisTemplate.setKeySerializer(new StringRedisSerializer());
        //为 value 设置序列化器
        objectObjectRedisTemplate.setValueSerializer(new StringRedisSerializer());
        return objectObjectRedisTemplate;
    }
}
