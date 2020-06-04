package com.ictbda.iot.controller;

import com.ictbda.iot.config.security.VerificationCode;
import com.ictbda.iot.entity.LoginUser;
import com.ictbda.iot.entity.Output;
import com.ictbda.iot.service.LoginUserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * (LoginUser)表控制层
 *
 * @author makejava
 * @since 2020-06-03 13:54:44
 */
@RestController
@RequestMapping("/iot-api")
public class LoginUserController {
    /**
     * 服务对象
     */
    @Resource
    private LoginUserService loginUserService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public LoginUser selectOne(Long id) {
        return this.loginUserService.queryById(id);
    }

    @GetMapping("/login")
    public Output login() {
        return Output.error("尚未登录，请登录!");
    }

    @GetMapping("/verifyCode")
    public void verifyCode(HttpSession session, HttpServletResponse resp) throws IOException {
        VerificationCode code = new VerificationCode();
        BufferedImage image = code.getImage();
        String text = code.getText();
        session.setAttribute("verifyCode", text);
        VerificationCode.output(image,resp.getOutputStream());
    }

    @PostMapping("updatePassword")
    public Output updatePassword(@RequestBody LoginUser user){

        loginUserService.update (user);

        return Output.ok ("修改成功！");
    }
}