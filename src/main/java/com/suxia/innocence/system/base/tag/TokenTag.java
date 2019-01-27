package com.suxia.innocence.system.base.tag;

import com.suxia.innocence.common.util.SpringBeanUtil;
import com.suxia.innocence.system.base.redis.RedisService;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.UUID;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月27 14:22 星期日
 * @description TODO 自定义JSP Tag用于表单重复提交验证
 */
public class TokenTag extends TagSupport {

    private static final long serialVersionUID = 5413043978783344840L;

    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            String token = UUID.randomUUID().toString().replaceAll("-", "");
            cacheToken(token);
            out.println("<input type='hidden' id='tokenId'  name='tokenId' value='" + token + "'/>");
        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }
        return SKIP_BODY;
    }

    /**
     * 缓存当前Token
     *
     * @param token
     */
    private void cacheToken(String token) {
        RedisService redisService = (RedisService) SpringBeanUtil.getBeanFromSpringByBeanName("redisService");
        redisService.setForStringWithTimeout(token, token);
    }

}
