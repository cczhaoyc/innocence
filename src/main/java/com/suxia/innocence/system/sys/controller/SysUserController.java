package com.suxia.innocence.system.sys.controller;

import com.suxia.innocence.common.response.Response;
import com.suxia.innocence.common.response.SuccessResponse;
import com.suxia.innocence.system.sys.domain.SysUser;
import com.suxia.innocence.system.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 15:26 星期二
 * @description TODO 用户表顶级控制器
 */
@Controller
@RequestMapping("/sys")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    /**
     * 新增用户
     *
     * @return
     */
    @RequestMapping("/addSysUser")
    @ResponseBody
    public Response addSysUser(@ModelAttribute("sysUser") SysUser sysUser) {
        return new SuccessResponse(sysUserService.addSysUser(sysUser));
    }

    @RequestMapping("/addSysUserView")
    public String addSysUserView() {
        return "sysuser/sysUserAdd";
    }


}
