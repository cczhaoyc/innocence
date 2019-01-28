package com.suxia.innocence.common.util;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月23 17:07 星期三
 * @description TODO 通过Bean名称在spring容器中获取对象
 */
@Component("springBeanUtil")
public class SpringBeanUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringBeanUtil.applicationContext = applicationContext;
    }

    /**
     * 通过Bean名称在spring容器中获取对象
     * @param beanName
     * @return
     */
    public static Object getBeanFromSpringByBeanName(String beanName) {
        return applicationContext.getBean(beanName);
    }

}
