package xyz.ibudai.oauth.dao;

import org.apache.ibatis.annotations.Mapper;
import xyz.ibudai.common.vo.AuthUser;

@Mapper
public interface AuthUserDao {

    /**
     * Query by name tb user.
     *
     * @param userName the username
     * @return the tb user
     */
    AuthUser queryByName(String userName);

}

