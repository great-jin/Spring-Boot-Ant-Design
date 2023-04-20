package xyz.ibudai.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * (TbUser)实体类
 *
 * @author makejava
 * @since 2023-01-31 14:31:28
 */
public class AuthUser implements Serializable, UserDetails {

    private static final long serialVersionUID = 213034465413641992L;

    private String id;

    private String userName;

    private String password;

    private String role;

    private String authority;

    private Integer accountNonExpired;

    private Integer accountNonLocked;

    private Integer credentialsNonExpired;

    private Integer isEnabled;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 获取用户所有权限
        String[] roles = role.split(",");
        // 遍历 roles，取出每一个权限进行认证，添加到简单的授予认证类
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (String role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role));
        }
        // 返回到已经被授予认证的权限集合, 这里面的角色所拥有的权限都已经被 spring security 所知道
        return authorities;
    }

    @Override
    public String getUsername() {
        return this.userName;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired == 1;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked == 1;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired == 1;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled == 1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    public Integer getAccountNonExpired() {
        return accountNonExpired;
    }

    public void setAccountNonExpired(Integer accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public Integer getAccountNonLocked() {
        return accountNonLocked;
    }

    public void setAccountNonLocked(Integer accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public Integer getCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(Integer credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public Integer getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Integer isEnabled) {
        this.isEnabled = isEnabled;
    }
}

