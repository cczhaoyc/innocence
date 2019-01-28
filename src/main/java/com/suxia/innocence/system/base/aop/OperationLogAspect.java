package com.suxia.innocence.system.base.aop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.suxia.innocence.common.util.CookieUtil;
import com.suxia.innocence.common.util.ValidationUtil;
import com.suxia.innocence.system.base.constant.LoginConstant;
import com.suxia.innocence.system.base.domain.Session;
import com.suxia.innocence.system.base.redis.RedisService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月23 14:36 星期三
 * @description TODO 操作日志切面
 */
@Component
@Aspect
public class OperationLogAspect {

    @Autowired
    private RedisService redisService;

    private final static Logger LOG = LoggerFactory.getLogger(OperationLogAspect.class);

    private String requestPath = null; // 请求地址
    private String userName = null; // 用户名
    private Map<?, ?> inputParamMap = null; // 传入参数
    private Map<String, Object> outputParamMap = null; // 存放输出结果
    private Long startTimeMillis = 0L; // 开始时间
    private Long endTimeMillis = 0L; // 结束时间
    private String errMsg = null;// 异常消息
    private String success = null;// 是否异常

    @Pointcut("execution(* com.suxia.innocence.system.*.*.*Controller.*(..))")
    public void doPointcut() {
    }

    /**
     * 方法调用前触发,记录开始时间
     *
     * @param joinPoint
     */
    @Before("doPointcut()")
    public void doBefore(JoinPoint joinPoint) {
        errMsg = null;
        success = LoginConstant.SUCCESS;
        startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间
    }

    /**
     * 方法调用后触发,记录结束时间
     *
     * @param joinPoint
     */
    @After("doPointcut()")
    public void doAfter(JoinPoint joinPoint) {
        endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间
        printOperationLog();
    }

    /**
     * 环绕触发
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("doPointcut()")
    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        String sessionId = CookieUtil.getSessionId(request);
        Session session = (Session) redisService.getForString(sessionId);
        if (ValidationUtil.isEmptyObject(session)) {
            userName = "用户未登录";
        } else {
            userName = session.getUserName();
        }
        // 获取输入参数
        inputParamMap = request.getParameterMap();
        // 获取请求地址
        requestPath = request.getRequestURI();
        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
        outputParamMap = new HashMap<>();
        Object result = null;// result的值就是被拦截方法的返回值
        try {
            result = pjp.proceed();
        } catch (Throwable t) {
            errMsg = t.getMessage();
            success = LoginConstant.ERROR;
            throw t;
        }
        outputParamMap.put("result", result);
        return result;
    }

    /**
     * 输出日志
     */
    private void printOperationLog() {
        JSON json = new JSONObject();
        String startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
        LOG.info("\n [success：" + success + "]" + "\n [user：" + userName
                + "]\n [url：" + requestPath + "]\n [startTime：" + startTime + "]\n [useTime：" + (endTimeMillis - startTimeMillis) + "ms]"
                + "\n [param：" + json.toJSONString(inputParamMap) + "]" + "\n [result：" + json.toJSONString(outputParamMap) + "]"
                + "\n [errMsg：" + errMsg + "]");
    }
}

