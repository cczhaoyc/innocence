package com.suxia.innocence.system.base.filter;

import com.suxia.innocence.common.util.ValidationUtil;
import com.suxia.innocence.system.base.service.LoginService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月25 10:16 星期五
 * @description TODO 登录过滤器
 */
public class LoginFilter implements Filter {

    private static final List<String> EXCLUDE_URL = new ArrayList<>();
    private LoginFilterProperties loginFilterProperties;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (ValidationUtil.isEmptyObject(loginFilterProperties) || ValidationUtil.isEmptyString(loginFilterProperties.getExclude())) {
            return;
        }
        String exclude = loginFilterProperties.getExclude();
        String[] urls = exclude.split("\\;");
        if (ValidationUtil.isEmptyArray(urls)) {
            return;
        }
        for (String url : urls) {
            if (url != null && "".equals(url.trim())) {
                continue;
            }
            EXCLUDE_URL.add(url);
        }
    }

    private boolean isStaticResources(String uri) {
        boolean ok = uri.endsWith(".swf") || uri.endsWith(".jpg") || uri.endsWith(".JPG") || uri.endsWith(".gif")
                || uri.endsWith(".css") || uri.endsWith(".js") || uri.endsWith(".png") || uri.endsWith(".bmp")
                || uri.endsWith(".ico") || uri.endsWith("1.txt") || uri.endsWith(".amr") || uri.endsWith(".mp3")
                || uri.endsWith(".apk") || uri.toLowerCase().endsWith(".doc") || uri.toLowerCase().endsWith(".docx")
                || uri.toLowerCase().endsWith(".pdf") || uri.toLowerCase().endsWith(".txt")
                || uri.toLowerCase().endsWith(".ppt") || uri.toLowerCase().endsWith(".pptx")
                || uri.toLowerCase().endsWith(".xls") || uri.toLowerCase().endsWith(".xlsx");
        return ok;
    }

    private boolean isNotLoginValidate(String url) {
        if (isStaticResources(url)) {
            return true;
        }
        for (String path : EXCLUDE_URL) {
            if (url.equals(path)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if (isNotLoginValidate(uri)) {
            filterChain.doFilter(request, response);
            return;
        }
        WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getServletContext());
        LoginService loginService = applicationContext.getBean(LoginService.class);
        Boolean isLogin = loginService.isLogin(request, response);
        if (isLogin) {
            filterChain.doFilter(request, response);
            return;
        } else {
            redirect(request, response);
            return;
        }
    }

    private void redirect(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<script>");
        out.println("document.location.href='/'");
        out.println("</script>");
        out.println("</html>");
    }

    @Override
    public void destroy() {

    }

    public LoginFilterProperties getLoginFilterProperties() {
        return loginFilterProperties;
    }

    public void setLoginFilterProperties(LoginFilterProperties loginFilterProperties) {
        this.loginFilterProperties = loginFilterProperties;
    }
}
