package com.ictbda.iot.controller;

import com.ictbda.iot.dao.LoginUserDao;
import com.ictbda.iot.entity.LoginUser;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/6/9 14:30
 * @Description: 把用户登录id放入session中
 */
public class BaseController {

    @Resource
    private LoginUserDao loginUserDao;

    /**
     * 从session中获取username
     * 查询用户登录id，再放入session中
     * @return
     */
    protected Long getLoginUserId(){

        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String username = (String) request.getSession ( ).getAttribute ("username");
        LoginUser loginUser = loginUserDao.loadUserByUsername (username);

        return loginUser.getId ();
    }
}
