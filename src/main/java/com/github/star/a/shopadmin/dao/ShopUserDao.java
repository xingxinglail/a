package com.github.star.a.shopadmin.dao;

import com.github.star.a.admin.entity.ShopAdminUser;
import com.github.star.a.shopadmin.dao.mapper.ShopUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ShopUserDao {

    private final ShopUserMapper shopUserMapper;

    @Autowired
    public ShopUserDao(ShopUserMapper shopUserMapper) {
        this.shopUserMapper = shopUserMapper;
    }

    public ShopAdminUser findUserByUsernameAndPassword(ShopAdminUser shopAdminUser){
        return shopUserMapper.findUserByUsernameAndPassword(shopAdminUser);
    }
}
