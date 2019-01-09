package com.suxia.innocence.common.util;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月09 16:04 星期三
 * @description TODO
 */
public class ValidationUtil {

    public static Boolean isEmpty(String parameter) {
        if (null == parameter || "".equals(parameter.trim())) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

}
