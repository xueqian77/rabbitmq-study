package cn.x.study.fanout.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
@RabbitListener(queues = "FanoutQueueA")
public class FanoutExchangeConsumerA {

    @RabbitHandler
    public void receiveMsg(String mapJson) {
        System.out.println("扇形消费者A接收到消息===" + mapJson);
    }
}
