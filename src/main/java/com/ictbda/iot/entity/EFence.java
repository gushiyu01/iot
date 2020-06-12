package com.ictbda.iot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * 电子围栏表(EFence)实体类
 *
 * @author makejava
 * @since 2020-06-09 11:43:51
 */
public class EFence implements Serializable {
    private static final long serialVersionUID = -81110546467358514L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 创建者id
    */
    private Long createUserId;
    /**
    * 创建时间
    */
    private Date createTime;
    /**
    * 修改时间
    */
    private Date updateTime;
    /**
    * 修改者id
    */
    private Long updateUserId;
    /**
    * 设备id
    */
    private String equipmentId;
    /**
    * 围栏类型1、圆，2、多边形，3、特定区域
    */
    private Integer fenceType;
    /**
    * 经度119.666666
    */
    private Double lng;
    /**
    * 纬度119.666666
    */
    private Double lat;
    /**
    * 半径精确到(m)
    */
    private Integer radius;
    /**
    * 区域编码
    */
    private Integer areaCode;
    /**
    * 区域名称
    */
    private String areaName;
    /**
    * 街道名称
    */
    private String areaLevel;
    /**
    * 使用者id
    */
    private Long userId;
    /**
    * 删除标识1、未删除，2、已删除
    */
    private Integer delFlag;
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

    public Long getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
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

    public Long getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(Long updateUserId) {
        this.updateUserId = updateUserId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getFenceType() {
        return fenceType;
    }

    public void setFenceType(Integer fenceType) {
        this.fenceType = fenceType;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Integer getRadius() {
        return radius;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public Integer getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(Integer areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaLevel() {
        return areaLevel;
    }

    public void setAreaLevel(String areaLevel) {
        this.areaLevel = areaLevel;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

}