package com.suxia.innocence.common.response;

import com.suxia.innocence.system.exception.constant.ExceptionCode;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月10 14:54 星期四
 * @description TODO 异常返回
 */
public class ErrorResponse extends Response {

    private static final long serialVersionUID = 381384101689531502L;

    public ErrorResponse() {
        setSuccess(Boolean.FALSE);
        setStatus(200);
    }

    public ErrorResponse(String errorMsg) {
        this();
        setError(new Error(ErrorLevel.ERROR, ExceptionCode.BUSINESS_ERR_CODE, errorMsg));
    }

    public ErrorResponse(String errorCode, String errorMsg) {
        this();
        setError(new Error(ErrorLevel.ERROR, errorCode, errorMsg));
    }

}
