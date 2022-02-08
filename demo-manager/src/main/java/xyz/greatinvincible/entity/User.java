package xyz.greatinvincible.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private Integer ID;
    private String accountCode;
    private String userName;
    private String password;
    private Integer isDelete;
}
