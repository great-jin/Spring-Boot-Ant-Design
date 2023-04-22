package xyz.ibudai.service.Impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.ibudai.dao.AuthUserDao;
import xyz.ibudai.entity.AuthUser;
import xyz.ibudai.service.AuthUserService;
import xyz.ibudai.util.AESUtil;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * (TbUser)表服务实现类
 *
 * @author makejava
 * @since 2023 -01-31 14:31:28
 */
@Service("tbUserService")
public class AuthUserServiceImpl implements AuthUserService {

    @Resource
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
