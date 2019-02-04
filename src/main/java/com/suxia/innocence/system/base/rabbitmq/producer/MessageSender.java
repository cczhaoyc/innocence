package com.suxia.innocence.system.base.rabbitmq.producer;

import com.suxia.innocence.system.base.domain.BaseDomain;
import com.suxia.innocence.system.base.rabbitmq.constant.RabbitConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年02月04 10:18 星期一
 * @description TODO 生产者发送消息
 */
@Component
public class MessageSender {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 发送消息
     *
     * @param domain
     */
    public void send(BaseDomain domain) {
        CorrelationData correlationData = new CorrelationData(String.valueOf(domain.getId()));
        LOG.info("MessageSender，发送消息id是：" + domain.getId());
        rabbitTemplate.convertAndSend(RabbitConstant.EXCHANGE_SUN, RabbitConstant.ROUTINGKEY_SUN, domain, correlationData);
    }

}
