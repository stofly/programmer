package tf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tf.App;
import tf.pojo.User;

import javax.annotation.Resource;

/**
 * @author stf
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RedisTest {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    @Test
    public void  setSerializerUser(){
        User user = new User();
        user.setAge(20);
        user.setName("张三丰");
        user.setId(1);
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        //塞到redis中--直接无法放入，必须要设置序列化器
        this.redisTemplate.opsForValue().set("user",user);

    }

    @Test
    public void  getSerializerUser(){
        this.redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        User user = (User) this.redisTemplate.opsForValue().get("user");
        System.out.println(user);
    }


    @Test
    public void  setJackson2JsonUser(){
        User user = new User();
        user.setAge(33);
        user.setName("李甲鱼");
        user.setId(8);
        this.redisTemplate.setValueSerializer(new
                Jackson2JsonRedisSerializer<>(User.class));
        this.redisTemplate.opsForValue().set("user_json", user);

    }

    @Test
    public void  getJackson2JsonUser(){
        this.redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<>(User.class));
        User user = (User) this.redisTemplate.opsForValue().get("user_json");
        System.out.println(user);
    }
}
