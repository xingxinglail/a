package com.github.star.a.admin.dao;

import com.github.star.a.admin.dao.mapper.AdminUserMapper;
import com.github.star.a.admin.entity.AdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminUserDao {

    private final AdminUserMapper adminUserMapper;

    @Autowired
    public AdminUserDao(AdminUserMapper adminUserMapper) {
        this.adminUserMapper = adminUserMapper;
    }

    public AdminUser findUserByUsernameAndPassword(AdminUser adminUser) {
        return adminUserMapper.findUserByUsernameAndPassword(adminUser.getUsername(), adminUser.getPassword());
    }
}
