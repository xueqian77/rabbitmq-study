package cn.x.study.fanout.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 扇形交换机
 */
@Configuration
public class FanoutRabbitMqConfig {

    // 创建扇形交换机
    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange("FanoutExchange");
    }

    // 创建队列绑定
    @Bean
    Queue FanoutQueueA() {
        return new Queue("FanoutQueueA");
    }

    @Bean
    Queue FanoutQueueB() {
        return new Queue("FanoutQueueB");
    }

    // 队列绑定交换机
    @Bean
    Binding queueABindingExchange() {return BindingBuilder.bind(FanoutQueueA()).to(fanoutExchange());}

    @Bean
    Binding queueBBindingExchange() {
        return BindingBuilder.bind(FanoutQueueB()).to(fanoutExchange());
    }

}
