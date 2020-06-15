package com.ictbda.iot.service.impl;

import com.alibaba.fastjson.JSONObject;
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
     * @param request
     */
    @Override
    public void judgeRange(EqTrace eqTrace){

        EFence eFence = new EFence ();
        eFence.setUserId (useUserDao.selectUseUserIdByEquipmentId (eqTrace.getEquipmentId ()));

    }
}
