package com.ictbda.iot.service.impl;

import com.ictbda.iot.entity.LoginUser;
import com.ictbda.iot.dao.LoginUserDao;
import com.ictbda.iot.service.LoginUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (LoginUser)表服务实现类
 *
 * @author makejava
 * @since 2020-06-03 13:54:43
 */
@Service("loginUserService")
public class LoginUserServiceImpl implements LoginUserService {
    @Resource
    private LoginUserDao loginUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public LoginUser queryById(Long id) {
        return this.loginUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<LoginUser> queryAllByLimit(int offset, int limit) {
        return this.loginUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    @Override
    public LoginUser insert(LoginUser loginUser) {
        this.loginUserDao.insert(loginUser);
        return loginUser;
    }

    /**
     * 修改数据
     *
     * @param loginUser 实例对象
     * @return 实例对象
     */
    @Override
    public LoginUser update(LoginUser loginUser) {
        this.loginUserDao.update(loginUser);
        return this.queryById(loginUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.loginUserDao.deleteById(id) > 0;
    }
}