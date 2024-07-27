package xyz.ibudai.oauth.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.ibudai.oauth.filter.TokenFilter;

import java.util.Collections;

@Configuration
public class FilterConfig {

    @Value("${auth.api.verify}")
    private String verifyAPI;

    @Bean
    public FilterRegistrationBean<TokenFilter> orderFilter1() {
        FilterRegistrationBean<TokenFilter> filter = new FilterRegistrationBean<>();
        filter.setName("auth-filter");
        // Set effect url
        filter.setUrlPatterns(Collections.singleton("/**"));
        // Set ignore url, when multiply the value spilt with ","
        filter.addInitParameter("excludedUris", verifyAPI);
        filter.setOrder(-1);
        filter.setFilter(new TokenFilter());
        return filter;
    }
}
