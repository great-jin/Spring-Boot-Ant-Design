package xyz.ibudai.common.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2022-07-20 10:21:46
 */
@Data
public class SysUser implements Serializable {
    private static final long serialVersionUID = -55382910591649367L;

    @ExcelProperty("编号")
    private Integer id;

    @ExcelProperty("用户名")
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

}

