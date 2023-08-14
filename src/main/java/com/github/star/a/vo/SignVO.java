package com.github.star.a.vo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SignVO {

    String nickname;

    String token;
}
