package com.ictbda.iot.service.impl;

import com.ictbda.iot.entity.SuperviseUser;
import com.ictbda.iot.dao.SuperviseUserDao;
import com.ictbda.iot.service.SuperviseUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 监管人员信息表(SuperviseUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-09 10:16:10
 */
@Service("superviseUserService")
public class SuperviseUserServiceImpl implements SuperviseUserService {
    @Resource
    private SuperviseUserDao superviseUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SuperviseUser queryById(Long id) {
        return this.superviseUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<SuperviseUser> queryAllByLimit(int offset, int limit) {
        return this.superviseUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param superviseUser 实例对象
     * @return 实例对象
     */
    @Override
    public SuperviseUser insert(SuperviseUser superviseUser) {
        this.superviseUserDao.insert(superviseUser);
        return superviseUser;
    }

    /**
     * 修改数据
     *
     * @param superviseUser 实例对象
     * @return 实例对象
     */
    @Override
    public SuperviseUser update(SuperviseUser superviseUser) {
        superviseUser.setUpdateTime (new Date ());
        this.superviseUserDao.update(superviseUser);
        return this.queryById(superviseUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.superviseUserDao.deleteById(id) > 0;
    }

    /**
     * 查询监管人员
     * @param superviseUser
     * @return
     */
    @Override
    public List<SuperviseUser> queryAll(SuperviseUser superviseUser){
        superviseUser.setDelFlag (1);
        return this.superviseUserDao.queryAll (superviseUser);
    }
}