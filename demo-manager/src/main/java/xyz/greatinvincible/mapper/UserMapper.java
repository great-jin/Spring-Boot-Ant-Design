package xyz.greatinvincible.mapper;

import org.apache.ibatis.annotations.*;
import xyz.greatinvincible.entity.User;

import java.util.List;

@Mapper
public interface UserMapper {

    List<User> list();

    User get(String code);

    int insert(User user);

    int update(User user);

    int delete(String code);

}
