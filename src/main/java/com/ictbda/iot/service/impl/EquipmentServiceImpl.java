package com.ictbda.iot.service.impl;

import com.ictbda.iot.entity.Equipment;
import com.ictbda.iot.dao.EquipmentDao;
import com.ictbda.iot.service.EquipmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * (Equipment)表服务实现类
 *
 * @author makejava
 * @since 2020-06-09 11:02:52
 */
@Service("equipmentService")
public class EquipmentServiceImpl implements EquipmentService {
    @Resource
    private EquipmentDao equipmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Equipment queryById(Long id) {
        return this.equipmentDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Equipment> queryAllByLimit(int offset, int limit) {
        return this.equipmentDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    @Override
    public Equipment insert(Equipment equipment) {
        List<Equipment> list = this.equipmentDao.queryAll (equipment);
        if ( list.size () > 0 ){
            equipment.setId (0L);
            return equipment;
        } else {
            this.equipmentDao.insert(equipment);
            return equipment;
        }

    }

    /**
     * 修改数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    @Override
    public Equipment update(Equipment equipment) {
        equipment.setUpdateTime (new Date ());
        this.equipmentDao.update(equipment);
        return this.queryById(equipment.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.equipmentDao.deleteById(id) > 0;
    }

    /**
     * 查询list
     * @param equipment
     * @return
     */
    @Override
    public List<Equipment> queryAll(Equipment equipment){

        equipment.setDelFlag (1);
        List<Equipment> l = this.equipmentDao.queryAll (equipment);

        return l;
    }
}