package cn.x.study.fanout.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.alibaba.fastjson.JSON;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SendFanoutMessageService {
    @Autowired
    RabbitTemplate rabbitTemplate;


    public void senMessage() {
        String messageId = String.valueOf(UUID.randomUUID());
        String messageContext = "hello FanoutExchange!!";
        String sendTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, String> messageMap = new HashMap<>();
        messageMap.put("messageId", messageId);
        messageMap.put("messageContext", messageContext);
        messageMap.put("sendTime", sendTime);
        rabbitTemplate.convertAndSend("FanoutExchange", null, JSON.toJSONString(messageMap), new CorrelationData(messageId));

    }
}
