package com.suxia.innocence.system.exception.base;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月09 14:11 星期三
 * @description TODO 业务处理异常
 */
public class ServiceValidationException extends BaseRuntimeException {

    public ServiceValidationException() {
    }

    public ServiceValidationException(String message) {
        super(message);
    }

    public ServiceValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
