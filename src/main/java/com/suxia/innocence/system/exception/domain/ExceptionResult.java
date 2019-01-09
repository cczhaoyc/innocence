package com.suxia.innocence.system.exception.domain;

import com.suxia.innocence.system.exception.constant.ExceptionCode;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月09 11:35 星期三
 * @description TODO 异常返回结果实体
 */
public class ExceptionResult {

    private String errCode = ExceptionCode.DEFAULT_ERR_CODE;// 异常编码
    private String errMsg;// 异常信息
    private String errLevel = ExceptionCode.DEFAULT_ERR_LEVEL;// 异常级别

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

    @Override
    public String toString() {
        return "ExceptionResult{" +
                "errCode='" + errCode + '\'' +
                ", errMsg='" + errMsg + '\'' +
                ", errLevel='" + errLevel + '\'' +
                '}';
    }
}
