package com.github.star.a.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SignInDTO {

    // 不为null并且包含至少一个非空白字符
    @NotBlank(message = "用户名不能为空")
    String username;

    // 不为null并且包含至少一个非空白字符
    @NotBlank(message = "密码不能为空")
    String password;
}
