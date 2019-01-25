package com.suxia.innocence.system.base.filter;

import com.suxia.innocence.system.base.domain.LoginFilterProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.DispatcherType;
import java.util.Arrays;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月25 10:16 星期五
 * @description TODO 启动过滤器
 */
@Configuration
@ConditionalOnWebApplication
public class FilterRegistration extends WebMvcConfigurerAdapter {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Bean
    @Order(10)
    public FilterRegistrationBean configureLoginFilter(LoginFilterProperties loginFilterProperties) {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setEnabled(true);
        bean.setUrlPatterns(Arrays.asList("/*"));
        // 不拦截内部跳转类型请求 DispatcherType.FORWARD, DispatcherType.INCLUDE
        bean.setDispatcherTypes(DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR);
        // 将loginFilter加入过滤器链
        bean.setFilter(loginFilter(loginFilterProperties));
        logger.debug("FilterRegistrationBean regist [" + LoginFilter.class.getName() + "], with loginFilterProperties: "
                + loginFilterProperties);
        return bean;
    }

    @Bean
    public LoginFilter loginFilter(LoginFilterProperties loginFilterProperties) {
        LoginFilter filter = new LoginFilter();
        filter.setLoginFilterProperties(loginFilterProperties);
        return filter;
    }
}
