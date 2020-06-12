package com.ictbda.iot.service.impl;

import com.ictbda.iot.entity.UseUser;
import com.ictbda.iot.dao.UseUserDao;
import com.ictbda.iot.service.UseUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 设备穿戴人员信息表(UseUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-09 11:41:31
 */
@Service("useUserService")
public class UseUserServiceImpl implements UseUserService {
    @Resource
    private UseUserDao useUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UseUser queryById(Long id) {
        return this.useUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<UseUser> queryAllByLimit(int offset, int limit) {
        return this.useUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param useUser 实例对象
     * @return 实例对象
     */
    @Override
    public UseUser insert(UseUser useUser) {
        this.useUserDao.insert(useUser);
        return useUser;
    }

    /**
     * 修改数据
     *
     * @param useUser 实例对象
     * @return 实例对象
     */
    @Override
    public UseUser update(UseUser useUser) {
        useUser.setUpdateTime (new Date ());
        this.useUserDao.update(useUser);
        return this.queryById(useUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.useUserDao.deleteById(id) > 0;
    }

    /**
     * 查询list
     * @param useUser
     * @return
     */
    @Override
    public List<UseUser> queryAll(UseUser useUser){
        useUser.setDelFlag (1);
        return this.useUserDao.queryAll (useUser);
    }
}