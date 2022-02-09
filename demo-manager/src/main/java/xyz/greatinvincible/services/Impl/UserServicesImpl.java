package xyz.greatinvincible.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import xyz.greatinvincible.entity.User;
import xyz.greatinvincible.mapper.UserMapper;
import xyz.greatinvincible.services.UserServices;

import java.util.List;

@Service
@CacheConfig(cacheNames = "users")
public class UserServicesImpl implements UserServices {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(key = "0")
    public List<User> list() {
        return userMapper.list();
    }

    @Override
    @Cacheable(key = "#code")
    // 禁止空值时处理： unless="#result == null"
    public User get(String code) {
        return userMapper.get(code);
    }

    @Override
    @Cacheable(key = "#user.ID")
    public User getByCode(User user) {
        return userMapper.getUserByCode(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.update(user);
    }
}
