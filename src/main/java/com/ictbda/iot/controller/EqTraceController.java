package com.ictbda.iot.controller;

import com.ictbda.iot.entity.EqTrace;
import com.ictbda.iot.entity.Output;
import com.ictbda.iot.service.EqTraceService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * (EqTrace)表控制层
 *
 * @author makejava
 * @since 2020-06-10 14:04:55
 */
@RestController
@RequestMapping("/iot-api/eqTrace")
public class EqTraceController {
    /**
     * 服务对象
     */
    @Resource
    private EqTraceService eqTraceService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public EqTrace selectOne(Long id) {
        return this.eqTraceService.queryById(id);
    }

    /**
     * 查询起止时间内的轨迹信息
     * @param startTime
     * @param endTime
     * @param equipmentId
     * @param useUserId
     * @return
     */
    @GetMapping("queryEqTraceByTime")
    public Output queryEqTraceByTime(Date startTime, Date endTime, String equipmentId, String useUserId){

        HashMap<String, Object> map = new HashMap<> ();
        map.put ("startTime", startTime);
        map.put ("endTime", endTime);
        map.put ("equipmentId", equipmentId);
        map.put ("useUserId", useUserId);

        List<EqTrace> eqTraceList = eqTraceService.queryEqTraceByTime (map);

        return Output.ok ("查询成功！", eqTraceList);
    }

}