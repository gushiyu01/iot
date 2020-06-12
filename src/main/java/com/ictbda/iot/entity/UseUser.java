package com.ictbda.iot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 设备穿戴人员信息表(UseUser)实体类
 *
 * @author makejava
 * @since 2020-06-09 11:41:28
 */
public class UseUser implements Serializable {
    private static final long serialVersionUID = 349754921631673720L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 使用者姓名
    */
    private String name;
    /**
    * 1、男，2、女
    */
    private Integer gender;
    /**
    * 年龄
    */
    private Integer age;
    /**
    * 电话
    */
    private String phone;
    /**
    * 照片地址
    */
    private String picUrl;
    /**
    * 家庭住址
    */
    private String address;
    /**
    * 办案单位
    */
    private String dealDepartment;
    /**
    * 审批单位
    */
    private String approvalDepartment;
    /**
    * 罪名
    */
    private String charge;
    /**
    * 取保候审或监视居住措施
    */
    private String status;
    /**
    * 1、是前科人员，2、不是前科人员
    */
    private Integer isCriminal;
    /**
    * 开始服刑时间
    */
    private Date startTime;
    /**
    * 结束服刑时间
    */
    private Date endTime;
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
    * 创建人名称
    */
    private String createUserName;
    /**
    * 设备id
    */
    private Long equipmentId;
    /**
    * 监管人员id
    */
    private Long superviseId;
    /**
    * 系统登录用户id
    */
    private Long loginUserId;


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

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDealDepartment() {
        return dealDepartment;
    }

    public void setDealDepartment(String dealDepartment) {
        this.dealDepartment = dealDepartment;
    }

    public String getApprovalDepartment() {
        return approvalDepartment;
    }

    public void setApprovalDepartment(String approvalDepartment) {
        this.approvalDepartment = approvalDepartment;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getIsCriminal() {
        return isCriminal;
    }

    public void setIsCriminal(Integer isCriminal) {
        this.isCriminal = isCriminal;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
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

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    public Long getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Long equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getSuperviseId() {
        return superviseId;
    }

    public void setSuperviseId(Long superviseId) {
        this.superviseId = superviseId;
    }

    public Long getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(Long loginUserId) {
        this.loginUserId = loginUserId;
    }

}