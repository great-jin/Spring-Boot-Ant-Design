package xyz.ibudai.filter;

import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang3.StringUtils;
import xyz.ibudai.util.TokenUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        boolean isAuth = true;
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = req.getHeader("token");
        if (StringUtils.isNotBlank(token)) {
            try {
                TokenUtil.parseJWT(token);
            } catch (ExpiredJwtException e) {
                isAuth = false;
            }
            if (isAuth) {
                filterChain.doFilter(req, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
