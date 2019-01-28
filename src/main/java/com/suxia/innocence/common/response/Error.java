package com.suxia.innocence.common.response;

import java.io.Serializable;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月10 14:46 星期四
 * @description TODO 异常信息
 */
public class Error implements Serializable {

    private static final long serialVersionUID = -7151063448441045798L;
    /**
     * 错误级别
     */
    private ErrorLevel errorLevel;
    /**
     * 错误Code码
     */
    private String errorCode;
    /**
     * 错误信息
     */
    private String errorMsg;

    public Error() {
    }

    public Error(ErrorLevel errorLevel, String errorCode, String errorMsg) {
        this.errorLevel = errorLevel;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public ErrorLevel getErrorLevel() {
        return errorLevel;
    }

    public void setErrorLevel(ErrorLevel errorLevel) {
        this.errorLevel = errorLevel;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
