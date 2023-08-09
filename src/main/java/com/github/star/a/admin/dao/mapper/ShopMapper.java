package com.github.star.a.admin.dao.mapper;

import com.github.star.a.admin.entity.Shop;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopMapper {

    int createShop(Shop shop);

    Shop findShopByName(@Param("name") String shopName);

    Shop findShopById(@Param("id") Integer shopId);

    int removeShopById(@Param("id") Integer shopId);
}
