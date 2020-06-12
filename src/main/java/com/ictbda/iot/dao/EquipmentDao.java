package com.ictbda.iot.dao;

import com.ictbda.iot.entity.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Equipment)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-09 11:02:52
 */
@Mapper
public interface EquipmentDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Equipment queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Equipment> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param equipment 实例对象
     * @return 对象列表
     */
    List<Equipment> queryAll(Equipment equipment);

    /**
     * 新增数据
     *
     * @param equipment 实例对象
     * @return 影响行数
     */
    int insert(Equipment equipment);

    /**
     * 修改数据
     *
     * @param equipment 实例对象
     * @return 影响行数
     */
    int update(Equipment equipment);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

}