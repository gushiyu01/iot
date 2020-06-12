package com.ictbda.iot.service;

import com.ictbda.iot.entity.UseUser;
import java.util.List;

/**
 * 设备穿戴人员信息表(UseUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-09 11:41:30
 */
public interface UseUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UseUser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<UseUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param useUser 实例对象
     * @return 实例对象
     */
    UseUser insert(UseUser useUser);

    /**
     * 修改数据
     *
     * @param useUser 实例对象
     * @return 实例对象
     */
    UseUser update(UseUser useUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询list
     * @param useUser
     * @return
     */
    List<UseUser> queryAll(UseUser useUser);
}