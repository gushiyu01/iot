package com.ictbda.iot.controller;

import com.ictbda.iot.entity.EqTrace;
import com.ictbda.iot.entity.Equipment;
import com.ictbda.iot.service.OutputService;
import com.ictbda.iot.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.logging.Logger;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/6/9 15:32
 * @Description: 接收数据接口
 */
@RestController
@RequestMapping("/ictbda")
public class OutputController {

    Logger logger = Logger.getLogger ("OutputController");

    @Autowired
    OutputService outputService;

    @PostMapping("/sendData")
    public void getData(HttpServletRequest request) {

        String type = request.getParameter ("type");
        switch (type) {
            case "16":
                getGPSData (request);
                break;
            case "5":
                getWIFIData (request);
                break;
            case "30":
                getBatteryData (request);
                break;
            default:
                logger.warning ("无此类型数据");
        }


        Enumeration<String> parameterNames = request.getParameterNames ( );
        while (parameterNames.hasMoreElements ( )) {
            String s = parameterNames.nextElement ( );
            logger.info ("手环远程上传参数-" + s + ":" + request.getParameter (s));
        }

    }

    /**
     * GPS定位数据
     * 	BTUtcTime	数据推送的utc时间 格式为: 2018-12-19 04:21:46
     * 	IMEI		设备唯一标识
     * 	type		16代表是GPS数据|
     * 	latStr		Gps维度
     * 	lngStr		Gps经度
     * 	speedStr	速度
     * 	dataContext	设备暂时没传，所以为空
     * 	distance	设备传的为0所以固定为0
     *
     * wifi定位数据
     * 	IMEI		设备的唯一标识imei号
     * 	timeStr		时间(格式：2018-12-19 04:21:46)
     * 	Latitude	高德坐标系纬度
     * 	Longitude	高德坐标系经度
     * 	type		5代表wifi数据类型值
     *
     * 电池电量数据
     * 	BTUtcTime	数据推送的utc时间格式: 2018-12-19 04:21:46
     * 	IMEI		设备的唯一标识imei号
     * 	type		30代表是电池电量数据
     * 	signal		信号值
     * 	battery		电池电量的百分比
     */

    /**
     * 获取WiFi定位数据
     *
     * @param request
     */
    private void getWIFIData(HttpServletRequest request) {
        String IMEI = request.getParameter ("IMEI");
        String timeStr = request.getParameter ("timeStr");
        String Latitude = request.getParameter ("Latitude");
        String Longitude = request.getParameter ("Longitude");

        EqTrace eqTrace = new EqTrace ();
        eqTrace.setDataPushTime (DateUtils.utcToBeijing (DateUtils.parseDate (timeStr, DateUtils.PATTERN_ONE)));
        eqTrace.setEquipmentId (IMEI);
        eqTrace.setLat (Double.parseDouble (Latitude));
        eqTrace.setLng (Double.parseDouble (Longitude));

        outputService.dealWIFIData (eqTrace);
    }

    /**
     * 获取GPS定位数据
     *
     * @param request
     */
    private void getGPSData(HttpServletRequest request) {
        String BTUtcTime = request.getParameter ("BTUtcTime");
        String IMEI = request.getParameter ("IMEI");
        String latStr = request.getParameter ("latStr");
        String lngStr = request.getParameter ("lngStr");
        //未使用
        String speedStr = request.getParameter ("speedStr");
        //未使用
        String dataContext = request.getParameter ("dataContext");
        //未使用
        String distance = request.getParameter ("distance");

        EqTrace eqTrace = new EqTrace ();
        eqTrace.setDataPushTime (DateUtils.utcToBeijing (DateUtils.parseDate (BTUtcTime, DateUtils.PATTERN_ONE)));
        eqTrace.setEquipmentId (IMEI);
        eqTrace.setLat (Double.parseDouble (latStr));
        eqTrace.setLng (Double.parseDouble (lngStr));
        outputService.dealGPSData (eqTrace);
    }

    /**
     * 获取电池电量定位数据
     *
     * @param request
     */
    private void getBatteryData(HttpServletRequest request) {
        String BTUtcTime = request.getParameter ("BTUtcTime");
        String IMEI = request.getParameter ("IMEI");
        String signal = request.getParameter ("signal");
        String battery = request.getParameter ("battery");

        Equipment equipment = new Equipment ();
        equipment.setEquSignal (signal);
        equipment.setEquBattery (battery);
        equipment.setEquipmentId (IMEI);
        equipment.setUpdateTime (DateUtils.utcToBeijing (DateUtils.parseDate (BTUtcTime, DateUtils.PATTERN_ONE)));
        outputService.dealBatteryData (equipment);
    }
}
