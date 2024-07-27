package xyz.ibudai.oauth.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import xyz.ibudai.common.vo.AuthUser;

public interface AuthUserService extends UserDetailsService {

    boolean login(AuthUser user) throws Exception;
}
