package com.github.star.a.shopadmin.dao.mapper;

import com.github.star.a.admin.entity.ShopAdminUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ShopUserMapper {

    ShopAdminUser findUserByUsernameAndPassword(ShopAdminUser shopAdminUser);
}
