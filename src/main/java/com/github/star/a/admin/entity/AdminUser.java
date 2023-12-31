package com.github.star.a.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdminUser {

    Integer id;

    String username;

    String password;

    String nickname;

    Integer isDeleted;

    Date createTime;

    Date updateTime;
}
