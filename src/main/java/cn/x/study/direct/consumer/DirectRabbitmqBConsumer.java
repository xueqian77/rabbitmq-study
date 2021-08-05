package cn.x.study.direct.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
@RabbitListener(queues = "DirectQueueB")
public class DirectRabbitmqBConsumer {


    @RabbitHandler
    public void process(String json) {
        System.out.println("消费者B接收到消息====" + json);
    }

}
