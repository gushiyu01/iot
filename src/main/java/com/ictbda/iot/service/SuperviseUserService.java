package com.ictbda.iot.service;

import com.ictbda.iot.entity.SuperviseUser;
import java.util.List;

/**
 * 监管人员信息表(SuperviseUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-09 10:16:10
 */
public interface SuperviseUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SuperviseUser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<SuperviseUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param superviseUser 实例对象
     * @return 实例对象
     */
    SuperviseUser insert(SuperviseUser superviseUser);

    /**
     * 修改数据
     *
     * @param superviseUser 实例对象
     * @return 实例对象
     */
    SuperviseUser update(SuperviseUser superviseUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    /**
     * 查询监管人员
     * @param superviseUser
     * @return
     */
    List<SuperviseUser> queryAll(SuperviseUser superviseUser);
}