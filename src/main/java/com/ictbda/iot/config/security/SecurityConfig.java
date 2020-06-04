package com.ictbda.iot.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ictbda.iot.entity.Output;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.*;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.annotation.Resource;
import java.io.PrintWriter;

/**
 * @Author: Create by gsy
 * @Date: Create in 2020/6/3 13:40
 * @Description:f
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    UserDetailsService userDetailsService;

    @Resource
    VerificationCodeFilter verificationCodeFilter;

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder ( );
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService (userDetailsService);
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring ( ).antMatchers (
                "/swagger-ui.html",
                "/webjars/**","/v1/**",
                "/swagger-resources/configuration/ui",
                "/swagger-resources",
                "/v2/api-docs",
                "/swagger-resources/configuration/security",
                "/iot-api/verifyCode",
                "/websocket/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.addFilterBefore (verificationCodeFilter, UsernamePasswordAuthenticationFilter.class);
        http.authorizeRequests ( )
                .anyRequest ( ).authenticated ( )
                .and ( )
                .formLogin ( )
                .usernameParameter ("username")
                .passwordParameter ("password")
                .loginProcessingUrl ("/iot-api/doLogin")
                .loginPage ("/login")
                .successHandler ((req, resp, authentication) -> {
                    resp.setContentType ("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter ( );
                    Output ok = Output.ok ("登录成功!");
                    String s = new ObjectMapper ( ).writeValueAsString (ok);
                    out.write (s);
                    out.flush ( );
                    out.close ( );
                })
                .failureHandler ((req, resp, exception) -> {
                    resp.setContentType ("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter ( );
                    Output respBean = Output.error ("登录失败!");
                    if ( exception instanceof LockedException ) {
                        respBean.setMsg ("账户被锁定，请联系管理员!");
                    } else if ( exception instanceof CredentialsExpiredException ) {
                        respBean.setMsg ("密码过期，请联系管理员!");
                    } else if ( exception instanceof AccountExpiredException ) {
                        respBean.setMsg ("账户过期，请联系管理员!");
                    } else if ( exception instanceof DisabledException ) {
                        respBean.setMsg ("账户被禁用，请联系管理员!");
                    } else if ( exception instanceof BadCredentialsException ) {
                        respBean.setMsg ("用户名或者密码输入错误，请重新输入!");
                    }
                    out.write (new ObjectMapper ( ).writeValueAsString (respBean));
                    out.flush ( );
                    out.close ( );
                })
                .permitAll ( )
                .and ( )
                .logout ( )
                .logoutUrl ("/iot-api/doLogout")
                .logoutSuccessHandler ((req, resp, authentication) -> {
                    resp.setContentType ("application/json;charset=utf-8");
                    PrintWriter out = resp.getWriter ( );
                    out.write (new ObjectMapper ( ).writeValueAsString (Output.ok ("注销成功!")));
                    out.flush ( );
                    out.close ( );
                })
                .permitAll ( )
                .and ( )
                .csrf ( ).disable ( ).exceptionHandling ( )
                //没有认证时，在这里处理结果，不要重定向
                .authenticationEntryPoint ((req, resp, authException) -> {
                    resp.setContentType ("application/json;charset=utf-8");
                    resp.setStatus (401);
                    PrintWriter out = resp.getWriter ( );
                    Output respBean = Output.error ("访问失败!");
                    if ( authException instanceof InsufficientAuthenticationException ) {
                        respBean.setMsg ("请求失败，请联系管理员!");
                    }
                    out.write (new ObjectMapper ( ).writeValueAsString (respBean));
                    out.flush ( );
                    out.close ( );
                });
    }
}
