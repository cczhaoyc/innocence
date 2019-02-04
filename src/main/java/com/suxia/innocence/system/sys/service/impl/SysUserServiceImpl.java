package com.suxia.innocence.system.sys.service.impl;

import com.suxia.innocence.common.util.ValidationUtil;
import com.suxia.innocence.system.base.rabbitmq.producer.MessageSender;
import com.suxia.innocence.system.exception.base.BusinessValidationException;
import com.suxia.innocence.system.exception.base.ServiceValidationException;
import com.suxia.innocence.system.sys.constant.SysUserConstant;
import com.suxia.innocence.system.sys.domain.SysUser;
import com.suxia.innocence.system.sys.mapper.SysUserMapper;
import com.suxia.innocence.system.sys.service.SysUserService;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 15:13 星期二
 * @description TODO 用户表顶级业务接口实现
 */
@Service("sysUserService")
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.DEFAULT)
// REQUIRED:如果当前存在事务，则加入该事务；如果当前没有事务，则创建一个新的事务。
// DEFAULT:这是默认值，表示使用底层数据库的默认隔离级别。对大部分数据库而言，通常这值就是： READ_COMMITTED 。
// READ_COMMITTED:该隔离级别表示一个事务只能读取另一个事务已经提交的数据。该级别可以防止脏读，这也是大多数情况下的推荐值。
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;
    @Autowired
    private MessageSender messageSender;

    @Override
    public SysUser addSysUser(SysUser sysUser) {
        if (sysUser == null) {
            throw new BusinessValidationException("参数为空");
        }
        if (ValidationUtil.isEmptyString(sysUser.getUserName())) {
            throw new BusinessValidationException("参数登录用户名为空");
        }
        if (ValidationUtil.isEmptyString(sysUser.getPassword())) {
            throw new BusinessValidationException("参数密码为空");
        }
        try {
            sysUser.setCreateUser("admin");
            sysUser.setCreateDate(new Date());
            // 对密码加密保存
            String hashpw = BCrypt.hashpw(sysUser.getPassword(), BCrypt.gensalt(SysUserConstant.GENSALT_DEFAULT_ROUNDS));
            sysUser.setPassword(hashpw);
            sysUserMapper.addSysUser(sysUser);
            messageSender.send(sysUser);// 发送消息
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

    @Override
    public SysUser getSysUserByUserName(String userName) {
        if (ValidationUtil.isEmptyString(userName)) {
            throw new BusinessValidationException("参数登录用户名为空");
        }
        try {
            return sysUserMapper.getSysUserByUserName(userName);
        } catch (Exception e) {
            throw new ServiceValidationException("根据用户名获取用户信息出错!", e);
        }
    }
}
