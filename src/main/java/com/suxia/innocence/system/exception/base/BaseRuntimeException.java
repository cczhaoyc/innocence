package com.suxia.innocence.system.exception.base;

import com.suxia.innocence.system.exception.constant.ExceptionCode;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月09 11:24 星期三
 * @description TODO 异常基础类
 */
public class BaseRuntimeException extends RuntimeException {

    private static final long serialVersionUID = -7552790181792485262L;

    private String errCode = ExceptionCode.DEFAULT_ERR_CODE;// 异常编码
    private String errMsg;// 异常信息
    private String errLevel = ExceptionCode.DEFAULT_ERR_LEVEL;// 异常级别

    public BaseRuntimeException() {
    }

    public BaseRuntimeException(String message) {
        super(message);
    }

    public BaseRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseRuntimeException(Throwable cause) {
        super(cause);
    }

    public BaseRuntimeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getErrLevel() {
        return errLevel;
    }

    public void setErrLevel(String errLevel) {
        this.errLevel = errLevel;
    }
}
