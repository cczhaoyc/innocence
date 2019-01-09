package com.suxia.innocence.system.exception.constant;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月09 12:42 星期三
 * @description TODO 异常参数
 */
public interface ExceptionCode {

    /**
     * 异常等级
     */
    String DEFAULT_ERR_LEVEL = "error";

    /**
     * 异常编码
     */
    String DEFAULT_ERR_CODE = "SYS-100";
    String BUSINESS_ERR_CODE = "BUS-100";
    String SERVICE_ERR_CODE = "SER-100";
    String UNKNOWN_ERR_CODE = "UNK-100";


}
