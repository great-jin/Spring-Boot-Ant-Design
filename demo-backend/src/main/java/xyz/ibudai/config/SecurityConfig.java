package xyz.ibudai.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import xyz.ibudai.service.AuthUserService;
import xyz.ibudai.util.TokenUtil;
import xyz.ibudai.util.encrypt.AESEncoder;

import java.util.concurrent.TimeUnit;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${auth.api.verify}")
    private String verifyAPI;

    @Value("${auth.api.free}")
    private String freeAPI;

    @Value("${auth.api.user}")
    private String userAPI;

    @Value("${auth.api.admin}")
    private String adminAPI;

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
        String[] freeResource = freeAPI.trim().split(",");
        String[] userResource = userAPI.trim().split(",");
        String[] adminResource = adminAPI.trim().split(",");
        http.authorizeRequests()
                // 设置免认证资源
                .antMatchers(freeResource).permitAll()
                // 为不同权限分配不同资源
                .antMatchers(userResource).hasRole("USER")
                .antMatchers(adminResource).hasRole("ADMIN")
                // 默认无定义资源都需认证
                .anyRequest().authenticated()
                // 自定义认证访问资源
                .and().formLogin()
                // 自定义认证对象属性键值
                .usernameParameter("username").passwordParameter("password")
                // 认证成功逻辑
                .successHandler((request, response, authentication) -> {
                    String username = authentication.getName();
                    String token = TokenUtil.createJWT(username, TimeUnit.MINUTES.toMillis(60));
                    response.addHeader("token", token);
                })
                // 认证失败逻辑
                .failureHandler((request, response, authentication) -> {
                    String token = "Auth failure";
                    response.setContentType("application/json;charset=UTF-8");
                    response.getWriter().write("{\"token\": \"" + token + "\"}");
                })
                .and().httpBasic()
                // 允许跨域
                .and().cors()
                // 关闭跨站攻击
                .and().csrf().disable();
    }

}
