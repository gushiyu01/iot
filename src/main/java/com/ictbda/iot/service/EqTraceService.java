package com.ictbda.iot.service;

import com.ictbda.iot.entity.EqTrace;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * (EqTrace)表服务接口
 *
 * @author makejava
 * @since 2020-06-10 14:04:54
 */
public interface EqTraceService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    EqTrace queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<EqTrace> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param eqTrace 实例对象
     * @return 实例对象
     */
    EqTrace insert(EqTrace eqTrace);

    /**
     * 修改数据
     *
     * @param eqTrace 实例对象
     * @return 实例对象
     */
    EqTrace update(EqTrace eqTrace);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 按照起止时间查询轨迹
     * @param s
     * @param e
     * @return
     */
    List<EqTrace> queryEqTraceByTime(HashMap<String, Object> map);

}