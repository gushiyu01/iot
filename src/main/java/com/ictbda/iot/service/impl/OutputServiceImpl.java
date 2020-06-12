package com.ictbda.iot.service.impl;

import com.ictbda.iot.dao.EqTraceDao;
import com.ictbda.iot.dao.EquipmentDao;
import com.ictbda.iot.dao.UseUserDao;
import com.ictbda.iot.entity.EqTrace;
import com.ictbda.iot.entity.Equipment;
import com.ictbda.iot.service.OutputService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/6/10 14:24
 * @Description:
 */
@Service("outputService")
public class OutputServiceImpl implements OutputService {

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
}
