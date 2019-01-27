package com.suxia.innocence.system.base.filter;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月25 10:44 星期五
 * @description TODO 登录过滤器属性
 */
@Component
@ConfigurationProperties(prefix = "project.loginfilter")
public class LoginFilterProperties {

    /**
     * 放行的URL
     */
    private String exclude;

    public String getExclude() {
        return exclude;
    }

    public void setExclude(String exclude) {
        this.exclude = exclude;
    }

    @Override
    public String toString() {
        return "LoginFilterProperties{" +
                "exclude='" + exclude + '\'' +
                '}';
    }
}
