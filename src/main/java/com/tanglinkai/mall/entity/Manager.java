package com.tanglinkai.mall.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@TableName("wn_manager")
public class Manager {
    @TableId(type = IdType.AUTO)
    private int id;
    @TableField
    private String account;
    private String password;
    @TableField("last_login_time")
    private LocalDateTime lastLoginTime;
    private String lastLoginIp;
    private String status;

}
