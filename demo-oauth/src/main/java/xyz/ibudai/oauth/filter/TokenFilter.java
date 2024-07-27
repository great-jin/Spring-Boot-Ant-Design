package xyz.ibudai.oauth.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xyz.ibudai.common.model.ResultData;
import xyz.ibudai.oauth.util.TokenUtil;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@Component
public class TokenFilter implements Filter {

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        String token = req.getHeader("Token");
        if (!isBlank(token)) {
            try {
                TokenUtil.parseJWT(token);
                filterChain.doFilter(req, servletResponse);
            } catch (ExpiredJwtException ignored) {
                log.error("Login expire");
            } catch (Exception e) {
                log.error("Filter error", e);
            }
            return;
        }

        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("application/json;charset=UTF-8");
        response.setStatus(203);
        String msg = "Request illegal, please authentication";
        ResultData<Object> result = new ResultData<>(203, msg, null);
        response.getWriter().write(objectMapper.writeValueAsString(result));
    }

    public static boolean isBlank(CharSequence cs) {
        int strLen = cs == null ? 0 : cs.length();
        if (strLen != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(cs.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }
}
