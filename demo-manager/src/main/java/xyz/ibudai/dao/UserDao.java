package xyz.ibudai.dao;

import xyz.ibudai.entity.User;

import java.util.List;

public interface UserDao {

    List<User> list();

    User get(String code);

    int insert(User user);

    int update(User user);

    int delete(String code);
}
