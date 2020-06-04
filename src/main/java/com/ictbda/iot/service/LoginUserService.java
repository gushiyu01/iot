package com.ictbda.iot.service;

import com.ictbda.iot.entity.LoginUser;
import java.util.List;

/**
 * (LoginUser)表服务接口
 *
 * @author makejava
 * @since 2020-06-03 13:54:42
 */
public interface LoginUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    LoginUser queryById(Long id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<LoginUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    LoginUser insert(LoginUser loginUser);

    /**
     * 修改数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    LoginUser update(LoginUser loginUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

}