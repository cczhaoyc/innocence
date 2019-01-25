package com.suxia.innocence.system.base.service;

import com.suxia.innocence.system.sys.domain.SysUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月23 17:06 星期三
 * @description TODO 登录业务顶级接口
 */
public interface LoginService {

    /**
     * 登录验证
     *
     * @param sysUser
     * @param request
     * @param response
     * @return
     */
    String login(SysUser sysUser, HttpServletRequest request, HttpServletResponse response);

    /**
     * 退出系统
     *
     * @param request
     * @param response
     */
    void logout(HttpServletRequest request, HttpServletResponse response);

    /**
     * 验证用户是否已登录
     *
     * @param response
     * @param request
     * @return
     */
    boolean isLogin(HttpServletRequest request, HttpServletResponse response);
}
