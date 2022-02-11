package xyz.greatinvincible.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
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

    /**
     * Redis缓存禁止空值时添加指令
     * unless="#result == null"
     */
    @Override
    @Cacheable(key = "#code")
    public User get(String code) {
        return userMapper.get(code);
    }

    @Override
    @Cacheable(key = "#user.ID")
    public User getUser(User user) {
        return userMapper.getUser(user);
    }

    @Override
    @CacheEvict(value = "0", allEntries = true)
    public int add(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int delete(String code) {
        return userMapper.delete(code);
    }
}
