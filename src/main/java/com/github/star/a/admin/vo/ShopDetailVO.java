package com.github.star.a.admin.vo;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class ShopDetailVO extends ShopVO {

    private List<ShopAdminUserVO> users;
}
