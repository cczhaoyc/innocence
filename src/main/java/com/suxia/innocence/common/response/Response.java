package com.suxia.innocence.common.response;

import java.io.Serializable;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月10 14:46 星期四
 * @description TODO
 */
public class Response implements Serializable {

    private static final long serialVersionUID = -695104805001997742L;

    /**
     * 返回业务成功或业务失败
     */
    private Boolean success;
    /**
     * 数据体
     */
    private Object data;
    /**
     * 消息状态码
     */
    private Integer status;
    /**
     * 异常信息
     */
    private Error error;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
