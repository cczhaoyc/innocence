package com.suxia.innocence.system.exception.base;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月09 14:10 星期三
 * @description TODO 参数验证异常
 */
public class BusinessValidationException extends BaseRuntimeException {

    public BusinessValidationException(String message) {
        super(message);
    }

}
