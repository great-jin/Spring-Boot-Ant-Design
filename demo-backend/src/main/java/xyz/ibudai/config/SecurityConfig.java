package xyz.ibudai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import xyz.ibudai.service.AuthUserService;
import xyz.ibudai.util.encrypt.AESEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthUserService authUserService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 动态读取数据库信息
        auth.userDetailsService(authUserService)
                // 自定义 AES 方式加密
                .passwordEncoder(new AESEncoder());
    }

    /**
     * USER: 只能访问特定资源
     * ADMIN: 可以访问所有资源
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        String[] freeAuth = {"/api/auth/verify", "/api/file/**", "/api/test/**", "/api/sysUser/**"};
        String[] userResource = {"/api/resource/user/**"};
        String[] adminResource = {"/api/resource/admin/**"};
        http.authorizeRequests()
                // 设置免认证资源
                .antMatchers(freeAuth).permitAll()
                // 为不同权限分配不同资源
                .antMatchers(userResource).hasRole("USER")
                .antMatchers(adminResource).hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic()
                .and()
                // 关闭跨站攻击
                .csrf().disable();
    }

    /**
     * 配置直接访问的静态数据
     */
    @Override
    public void configure(WebSecurity web) {
        web.ignoring()
                .antMatchers("/404.html")
                .antMatchers("/500.html");
    }
}
