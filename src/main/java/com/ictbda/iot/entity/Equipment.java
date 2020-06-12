package com.ictbda.iot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (Equipment)实体类
 *
 * @author makejava
 * @since 2020-06-10 14:35:56
 */
public class Equipment implements Serializable {
    private static final long serialVersionUID = 484294567480869854L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 设备编码
    */
    private String equipmentId;
    /**
    * 设备名称
    */
    private String equName;
    /**
    * 设备型号
    */
    private String equType;
    /**
    * 设备电量
    */
    private String equBattery;
    /**
    * 设备信号
    */
    private String equSignal;
    /**
    * 1、在线，2、离线
    */
    private Integer equStatus;
    /**
    * 1、已绑定，2、未绑定
    */
    private Integer bindingStatus;
    /**
    * 设备添加时间
    */
    private Date createTime;
    /**
    * 设备删除标识
    */
    private Integer delFlag;
    /**
    * 系统登录用户id
    */
    private Long loginUserId;
    /**
    * 设备更新时间
    */
    private Date updateTime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquName() {
        return equName;
    }

    public void setEquName(String equName) {
        this.equName = equName;
    }

    public String getEquType() {
        return equType;
    }

    public void setEquType(String equType) {
        this.equType = equType;
    }

    public String getEquBattery() {
        return equBattery;
    }

    public void setEquBattery(String equBattery) {
        this.equBattery = equBattery;
    }

    public String getEquSignal() {
        return equSignal;
    }

    public void setEquSignal(String equSignal) {
        this.equSignal = equSignal;
    }

    public Integer getEquStatus() {
        return equStatus;
    }

    public void setEquStatus(Integer equStatus) {
        this.equStatus = equStatus;
    }

    public Integer getBindingStatus() {
        return bindingStatus;
    }

    public void setBindingStatus(Integer bindingStatus) {
        this.bindingStatus = bindingStatus;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Long getLoginUserId() {
        return loginUserId;
    }

    public void setLoginUserId(Long loginUserId) {
        this.loginUserId = loginUserId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

}