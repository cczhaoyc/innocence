package com.suxia.innocence.system.base.rabbitmq.consumer;

import com.rabbitmq.client.Channel;
import com.suxia.innocence.system.base.domain.BaseDomain;
import com.suxia.innocence.system.base.rabbitmq.constant.RabbitConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年02月04 11:27 星期一
 * @description TODO 消费者接收消息
 */
@Component
public class MessageReceiver {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = RabbitConstant.ROUTINGKEY_SUN, durable = "true"),
            exchange = @Exchange(value = RabbitConstant.EXCHANGE_SUN, durable = "true", type = RabbitConstant.TOPIC),
            key = RabbitConstant.ROUTINGKEY_DEFAULT))
    @RabbitHandler
    public void receive(@Payload BaseDomain domain, @Headers Map<String, Object> headers, Channel channel) throws Exception {
        Long tag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        channel.basicAck(tag, false);
        LOG.info("MessageReceiver，接收消息id是：" + domain.getId());
    }
}
