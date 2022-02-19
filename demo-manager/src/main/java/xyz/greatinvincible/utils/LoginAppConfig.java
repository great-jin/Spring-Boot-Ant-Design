package xyz.greatinvincible.utils;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.greatinvincible.interceptor.LoginInterceptor;

@Configuration
public class LoginAppConfig implements WebMvcConfigurer {

    /*
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        String[] path = {"/users/**"};
        String[] excludePath = {"/users/list"};
        registry.addInterceptor(loginInterceptor).addPathPatterns(path).excludePathPatterns(excludePath);
    }
    */

}



