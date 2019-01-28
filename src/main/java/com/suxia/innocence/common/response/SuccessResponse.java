package com.suxia.innocence.common.response;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月10 14:58 星期四
 * @description TODO 成功返回
 */
public class SuccessResponse extends Response {

    public SuccessResponse() {
        setSuccess(Boolean.TRUE);
        setStatus(200);
    }

    public SuccessResponse(Object data) {
        this();
        setData(data);
    }
}
