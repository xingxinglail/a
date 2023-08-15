package com.github.star.a.shopadmin.entity;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Builder
@Data
public class GoodsEntity {

    private Integer id;

    private Integer shopId;

    private String name;

    private Integer stock;

    private Integer price;

    private String imageUrl;

    private Integer sellStatus;

    private Integer isDeleted;

    private Integer createBy;

    private Date createTime;

    private Date updateTime;
}
