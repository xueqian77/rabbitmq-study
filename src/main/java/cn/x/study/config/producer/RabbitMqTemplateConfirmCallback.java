package cn.x.study.config.producer;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;


/**
 * 消息发送成功的回调。
 */
@Component
public class RabbitMqTemplateConfirmCallback implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        if (b) {
            System.out.println("消息推送成功");
            System.out.println("消息唯一标识：" + correlationData);
        } else {
            System.out.println("消息推送失败");
            System.out.println("消息唯一标识：" + correlationData);
            System.out.println("失败原因：" + s);
        }
    }
}
