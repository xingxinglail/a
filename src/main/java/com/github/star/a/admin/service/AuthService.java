package com.github.star.a.admin.service;

import com.github.star.a.admin.dao.AdminUserDao;
import com.github.star.a.admin.entity.AdminUser;
import com.github.star.a.admin.vo.SignVO;
import com.github.star.a.exception.HttpException;
import com.github.star.a.util.AESUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AdminUserDao adminUserDao;

    @Autowired
    public AuthService(AdminUserDao adminUserDao) {
        this.adminUserDao = adminUserDao;
    }

    public SignVO signIn(String username, String password) {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(username);
        adminUser.setPassword(AESUtil.encode(password));
        AdminUser savedAdminUser = adminUserDao.findUserByUsernameAndPassword(adminUser);
        if (savedAdminUser != null) {
            return SignVO.builder().nickname(savedAdminUser.getNickname()).token("").build();
        }
        throw new HttpException("用户名或密码错误");
    }
}
