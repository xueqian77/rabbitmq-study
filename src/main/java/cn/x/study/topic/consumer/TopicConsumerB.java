package cn.x.study.topic.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "TopicQueue.B")
public class TopicConsumerB {

    @RabbitHandler
    public void consumer1(String msg) {
        System.out.println("topic消费者B===" + msg);
    }


}
