package com.github.star.a.shopadmin.vo;

import lombok.Data;

@Data
public class GoodsVO {

    private Integer goodsId;

    private String goodsName;

    private Integer goodsStock;

    private Integer goodsPrice;

    private String goodsImageUrl;

    private Integer goodsSellStatus;

    private Integer categoryId;

}
