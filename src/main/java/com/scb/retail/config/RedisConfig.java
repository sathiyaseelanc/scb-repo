package com.scb.retail.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.ChannelTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.scb.retail.queue.MessagePublisher;
import com.scb.retail.queue.MessagePublisherImpl;
import com.scb.retail.queue.MessageSubscriber;

@Configuration
@ComponentScan("com.scb")
public class RedisConfig {

    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConFactory
        = new JedisConnectionFactory();
      jedisConFactory.setHostName("127.0.0.1");
      jedisConFactory.setPort(6379);
      return jedisConFactory;
    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate() {
        final RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(jedisConnectionFactory());
        template.setValueSerializer(new GenericToStringSerializer<Object>(Object.class));
        
        RedisSerializer<?> stringSerializer = new StringRedisSerializer();
        template.setKeySerializer(stringSerializer); 
        template.setHashKeySerializer(stringSerializer);
       // template.setHashValueSerializer( new GenericToStringSerializer< Object >( Object.class ) );

        return template;
    }

    @Bean
    MessageListenerAdapter messageListener() {
        return new MessageListenerAdapter(new MessageSubscriber());
    }

    @Bean
    RedisMessageListenerContainer redisContainer() {
        final RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(jedisConnectionFactory());
        container.addMessageListener(messageListener(), topic());
        return container;
    }

    @Bean
    MessagePublisher redisPublisher() {
        return new MessagePublisherImpl(redisTemplate(), topic());
    }

    @Bean
    ChannelTopic topic() {
        return new ChannelTopic("pubsub:queue");
    }
}