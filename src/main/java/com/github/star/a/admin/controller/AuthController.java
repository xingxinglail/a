package com.github.star.a.admin.controller;

import com.github.star.a.dto.SignInDTO;
import com.github.star.a.admin.service.AuthService;
import com.github.star.a.vo.SignVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController("AdminAuthController")
@RequestMapping("/admin/auth")
public class AuthController {

    private final AuthService authService;

    @Autowired
    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/no-token/sign-in")
    public SignVO signIn(@RequestBody @Valid SignInDTO signInDto) {
        return authService.signIn(signInDto.getUsername(), signInDto.getPassword());
    }
}
