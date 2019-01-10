package com.suxia.innocence.common.response;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月10 14:47 星期四
 * @description TODO
 */
public enum ErrorLevel {

    /**
     * 错误
     */
    ERROR("error"),
    /**
     * 警告
     */
    WARNING("warning"),
    /**
     * 提示
     */
    INFO("info");

    private String name;

    private ErrorLevel(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
