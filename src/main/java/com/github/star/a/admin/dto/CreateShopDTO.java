package com.github.star.a.admin.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class CreateShopDTO {

    @NotBlank(message = "店铺名称不能为空")
    private String name;

    @NotBlank(message = "店铺描述不能为空")
    private String desc;

    @NotBlank(message = "请上传店铺logo")
    private String logoUrl;
}
