package xyz.ibudai.dao;

import org.apache.ibatis.annotations.*;
import xyz.ibudai.entity.User;

import java.util.List;

@Mapper
public interface UserDao {

    List<User> list();

    User get(String code);

    int insert(User user);

    int update(User user);

    int delete(String code);

}
