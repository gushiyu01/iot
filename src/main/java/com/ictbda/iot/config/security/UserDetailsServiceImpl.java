package com.ictbda.iot.config.security;

import com.ictbda.iot.dao.LoginUserDao;
import com.ictbda.iot.entity.LoginUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/4/10 13:51
 * @Description: 用户登录认证
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private LoginUserDao loginUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginUser user = loginUserDao.loadUserByUsername(username);

        if(user == null){
            throw new UsernameNotFoundException (username);
        }

        return new User (user.getUsername(), user.getPassword(), new ArrayList<> ());
    }

}
