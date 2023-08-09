package com.github.star.a.admin.vo;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ShopVO {

    private Integer id;

    private String name;

    private String desc;

    private String logoUrl;
}
