package xyz.ibudai.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.ibudai.common.ResultData;
import xyz.ibudai.util.TokenUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AuthFilter implements Filter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean isAuth = true;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = req.getHeader("Token");
        if (StringUtils.isNotBlank(token)) {
            try {
                TokenUtil.parseJWT(token);
            } catch (ExpiredJwtException e) {
                isAuth = false;
            }
            if (isAuth) {
                filterChain.doFilter(req, servletResponse);
            }
        } else {
            HttpServletResponse response = (HttpServletResponse) servletResponse;
            response.setContentType("application/json;charset=UTF-8");
            response.setStatus(203);
            String msg = "Request illegal, please authentication";
            ResultData<Object> result = new ResultData<>(203, msg, null);
            response.getWriter().write(objectMapper.writeValueAsString(result));
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
