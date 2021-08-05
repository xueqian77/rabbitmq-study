package cn.x.study.config.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * rabbitMq生产者配置
 */
@Component
public class RabbitMqProducerConfig implements CommandLineRunner {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @Override
    public void run(String... args)  {
        initializationRabbitMqTemplateCallBack();
    }

    /**
     * 设置rabbitTemplate 全局回调
     */
    private void initializationRabbitMqTemplateCallBack() {
        /**
         * 当mandatory标志位设置为true时
         * 如果exchange根据自身类型和消息routingKey无法找到一个合适的queue存储消息
         * 那么broker会调用basic.return方法将消息返还给生产者
         * 当mandatory设置为false时，出现上述情况broker会直接将消息丢弃
         */
        rabbitTemplate.setMandatory(true);
        // ReturnCallback接口用于实现消息发送到RabbitMQ交换器，但无相应队列与交换器绑定时的回调
        rabbitTemplate.setReturnsCallback(new RabbitMqReturnCallback());
        // ConfirmCallback接口用于实现消息发送到RabbitMQ交换器后接收ack回调
        rabbitTemplate.setConfirmCallback(new RabbitMqTemplateConfirmCallback());
    }
}
