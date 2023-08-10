package com.github.star.a.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class CreateShopAdminUserDTO {

    @NotNull(message = "店铺不能为空")
    private Integer shopId;

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message = "昵称不能为空")
    private String nickname;
}
