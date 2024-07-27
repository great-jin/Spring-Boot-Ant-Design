package xyz.ibudai.oauth.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.ibudai.oauth.dao.AuthUserDao;
import xyz.ibudai.common.vo.AuthUser;
import xyz.ibudai.oauth.service.AuthUserService;
import xyz.ibudai.oauth.util.AESUtil;

import java.util.Objects;

@Service
public class AuthUserServiceImpl implements AuthUserService {

    @Autowired
    private AuthUserDao authUserDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = authUserDao.queryByName(username);
        if (authUser == null) {
            throw new IllegalArgumentException("User [" + username + "] doesn't exist.");
        }

        return authUser;
    }

    @Override
    public boolean login(AuthUser user) throws Exception {
        AuthUser dbUser = authUserDao.queryByName(user.getUsername());
        if (dbUser == null) {
            throw new RuntimeException("User [" + user.getUsername() + "] doesn't exist.");
        }

        String userPwd = user.getPassword();
        String dbUserPwd = AESUtil.desEncrypt(dbUser.getPassword()).trim();
        return Objects.equals(userPwd, dbUserPwd);
    }
}
