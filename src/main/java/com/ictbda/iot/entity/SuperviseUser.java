package com.ictbda.iot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 监管人员信息表(SuperviseUser)实体类
 *
 * @author makejava
 * @since 2020-06-09 11:42:05
 */
public class SuperviseUser implements Serializable {
    private static final long serialVersionUID = 543200478722096294L;
    /**
    * id
    */
    private Long id;
    /**
    * 监管人员姓名
    */
    private String name;
    /**
    * 联系电话
    */
    private String phone;
    /**
    * 职位
    */
    private String position;
    /**
    * 所属单位
    */
    private String company;
    /**
    * 删除标识1、未删除，2、已删除
    */
    private Integer delFlag;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 创建者id
    */
    private Long createUserId;
    /**
    * 修改者id
    */
    private Long updateUserId;
    /**
    * 系统登录用户id
    */
    private Long loginUserId;

    /**
     * 监管人员id
     */
    private String superviseId;

    public String getSuperviseId() {
        return superviseId;
    }

    public void setSuperviseId(String superviseId) {
        this.superviseId = superviseId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public Long getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(Long loginUserId) {
        this.loginUserId = loginUserId;
    }

}