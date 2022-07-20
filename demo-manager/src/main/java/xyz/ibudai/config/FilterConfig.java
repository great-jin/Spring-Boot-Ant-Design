package xyz.ibudai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.ibudai.filter.LoginInterceptor;

@Configuration
public class FilterConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LoginInterceptor loginInterceptor = new LoginInterceptor();

        String[] path = {"/users/**"};
        String[] excludePath = {"/users/list"};
        registry.addInterceptor(loginInterceptor).addPathPatterns(path)
                .excludePathPatterns(excludePath);
    }
}



