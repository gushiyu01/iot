package com.ictbda.iot.entity;

import java.util.Date;
import java.io.Serializable;

/**
 * (EqTrace)实体类
 *
 * @author makejava
 * @since 2020-06-10 14:04:52
 */
public class EqTrace implements Serializable {
    private static final long serialVersionUID = -11876666411944730L;
    /**
    * 主键id
    */
    private Long id;
    /**
    * 纬度
    */
    private Double lng;
    /**
    * 经度
    */
    private Double lat;
    /**
    * 设备数据采集时间
    */
    private Date dataPushTime;
    /**
    * 数据创建时间
    */
    private Date createTime;
    /**
    * 数据采集方式5、WiFi，16、gps
    */
    private Integer type;
    /**
    * 设备id
    */
    private String equipmentId;
    /**
    * 使用者id
    */
    private Long useUserId;
    /**
    * 数据删除标识1、未删除，2、已删除
    */
    private Integer delFlag;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDataPushTime() {
        return dataPushTime;
    }

    public void setDataPushTime(Date dataPushTime) {
        this.dataPushTime = dataPushTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Long getUseUserId() {
        return useUserId;
    }

    public void setUseUserId(Long useUserId) {
        this.useUserId = useUserId;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

}