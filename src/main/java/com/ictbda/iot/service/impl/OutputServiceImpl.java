package com.ictbda.iot.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ictbda.iot.dao.EFenceDao;
import com.ictbda.iot.dao.EqTraceDao;
import com.ictbda.iot.dao.EquipmentDao;
import com.ictbda.iot.dao.UseUserDao;
import com.ictbda.iot.entity.EFence;
import com.ictbda.iot.entity.EqTrace;
import com.ictbda.iot.entity.Equipment;
import com.ictbda.iot.service.OutputService;
import com.ictbda.iot.utils.CoordinateTransformUtil;
import com.ictbda.iot.utils.EFenceUtils;
import com.ictbda.iot.utils.HttpUtils;
import com.sun.org.apache.xpath.internal.operations.Bool;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/6/10 14:24
 * @Description:
 */
@Service("outputService")
public class OutputServiceImpl implements OutputService {

    private static final String CODE = "0b86e6c70aa11dfb95bee71e394dc2a9";

    @Resource
    UseUserDao useUserDao;

    @Resource
    EqTraceDao eqTraceDao;

    @Resource
    EquipmentDao equipmentDao;

    @Resource
    EFenceDao eFenceDao;

    @Override
    public void dealGPSData(EqTrace eqTrace) {
        Long useUserId = useUserDao.selectUseUserIdByEquipmentId (eqTrace.getEquipmentId ());
        eqTrace.setUseUserId (useUserId);
        eqTrace.setType (16);

        String s = HttpUtils.doGet ("https://restapi.amap.com/v3/geocode/regeo?key=" + CODE + "&location=" + eqTrace.getLng ( ) + "," + eqTrace.getLat ( ));
        JSONObject jsonObject = JSONObject.parseObject (s);

        eqTraceDao.insert (eqTrace);
    }

    @Override
    public void dealWIFIData(EqTrace eqTrace) {
        Long useUserId = useUserDao.selectUseUserIdByEquipmentId (eqTrace.getEquipmentId ());
        eqTrace.setUseUserId (useUserId);
        eqTrace.setType (5);
        eqTraceDao.insert (eqTrace);
    }

    @Override
    public void dealBatteryData(Equipment equipment) {
        equipmentDao.update (equipment);
    }

    /**
     * 判断是否在范围之内
     * @param eqTrace
     */
    @Override
    public boolean judgeRange(EqTrace eqTrace){

        EFence eFence = new EFence ();
        eFence.setUserId (useUserDao.selectUseUserIdByEquipmentId (eqTrace.getEquipmentId ()));
        eFence.setDelFlag (1);
        List<EFence> eFences = eFenceDao.queryAll (eFence);
        boolean b = false;
        if(eFences.size ()>0){
            EFence fence = eFences.get (0);
            // 圆
            if ( eFences.get (0).getFenceType () == 1 ){
                // 装换为火星坐标 double lng, double lat
                double[] d1 = CoordinateTransformUtil.gcj02towgs84 (fence.getLng (), fence.getLat ());
                double[] d2 = CoordinateTransformUtil.gcj02towgs84 (eqTrace.getLng ( ), eqTrace.getLat ( ));
                // double radius, double lat1, double lng1, double lat2, double lng2
                b = EFenceUtils.isInCircle (fence.getRadius ( ), d1[1], d1[0], d2[1], d2[0]);

                // 多边形
            } else if (eFences.get (0).getFenceType () == 2) {


                // 特定区域
            } else if (eFences.get (0).getFenceType () == 3) {

            }
        }

        return b;

    }

    /**
     * 圆形判断
     * @return
     */
    private boolean circleFence(){

        return true;
    }

    /**
     * 多边形判断
     * @return
     */
    private boolean polygonFence(){

        return true;
    }

    /**
     * 指定区域判断
     * @return
     */
    private boolean specialFence(){

        return true;
    }

}
