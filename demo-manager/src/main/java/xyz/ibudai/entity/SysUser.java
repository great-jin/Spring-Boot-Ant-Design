package xyz.ibudai.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;

import java.util.Date;
import java.io.Serializable;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2022-07-20 10:21:46
 */
public class SysUser implements Serializable {
    private static final long serialVersionUID = -55382910591649367L;

    @ExcelProperty("编号")
    private Integer id;

    @ExcelProperty("用户米")
    private String username;

    @ExcelProperty("密码")
    private String password;

    @ExcelProperty("性别")
    private String gender;

    @ExcelProperty("生日")
    @DateTimeFormat("yyyy-MM-dd")
    private Date birthday;

    @ExcelProperty("状态")
    private Integer isDelete;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

}

