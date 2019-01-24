package com.suxia.innocence.system.base.controller;

import com.suxia.innocence.system.base.service.LoginService;
import com.suxia.innocence.system.sys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月22 17:04 星期二
 * @description TODO 登录管理顶级控制器
 */
@Controller
@RequestMapping("/loginManager")
public class LoginController {

    @Autowired
    private LoginService loginService;

    /**
     * 登录
     *
     * @param sysUser
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@ModelAttribute SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
        return loginService.login(sysUser, request, response);
    }

    /**
     * 退出系统
     *
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = {"/logout"})
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        loginService.logout(request, response);
        return "redirect:/login";
    }

}
