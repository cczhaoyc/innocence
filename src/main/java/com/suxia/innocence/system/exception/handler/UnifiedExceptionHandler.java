package com.suxia.innocence.system.exception.handler;

import com.suxia.innocence.system.exception.base.BaseRuntimeException;
import com.suxia.innocence.system.exception.base.BusinessValidationException;
import com.suxia.innocence.system.exception.base.ServiceValidationException;
import com.suxia.innocence.system.exception.constant.ExceptionCode;
import com.suxia.innocence.system.exception.domain.ExceptionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月09 14:01 星期三
 * @description TODO 统一异常处理器
 */
@ControllerAdvice
public class UnifiedExceptionHandler {

    private static Logger logger = LoggerFactory
            .getLogger(UnifiedExceptionHandler.class);

    /**
     * 拦截捕捉自定义异常
     *
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ExceptionResult handlerException(Exception ex) {

        if (ex instanceof BusinessValidationException) {
            return dealBusinessValidationException(ex);
        } else if (ex instanceof ServiceValidationException) {
            return dealServiceValidationException(ex);
        } else {
            return dealUnknownException(ex);
        }

    }

    private ExceptionResult dealBusinessValidationException(Exception ex) {
        logger.error("intercept exception [errorCode="
                + ExceptionCode.BUSINESS_ERR_CODE + "]:", ex);
        ExceptionResult result = new ExceptionResult();
        result.setErrCode(ExceptionCode.BUSINESS_ERR_CODE);
        result.setErrMsg(ex.getMessage());
        result.setErrLevel(ExceptionCode.DEFAULT_ERR_LEVEL);
        return result;
    }

    private ExceptionResult dealServiceValidationException(Exception ex) {
        logger.error("intercept exception [errorCode="
                + ExceptionCode.SERVICE_ERR_CODE + "]:", ex);
        ExceptionResult result = new ExceptionResult();
        result.setErrCode(ExceptionCode.SERVICE_ERR_CODE);
        result.setErrMsg(ex.getMessage());
        result.setErrLevel(ExceptionCode.DEFAULT_ERR_LEVEL);
        return result;
    }

    private ExceptionResult dealUnknownException(Exception ex) {
        logger.error("intercept exception [errorCode="
                + ExceptionCode.UNKNOWN_ERR_CODE + "]:", ex);
        ExceptionResult result = new ExceptionResult();
        result.setErrCode(ExceptionCode.UNKNOWN_ERR_CODE);
        result.setErrMsg("异常编码:[" + ExceptionCode.UNKNOWN_ERR_CODE
                + "] 操作失败，请重试或者联系系统相关人员！");
        result.setErrLevel(ExceptionCode.DEFAULT_ERR_LEVEL);
        return result;
    }
}
