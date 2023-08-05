package com.github.star.a.admin.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdminUser {

    Long id;

    String username;

    String password;

    String nickname;

    Long isDeleted;

    Date createTime;

    Date updateTime;
}
