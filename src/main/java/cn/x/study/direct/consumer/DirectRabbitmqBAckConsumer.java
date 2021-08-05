package cn.x.study.direct.consumer;

import com.alibaba.fastjson.JSONObject;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;


/**
 * 收到B消息后手动确定
 */
@Component
public class DirectRabbitmqBAckConsumer implements ChannelAwareMessageListener {
    @Override
    public void onMessage(Message message, Channel channel) throws IOException {
        System.out.println("*****************************消费者收到消息************************");
        long deliveryTag = message.getMessageProperties().getDeliveryTag();
        try {
                Map<String, String> map = JSONObject.parseObject(new String(message.getBody()),Map.class);
                System.out.println("消息id{messageId}" + map.get("messageId"));
                System.out.println("消息实体{messageContext}" + map.get("messageContext"));
                System.out.println("发送时间{sendTime}" + map.get("sendTime"));
                System.out.println("消息标签{deliveryTag}" + deliveryTag);
                channel.basicAck(deliveryTag, true);//确认消息已推送到消费者
        } catch (Exception e) {
            System.out.println("发生异常,将会把消息重新推送到消息队列");
            channel.basicReject(deliveryTag, true);//消息发送失败，放回队列中重新发送
        }
    }
}
