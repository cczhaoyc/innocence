package com.suxia.innocence.common.util;

import com.suxia.innocence.common.constant.GlobalConstant;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月23 17:07 星期三
 * @description TODO cookie工具类
 */
public class CookieUtil {

    public static String getSessionId(HttpServletRequest request) {
        String sidFromCookies = getValueFromCookies(GlobalConstant.LOGIN_SESSION_ID, request);
        if (ValidationUtil.isEmptyString(sidFromCookies)) {
            return "";
        }
        return sidFromCookies;
    }

    private static String getValueFromCookies(String cookieName, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (!ValidationUtil.isEmptyArray(cookies)) {
            for (Cookie cookie : cookies) {
                if (cookieName.equals(cookie.getName())) {
                    return cookie.getValue();
                }
            }
        }
        return "";
    }

    /**
     * 在Cookie中存值
     *
     * @param request
     * @param response
     * @param cookieName
     * @param sessionId
     */
    public static void saveSessionIdInCookies(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                              String sessionId) {
        Cookie cookie = new Cookie(cookieName, sessionId);
        cookie.setPath("/");
        response.addCookie(cookie);
    }


    /**
     * 清除浏览器中带过来的原sessionId和oldSessionId
     *
     * @param request
     * @param response
     */
    public static void clearSessionsFromCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (!ValidationUtil.isEmptyArray(cookies)) {
            for (Cookie cookie : cookies) {
                if (!GlobalConstant.OLD_LOGIN_SESSION_ID.equals(cookie.getName())
                        && !GlobalConstant.LOGIN_SESSION_ID.equals(cookie.getName())) {
                    continue;
                }
                String sessionId = cookie.getValue();
                if (ValidationUtil.isEmptyString(sessionId)) {
                    continue;
                }
                Cookie newCookie = new Cookie(cookie.getName(), sessionId);
                newCookie.setMaxAge(0);// 如果设置为负值的话，则为浏览器进程Cookie(内存中保存)，关闭浏览器就失效；如果设置为0，则立即删除该Cookie。
                newCookie.setPath("/");
                response.addCookie(newCookie);
            }
        }
    }

}
