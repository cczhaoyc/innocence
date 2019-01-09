package com.suxia.innocence.system.sys.service;

import com.suxia.innocence.system.exception.base.ServiceValidationException;
import com.suxia.innocence.system.sys.domain.SysUser;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 15:13 星期二
 * @description TODO 用户表顶级业务接口
 */
public interface SysUserService {


    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    SysUser addSysUser(SysUser sysUser);


    /**
     * 更新用户
     *
     * @param sysUser
     * @return
     */
    SysUser updateSysUser(SysUser sysUser) throws ServiceValidationException;


    /**
     * 根据id数组删除一个或多个用户
     *
     * @param ids
     * @return
     */
    Boolean deleteSysUsers(Long[] ids);

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    SysUser getSysUserById(Long id);
}
