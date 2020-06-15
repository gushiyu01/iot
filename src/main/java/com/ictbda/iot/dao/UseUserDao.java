package com.ictbda.iot.dao;

import com.ictbda.iot.entity.UseUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 设备穿戴人员信息表(UseUser)表数据库访问层
 *
 * @author makejava
 * @since 2020-06-09 11:41:29
 */
@Mapper
public interface UseUserDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UseUser queryById(Long id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UseUser> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param useUser 实例对象
     * @return 对象列表
     */
    List<UseUser> queryAll(UseUser useUser);

    /**
     * 新增数据
     *
     * @param useUser 实例对象
     * @return 影响行数
     */
    int insert(UseUser useUser);

    /**
     * 修改数据
     *
     * @param useUser 实例对象
     * @return 影响行数
     */
    int update(UseUser useUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Long id);

    /**
     * 根据设备code，查询使用人员主键id
     * @param equipmentId
     * @return
     */
    Long selectUseUserIdByEquipmentId(String equipmentId);

}