package com.suxia.innocence.system.sys.constant;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 15:18 星期二
 * @description TODO 用户表业务相关常量
 */
public interface SysUserConstant {

    /**
     * 是否超级管理员（0 否，1 是）
     */
    Boolean IS_ADMINISTRATOR = Boolean.TRUE;
    Boolean NOT_ADMINISTRATOR = Boolean.FALSE;

    // 定义加密密码计算强度
    Integer GENSALT_DEFAULT_ROUNDS = 10;
}
