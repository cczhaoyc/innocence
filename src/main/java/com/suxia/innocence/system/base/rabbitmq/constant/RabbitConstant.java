package com.suxia.innocence.system.base.rabbitmq.constant;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年02月04 10:34 星期一
 * @description TODO rabbitmq常量池
 */
public interface RabbitConstant {

    String ROUTINGKEY_DEFAULT = "rtk.#";

    String EXCHANGE_SUN = "exc.sun";

    String ROUTINGKEY_SUN = "rtk.sun";
    /**
     * Exchange Types
     */
    String FANOUT = "fanout";
    String DIRECT = "direct";
    String TOPIC = "topic";
    String HEADERS = "headers";
}
