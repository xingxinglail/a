package com.github.star.a.admin.dao;

import com.github.star.a.admin.dao.mapper.ShopMapper;
import com.github.star.a.admin.entity.Shop;
import com.github.star.a.admin.entity.ShopAdminUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ShopDao {

    private final ShopMapper shopMapper;

    @Autowired
    public ShopDao(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }

    public int createShop(Shop shop){
        return shopMapper.createShop(shop);
    }

    public Shop findShopByName(String shopName){
        return shopMapper.findShopByName(shopName);
    }

    public Shop findShopById(Integer shopId) {
        return shopMapper.findShopById(shopId);
    }

    public void removeShopById(Integer shopId) {
        shopMapper.removeShopById(shopId);
    }

    public void createShopAdminUser(ShopAdminUser shopAdminUser) {
        shopMapper.createShopAdminUser(shopAdminUser);
    }

    public List<ShopAdminUser> findAdminUserByShopId(Integer shopId) {
        return shopMapper.findAdminUserByShopId(shopId);
    }
}
