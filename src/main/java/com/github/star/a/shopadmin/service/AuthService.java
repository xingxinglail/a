package com.github.star.a.shopadmin.service;

import com.github.star.a.admin.entity.ShopAdminUser;
import com.github.star.a.dto.SignInDTO;
import com.github.star.a.exception.HttpException;
import com.github.star.a.shopadmin.dao.ShopUserDao;
import com.github.star.a.util.AESUtil;
import com.github.star.a.util.JWTUtil;
import com.github.star.a.vo.SignVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("ShopAdminAuthService")
public class AuthService {

    private final ShopUserDao shopUserDao;

    @Autowired
    public AuthService(ShopUserDao shopUserDao) {
        this.shopUserDao = shopUserDao;
    }

    public SignVO signIn(SignInDTO signInDto) {
        ShopAdminUser savedShopAdminUser = ShopAdminUser.builder()
                .username(signInDto.getUsername())
                .password(AESUtil.encode(signInDto.getPassword()))
                .build();
        savedShopAdminUser = shopUserDao.findUserByUsernameAndPassword(savedShopAdminUser);
        if (savedShopAdminUser != null) {
            String token = JWTUtil.generateToken(savedShopAdminUser.getId(), savedShopAdminUser.getShopId(), JWTUtil.TypeEnum.Admin);
            return SignVO.builder().nickname(savedShopAdminUser.getNickname()).token(token).build();
        }
        throw new HttpException("用户名或密码错误");
    }
}
