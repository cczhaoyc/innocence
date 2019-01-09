package com.suxia.innocence.system.sys.service.impl;

import com.suxia.innocence.common.util.ValidationUtil;
import com.suxia.innocence.system.exception.base.BusinessValidationException;
import com.suxia.innocence.system.exception.base.ServiceValidationException;
import com.suxia.innocence.system.sys.domain.SysUser;
import com.suxia.innocence.system.sys.mapper.SysUserMapper;
import com.suxia.innocence.system.sys.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.print.attribute.standard.ReferenceUriSchemesSupported;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 15:13 星期二
 * @description TODO 用户表顶级业务接口实现
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser addSysUser(SysUser sysUser) {
        if (sysUser == null) {
            throw new BusinessValidationException("参数为空");
        }
        if (ValidationUtil.isEmpty(sysUser.getUserName())) {
            throw new BusinessValidationException("参数登录用户名为空");
        }
        if (ValidationUtil.isEmpty(sysUser.getPassword())) {
            throw new BusinessValidationException("参数密码为空");
        }
        try {
            sysUserMapper.addSysUser(sysUser);
            return sysUser;
        } catch (Exception e) {
            throw new ServiceValidationException("新增用户出错!", e);
        }
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
