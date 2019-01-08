package com.suxia.innocence.system.sys.mapper;

import com.suxia.innocence.system.sys.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 14:42 星期二
 * @description TODO 用户表顶级映射器
 */
@Mapper
public interface SysUserMapper {

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    Integer addSysUser(SysUser sysUser);


    /**
     * 更新用户
     *
     * @param sysUser
     * @return
     */
    Integer updateSysUser(SysUser sysUser);


    /**
     * 根据id数组删除一个或多个用户
     *
     * @param ids
     * @return
     */
    Integer deleteSysUsers(Long[] ids);

    /**
     * 根据id获取用户
     *
     * @param id
     * @return
     */
    SysUser getSysUserById(Long id);
}
