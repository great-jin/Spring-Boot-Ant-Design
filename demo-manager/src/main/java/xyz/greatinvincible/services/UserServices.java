package xyz.greatinvincible.services;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import xyz.greatinvincible.entity.User;

import java.util.List;

@CacheConfig(cacheNames = "users")
public interface UserServices {

    /**
     * Author:Budai 2022/1/6 20:40
     * @return List<User>
     */
    @Cacheable
    List<User> list();

    /**
     * Author:Budai 2021/12/31 19:40
     * @param code
     * @return User
     */
    @Cacheable
    User get(String code);

    /**
     * Author:Budai 2021/12/31 19:40
     * @param user
     * @return User
     */
    User getUserByCode(User user);

    /**
     * Author:Budai 2021/12/31 19:40
     * @param user
     * @return int
     */
    int updateUser(User user);

}
