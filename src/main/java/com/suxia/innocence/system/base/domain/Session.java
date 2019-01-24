package com.suxia.innocence.system.base.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月23 14:48 星期三
 * @description TODO 用户登录状态的Session信息实体类
 */
public class Session implements Serializable {

    private static final long serialVersionUID = -5435489772833682064L;

    private Long id;
    private Long sysUserId;
    private String userName;
    private String nickName;
    private String validateCode;
    private String sessionId;
    private Boolean login;
    private String accessIp;
    private Date accessTime;
    private String loginIp;
    private Date loginDate;
    private String lastUrl;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSysUserId() {
        return sysUserId;
    }

    public void setSysUserId(Long sysUserId) {
        this.sysUserId = sysUserId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public Boolean getLogin() {
        return login;
    }

    public void setLogin(Boolean login) {
        this.login = login;
    }

    public String getAccessIp() {
        return accessIp;
    }

    public void setAccessIp(String accessIp) {
        this.accessIp = accessIp;
    }

    public Date getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLastUrl() {
        return lastUrl;
    }

    public void setLastUrl(String lastUrl) {
        this.lastUrl = lastUrl;
    }

    @Override
    public String toString() {
        return "Session{" +
                "id=" + id +
                ", sysUserId=" + sysUserId +
                ", userName='" + userName + '\'' +
                ", nickName='" + nickName + '\'' +
                ", validateCode='" + validateCode + '\'' +
                ", sessionId='" + sessionId + '\'' +
                ", login=" + login +
                ", accessIp='" + accessIp + '\'' +
                ", accessTime=" + accessTime +
                ", loginIp='" + loginIp + '\'' +
                ", loginDate=" + loginDate +
                ", lastUrl='" + lastUrl + '\'' +
                '}';
    }
}
