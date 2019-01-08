package com.suxia.innocence.system.sys.domain;

import com.suxia.innocence.system.base.domain.BaseDomain;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 14:13 星期二
 * @description TODO 用户表
 */
public class SysUser extends BaseDomain {

    private static final long serialVersionUID = -8568123986341531490L;

    private String userName;// 登录用户名
    private String nickName;// 用户昵称
    private String password;// 加密密码
    private String mobile;// 联系方式
    private Boolean administrator;// 是否超级管理员（0 否，1 是）


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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Boolean getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Boolean administrator) {
        this.administrator = administrator;
    }
}
