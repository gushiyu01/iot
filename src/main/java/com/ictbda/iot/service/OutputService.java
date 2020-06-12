package com.ictbda.iot.service;

import com.ictbda.iot.entity.EqTrace;
import com.ictbda.iot.entity.Equipment;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/6/10 14:26
 * @Description:
 */
public interface OutputService {

    /**
     * 处理GPS数据
     * @param eqTrace
     */
    void dealGPSData(EqTrace eqTrace);

    /**
     * 处理WiFi数据
     * @param eqTrace
     */
    void dealWIFIData(EqTrace eqTrace);

    /**
     * 处理电池数据
     * @param eqTrace
     */
    void dealBatteryData(Equipment equipment);
}
