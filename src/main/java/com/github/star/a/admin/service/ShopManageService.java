package com.github.star.a.admin.service;

import com.github.star.a.admin.dao.ShopDao;
import com.github.star.a.admin.dto.CreateShopAdminUserDTO;
import com.github.star.a.admin.dto.CreateShopDTO;
import com.github.star.a.admin.entity.Shop;
import com.github.star.a.admin.entity.ShopAdminUser;
import com.github.star.a.admin.vo.ShopAdminUserVO;
import com.github.star.a.admin.vo.ShopDetailVO;
import com.github.star.a.admin.vo.ShopVO;
import com.github.star.a.exception.HttpException;
import com.github.star.a.util.AESUtil;
import com.github.star.a.util.NamedThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShopManageService {

    private final ShopDao shopDao;

    @Autowired
    public ShopManageService(ShopDao shopDao) {
        this.shopDao = shopDao;
    }

    public void createShop(CreateShopDTO createShopDTO) {
        Integer createById = NamedThreadLocalUtil.get();
        Shop shop = shopDao.findShopByName(createShopDTO.getName());
        if (shop != null) {
            throw new HttpException("店铺已存在");
        }
        try {
            shop = Shop.builder()
                    .name(createShopDTO.getName())
                    .desc(createShopDTO.getDesc())
                    .logoUrl(createShopDTO.getLogoUrl())
                    .createBy(createById)
                    .build();
            shopDao.createShop(shop);
        } catch (DuplicateKeyException e) {
            throw new HttpException("店铺已存在", e);
        }
    }

    public ShopVO findShopByName(String name) {
        Shop shop = shopDao.findShopByName(name);
        if (shop != null) {
            return ShopVO.builder()
                    .id(shop.getId())
                    .name(shop.getName())
                    .desc(shop.getDesc())
                    .logoUrl(shop.getLogoUrl())
                    .build();
        }
        throw new HttpException(HttpStatus.NOT_FOUND, "店铺不存在");
    }

    public Shop findShopById(Integer id) {
        return shopDao.findShopById(id);
    }

    public void removeShopById(Integer id) {
        Shop shop = findShopById(id);
        if (shop != null) {
            shopDao.removeShopById(id);
            return;
        }
        throw new HttpException(HttpStatus.NOT_FOUND, "店铺不存在");
    }

    public void createShopAdminUser(CreateShopAdminUserDTO createShopAdminUserDTO) {
        Shop shop = findShopById(createShopAdminUserDTO.getShopId());
        if (shop == null) {
            throw new HttpException(HttpStatus.NOT_FOUND, "店铺不存在");
        }
        ShopAdminUser shopAdminUser = ShopAdminUser.builder()
                .shopId(shop.getId())
                .username(createShopAdminUserDTO.getUsername())
                .password(AESUtil.encode("123456"))
                .nickname(createShopAdminUserDTO.getNickname())
                .createBy(NamedThreadLocalUtil.get())
                .build();
        try {
            shopDao.createShopAdminUser(shopAdminUser);
        } catch (DuplicateKeyException e) {
            throw new HttpException("用户已存在", e);
        }
    }

    public ShopDetailVO findShopDetailById(Integer id) {
        Shop shop = findShopById(id);
        if (shop == null) {
            throw new HttpException(HttpStatus.NOT_FOUND, "店铺不存在");
        }
        List<ShopAdminUser> shopAdminUsers = shopDao.findAdminUserByShopId(id);
        return ShopDetailVO.builder()
                .id(shop.getId())
                .name(shop.getName())
                .desc(shop.getDesc())
                .logoUrl(shop.getLogoUrl())
                .users(shopAdminUsers.stream().map(c -> ShopAdminUserVO.builder()
                        .id(c.getId())
                        .username(c.getUsername())
                        .nickname(c.getNickname())
                        .createTime(c.getCreateTime())
                        .build()).collect(Collectors.toList()))
                .build();
    }
}
