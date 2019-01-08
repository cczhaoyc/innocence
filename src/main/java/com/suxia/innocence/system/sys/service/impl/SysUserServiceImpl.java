package com.suxia.innocence.system.sys.service.impl;

import com.suxia.innocence.system.sys.domain.SysUser;
import com.suxia.innocence.system.sys.mapper.SysUserMapper;
import com.suxia.innocence.system.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 15:13 星期二
 * @description TODO 用户表顶级业务接口实现
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser addSysUser(SysUser sysUser) {
        return null;
    }

    @Override
    public SysUser updateSysUser(SysUser sysUser) {
        return null;
    }

    @Override
    public Boolean deleteSysUsers(Long[] ids) {
        return null;
    }

    @Override
    public SysUser getSysUserById(Long id) {
        return null;
    }
}
