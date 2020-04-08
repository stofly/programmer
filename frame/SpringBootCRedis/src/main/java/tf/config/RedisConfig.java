package tf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.jedis.JedisConnection;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author stf
 */
public class RedisConfig {

    /**
     * 创建 JedisPoolConfig 对象。 在该对象中完成一些链接池配置
     *
     * @return
     */
    @Bean
    private JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //最大空闲数
        jedisPoolConfig.setMaxIdle(10);
        //最小空闲数
        jedisPoolConfig.setMinIdle(5);
        //最大链接数
        jedisPoolConfig.setMaxTotal(20);
        return jedisPoolConfig;
    }

    /**
     * 创建 JedisConnectionFactory： 配置 redis 链接信息
     *
     * @return
     */
    @Bean
    private JedisConnectionFactory jedisConnectionFactory(JedisPoolConfig config) {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setPoolConfig(config);
        //配置链接 Redis 的信息
        //主机地址
        jedisConnectionFactory.setHostName("127.0.0.1");
        //端口
        jedisConnectionFactory.setPort(6379);
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
