package com.ictbda.iot.service.impl;

import com.ictbda.iot.entity.EFence;
import com.ictbda.iot.dao.EFenceDao;
import com.ictbda.iot.service.EFenceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 电子围栏表(EFence)表服务实现类
 *
 * @author makejava
 * @since 2020-06-09 10:16:34
 */
@Service("eFenceService")
public class EFenceServiceImpl implements EFenceService {
    @Resource
    private EFenceDao eFenceDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public EFence queryById(Long id) {
        return this.eFenceDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<EFence> queryAllByLimit(int offset, int limit) {
        return this.eFenceDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param eFence 实例对象
     * @return 实例对象
     */
    @Override
    public EFence insert(EFence eFence) {
        this.eFenceDao.insert(eFence);
        return eFence;
    }

    /**
     * 修改数据
     *
     * @param eFence 实例对象
     * @return 实例对象
     */
    @Override
    public EFence update(EFence eFence) {
        this.eFenceDao.update(eFence);
        return this.queryById(eFence.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.eFenceDao.deleteById(id) > 0;
    }

    /**
     * 根据使用者id查询其电子围栏信息
     * @param id
     * @return
     */
    @Override
    public List<EFence> queryByUserId(Long id){

        EFence eFence = new EFence ();
        eFence.setUserId (id);

        return this.eFenceDao.queryAll (eFence);
    }
}