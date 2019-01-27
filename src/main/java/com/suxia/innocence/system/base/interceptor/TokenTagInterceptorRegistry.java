package com.suxia.innocence.system.base.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月27 12:42 星期日
 * @description TODO 注册表单重复提交验证拦截器
 */
@SpringBootConfiguration
public class TokenTagInterceptorRegistry extends WebMvcConfigurerAdapter {

    @Autowired
    private TokenTagInterceptor tokenTagInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(tokenTagInterceptor).addPathPatterns("/**");
    }
}
