package com.wtf.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        /**authorizeRequests所有security全注解配置实现的开端，表示开始说明需要的权限
         //需要的权限分两部分，
         1:拦截的路径
         2：访问该路径需要的权限
         antMatcher表示拦截什么路径，permitAll任何权限都可以访问，放行所有。
         anyRequest()任何的请求，authenticated认证后才能访问。
         .and().csrf().disable()，固定写法，使csrf拦截失效
         */
        httpSecurity.authorizeRequests()
                .antMatchers("/**").permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable();
    }
}
