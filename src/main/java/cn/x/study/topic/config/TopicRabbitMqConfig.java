package cn.x.study.topic.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * 主题交换机
 */
@Configuration
public class TopicRabbitMqConfig {


    // 创建一个主题交换机
    @Bean
    TopicExchange topicExchange() {
        return new TopicExchange("TopicExchange");
    }

    // 创建队列
    @Bean
    Queue queueA() {
        return new Queue("TopicQueue.A");
    }

    @Bean
    Queue queueB() {
        return new Queue("TopicQueue.B");
    }

    @Bean
    Binding bingA() {
        // #会匹配多个词,例如 MAX.aaa.bbb 只要是MAX开头都会被匹配到
        return BindingBuilder.bind(queueA()).to(topicExchange()).with("MAX.#");
    }

    @Bean
    Binding bingB() {
        // *会匹配一个词,只能匹配一个,例如MAX.aa,MAX.bb 都会被匹配
        // MAX.bb.aa 就不会被匹配,因为*号只能匹配到bb这个词,无法匹配到aa
        return BindingBuilder.bind(queueB()).to(topicExchange()).with("MAX.*");
    }

}
