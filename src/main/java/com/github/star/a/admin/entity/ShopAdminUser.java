package com.github.star.a.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopAdminUser {

    private Integer id;

    private Integer shopId;

    private String username;

    private String password;

    private String nickname;

    private Integer isDeleted;

    private Integer createBy;

    private Date createTime;

    private Date updateTime;
}
