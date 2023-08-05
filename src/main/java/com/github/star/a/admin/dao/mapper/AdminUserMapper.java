package com.github.star.a.admin.dao.mapper;

import com.github.star.a.admin.entity.AdminUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminUserMapper {

    AdminUser findUserByUsernameAndPassword(String username, String password);
}
