package com.github.star.a.admin.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class Shop {

    private Integer id;

    private String name;

    private String desc;

    private String logoUrl;

    private Integer status;

    private Integer isDeleted;

    private Integer createBy;

    private Date createTime;

    private Date updateTime;
}
