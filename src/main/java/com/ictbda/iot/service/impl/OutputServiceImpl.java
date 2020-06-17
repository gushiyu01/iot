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
import com.ictbda.iot.utils.HttpUtils;
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
    public void judgeRange(EqTrace eqTrace){

        EFence eFence = new EFence ();
        eFence.setUserId (useUserDao.selectUseUserIdByEquipmentId (eqTrace.getEquipmentId ()));
        eFence.setDelFlag (1);
        List<EFence> eFences = eFenceDao.queryAll (eFence);
        if(eFences.size ()>0){
            if ( eFences.get (0).getFenceType () == 1 ){

            } else if (eFences.get (0).getFenceType () == 1) {

            } else if (eFences.get (0).getFenceType () == 1) {

            }
        }

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
