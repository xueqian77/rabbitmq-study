package cn.x.study.topic.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "TopicQueue.A")
public class TopicConsumerA {

    @RabbitHandler
    public void consumer1(String msg) {
        System.out.println("topic消费者A===" + msg);
    }


}
