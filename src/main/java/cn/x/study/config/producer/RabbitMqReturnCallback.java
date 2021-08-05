package cn.x.study.config.producer;

import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;


/**
 * 如果exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息,那么就会回调这里。
 */
@Component
public class RabbitMqReturnCallback implements RabbitTemplate.ReturnsCallback {
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        System.out.println("************************basic.return***************************");
        System.out.println(Charset.defaultCharset().name());
        System.out.println("消息key为===" + returnedMessage.getRoutingKey());
        System.out.println("回复错误码为===" + returnedMessage.getReplyCode());
        System.out.println("回复内容为===" + returnedMessage.getReplyText());
        System.out.println("交换器为===" + returnedMessage.getExchange());
    }
}
