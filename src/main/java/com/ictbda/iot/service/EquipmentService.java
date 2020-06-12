package com.ictbda.iot.service;

import com.ictbda.iot.entity.Equipment;
import java.util.List;

/**
 * (Equipment)表服务接口
 *
 * @author makejava
 * @since 2020-06-09 11:02:52
 */
public interface EquipmentService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Equipment queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Equipment> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    Equipment insert(Equipment equipment);

    /**
     * 修改数据
     *
     * @param equipment 实例对象
     * @return 实例对象
     */
    Equipment update(Equipment equipment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询list
     * @param equipment
     * @return
     */
    List<Equipment> queryAll(Equipment equipment);
}