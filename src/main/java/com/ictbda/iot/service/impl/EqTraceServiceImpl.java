package com.ictbda.iot.service.impl;

import com.ictbda.iot.entity.EqTrace;
import com.ictbda.iot.dao.EqTraceDao;
import com.ictbda.iot.service.EqTraceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * (EqTrace)表服务实现类
 *
 * @author makejava
 * @since 2020-06-10 14:04:55
 */
@Service("eqTraceService")
public class EqTraceServiceImpl implements EqTraceService {
    @Resource
    private EqTraceDao eqTraceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EqTrace queryById(Long id) {
        return this.eqTraceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EqTrace> queryAllByLimit(int offset, int limit) {
        return this.eqTraceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param eqTrace 实例对象
     * @return 实例对象
     */
    @Override
    public EqTrace insert(EqTrace eqTrace) {
        this.eqTraceDao.insert(eqTrace);
        return eqTrace;
    }

    /**
     * 修改数据
     *
     * @param eqTrace 实例对象
     * @return 实例对象
     */
    @Override
    public EqTrace update(EqTrace eqTrace) {

        this.eqTraceDao.update(eqTrace);
        return this.queryById(eqTrace.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.eqTraceDao.deleteById(id) > 0;
    }

    /**
     * 查询轨迹信息
     * @param map
     * @return
     */
    @Override
    public List<EqTrace> queryEqTraceByTime(HashMap<String, Object> map){

        return this.eqTraceDao.queryEqTraceByTime (map);
    }
}