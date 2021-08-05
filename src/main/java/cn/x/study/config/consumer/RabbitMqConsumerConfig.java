package cn.x.study.config.consumer;

import cn.x.study.direct.consumer.DirectRabbitmqBAckConsumer;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 消费者配置类（一般无需这样配置，只是知道还能这样做就行）
 */
@Component
public class RabbitMqConsumerConfig {

    @Autowired
    CachingConnectionFactory cachingConnectionFactory;

    @Autowired
    DirectRabbitmqBAckConsumer directRabbitmqBAckConsumer;

    /*@Bean*/
    public SimpleMessageListenerContainer simpleMessageListenerContainer() {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer(cachingConnectionFactory);
        container.setQueueNames("DirectQueueB");//监听的队列
        container.setConcurrentConsumers(1);    // 当前的消费者数量
        container.setMaxConcurrentConsumers(1); // 最大的消费者数量
        container.setDefaultRequeueRejected(true); // 是否重回队列
        container.setAcknowledgeMode(AcknowledgeMode.MANUAL); // 签收模式（手动签收）
        container.setExposeListenerChannel(true); //设置监听外露
        container.setMessageListener(directRabbitmqBAckConsumer);  //设置消息监听处理类
        return container;
    }
}
