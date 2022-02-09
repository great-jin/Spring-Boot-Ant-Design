package xyz.greatinvincible.services;

import xyz.greatinvincible.entity.User;
import java.util.List;

public interface UserServices {

    /**
     * Author:Budai 2022/1/6 20:40
     * @return List<User>
     */
    List<User> list();

    /**
     * Author:Budai 2021/12/31 19:40
     * @param code
     * @return User
     */
    User get(String code);

    /**
     * Author:Budai 2021/12/31 19:40
     * @param user
     * @return User
     */
    User getByCode(User user);

    /**
     * Author:Budai 2021/12/31 19:40
     * @param user
     * @return int
     */
    int updateUser(User user);

}
