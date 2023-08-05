package com.github.star.a.client;

import com.github.star.a.common.ResultResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("ClientAuthController")
@RequestMapping("/client/auth")
public class AuthController {

    @PostMapping("/sign-in")
    public ResultResponse<String> signIn() {
        return ResultResponse.success("ok");
    }

    @PostMapping("/sign-up")
    public ResultResponse<String> signUp() {
        return ResultResponse.success("ok");
    }
}
