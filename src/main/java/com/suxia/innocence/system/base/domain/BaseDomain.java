package com.suxia.innocence.system.base.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author cczhaoyc@163.com
 * @version v_1.0.0
 * @date Created in 2019年01月08 14:15 星期二
 * @description TODO 基础实体类
 */
public class BaseDomain implements Serializable {

    private static final long serialVersionUID = -3825012647766102542L;

    private Long id;// 主键
    private String createUser;// 创建用户
    private Date createDate;// 创建日期
    private String updateUser;// 最后更新用户
    private Date updateDate;// 最后更新时间
    private String remark;// 备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDomain)) return false;
        BaseDomain that = (BaseDomain) o;
        return id.equals(that.id) &&
                createUser.equals(that.createUser) &&
                createDate.equals(that.createDate) &&
                updateUser.equals(that.updateUser) &&
                updateDate.equals(that.updateDate) &&
                remark.equals(that.remark);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createUser, createDate, updateUser, updateDate, remark);
    }

    @Override
    public String toString() {
        return "BaseDomain{" +
                "id=" + id +
                ", createUser='" + createUser + '\'' +
                ", createDate=" + createDate +
                ", updateUser='" + updateUser + '\'' +
                ", updateDate=" + updateDate +
                ", remark='" + remark + '\'' +
                '}';
    }
}
