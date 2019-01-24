package com.suxia.innocence.system.base.service.impl;

import com.suxia.innocence.common.constant.GlobalConstant;
import com.suxia.innocence.common.util.CookieUtil;
import com.suxia.innocence.common.util.IpAddressUtil;
import com.suxia.innocence.common.util.ValidationUtil;
import com.suxia.innocence.system.base.constant.LoginConstant;
import com.suxia.innocence.system.base.domain.Session;
import com.suxia.innocence.system.base.redis.RedisService;
import com.suxia.innocence.system.base.service.LoginService;
import com.suxia.innocence.system.exception.base.BusinessValidationException;
import com.suxia.innocence.system.exception.base.ServiceValidationException;
import com.suxia.innocence.system.sys.domain.SysUser;
import com.suxia.innocence.system.sys.service.SysUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月23 17:07 星期三
 * @description TODO 登录业务顶级接口实现
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private RedisService redisService;

    @Override
    public String login(SysUser sysUser, HttpServletRequest request, HttpServletResponse response) {
        CookieUtil.clearSessionsFromCookies(request, response);// 登录时客户端可能会有cookie，进行清除
        if (sysUser == null) {
            throw new BusinessValidationException("未填写登录信息");
        }
        String userName = sysUser.getUserName();
        String password = sysUser.getPassword();
        if (ValidationUtil.isEmptyString(userName) || ValidationUtil.isEmptyString(password)) {
            throw new BusinessValidationException("账号密码不能为空");
        }
        SysUser dbUser = sysUserService.getSysUserByUserName(userName);
        if (ValidationUtil.isEmptyObject(dbUser)) {
            throw new BusinessValidationException(String.format("用户：%s不存在", userName));
        }
        Boolean ok = userLoginCheck(sysUser, dbUser);
        if (!ok) {
            throw new BusinessValidationException("用户名或密码错误，请确认后重试！");
        }
        // 登录成功,创建session,缓存用户信息
        try {
            proccessLoginSuccess(dbUser, request, response);
        } catch (Exception e) {
            throw new ServiceValidationException("缓存用户信息出错！");
        }
        return LoginConstant.INDEX;
    }

    /**
     * 登录成功,创建session,缓存用户信息
     *
     * @param dbUser
     * @param request
     * @param response
     */
    private void proccessLoginSuccess(SysUser dbUser, HttpServletRequest request, HttpServletResponse response) {
        clearSessionsAndUserInfo(dbUser, request);
        saveSessionsAndUserInfo(dbUser, request, response);
    }

    /**
     * 删除缓存
     *
     * @param dbUser
     * @param request
     */
    private void clearSessionsAndUserInfo(SysUser dbUser, HttpServletRequest request) {
        redisService.delete(dbUser.getUserName());
        // 删除缓存中的session
        String sessionId = CookieUtil.getSessionId(request);
        redisService.delete(sessionId);
    }

    /* */

    /**
     * 缓存Session的Key
     *
     * @param
     * @return
     *//*
    private String getSessionKey(String userName) {
        StringBuilder builder = new StringBuilder();
        return builder.append(GlobalConstant.LOGIN_SESSION_ID).append(":").append(userName).toString();
    }
*/

    /**
     * 缓存Session
     *
     * @param dbUser
     * @param request
     * @param response
     */
    private void saveSessionsAndUserInfo(SysUser dbUser, HttpServletRequest request, HttpServletResponse response) {
        redisService.setForStringWithTimeout(dbUser.getUserName(), dbUser);
        Session session = new Session();
        String sessionId = UUID.randomUUID().toString();
        session.setSysUserId(dbUser.getId());
        session.setUserName(dbUser.getUserName());
        session.setNickName(dbUser.getNickName());
        session.setLoginIp(IpAddressUtil.getIpAddr(request));
        session.setLogin(Boolean.TRUE);
        session.setSessionId(sessionId);
        // 将sessionId放到cookie中
        CookieUtil.saveSessionIdInCookies(request, response, GlobalConstant.LOGIN_SESSION_ID, sessionId);
        // 缓存session到redis
        redisService.setForStringWithTimeout(sessionId, session);

    }


    /**
     * 验证密码是否正确
     *
     * @param sysUser
     * @param dbUser
     * @return
     */
    private Boolean userLoginCheck(SysUser sysUser, SysUser dbUser) {
        String dbPassword = dbUser.getPassword();
        if (ValidationUtil.isEmptyObject(dbUser) || ValidationUtil.isEmptyString(dbPassword)) {
            return Boolean.FALSE;
        }
        return BCrypt.checkpw(sysUser.getPassword(), dbPassword);
    }


    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        // 删除缓存中的session和用户信息
        String sessionId = CookieUtil.getSessionId(request);
        Session session = (Session) redisService.getForString(sessionId);
        redisService.delete(sessionId);
        redisService.delete(session.getUserName());
        // 清除cookies中的session
        CookieUtil.clearSessionsFromCookies(request, response);
    }
}
