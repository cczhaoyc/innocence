package com.suxia.innocence.system.base.interceptor;

import com.alibaba.fastjson.JSON;
import com.suxia.innocence.common.util.ValidationUtil;
import com.suxia.innocence.system.base.redis.RedisService;
import com.suxia.innocence.system.exception.base.ServiceValidationException;
import com.suxia.innocence.system.exception.constant.ExceptionCode;
import com.suxia.innocence.system.exception.domain.ExceptionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Enumeration;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月26 11:04 星期六
 * @description TODO 表单重复提交验证拦截
 */
@Component
public class TokenTagInterceptor extends HandlerInterceptorAdapter {

    private Logger LOG = LoggerFactory.getLogger(getClass());

    @Autowired
    private RedisService redisService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Enumeration<String> parameterNames = request.getParameterNames();
        if (tokenIdInParameters(parameterNames)) {
            String tokenId = request.getParameter("tokenId");
            if (!isFirstSubmit(tokenId)) {
                PrintWriter out = response.getWriter();
                try {
                    response.setContentType("application/json;charset=utf-8");
                    out = response.getWriter();
                    out.write(JSON.toJSONString(getExceptionResult()));
                    out.flush();
                    return false;
                } catch (Exception e) {
                    throw new ServiceValidationException("验证表单是否重复提交出错！", e);
                } finally {
                    if (out != null) {
                        out.close();
                    }
                }
            }
            redisService.delete(tokenId);
        }
        return true;
    }

    /**
     * 判断请求中是否包含tokenId
     *
     * @param parameters
     * @return
     */
    private boolean tokenIdInParameters(Enumeration<String> parameters) {
        boolean flag = false;
        while (parameters.hasMoreElements()) {
            String paraName = parameters.nextElement();
            if ("tokenId".equals(paraName)) {
                flag = true;
                break;
            }
        }
        return flag;
    }

    /**
     * 判断表单是否是第一次提交
     *
     * @param tokenId
     * @return
     */
    private boolean isFirstSubmit(String tokenId) {
        boolean flag = true;
        if (!ValidationUtil.isEmptyString(tokenId)) {
            if (ValidationUtil.isEmptyString((String) redisService.getForString(tokenId))) {
                LOG.error("TokenFilter.isFirstSubmit tokenId-->" + tokenId + " is not firstSubmit");
                flag = false;
            }
        } else {
            LOG.error("TokenFilter.isFirstSubmit need tokenId but tokenId is null");
            flag = false;
        }
        return flag;
    }

    private ExceptionResult getExceptionResult() {
        ExceptionResult result = new ExceptionResult();
        result.setErrCode(ExceptionCode.BUSINESS_ERR_CODE);
        result.setErrMsg("请勿重复提交！");
        result.setErrLevel(ExceptionCode.DEFAULT_ERR_LEVEL);
        return  result;
    }
}
