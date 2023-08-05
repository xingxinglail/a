package com.github.star.a.admin.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignVO {

    String nickname;

    String token;
}
