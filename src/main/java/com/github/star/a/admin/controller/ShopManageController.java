package com.github.star.a.admin.controller;

import com.github.star.a.admin.dto.CreateShopAdminUserDTO;
import com.github.star.a.admin.dto.CreateShopDTO;
import com.github.star.a.admin.service.ShopManageService;
import com.github.star.a.admin.vo.ShopDetailVO;
import com.github.star.a.admin.vo.ShopVO;
import com.github.star.a.exception.HttpException;
import com.mysql.cj.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/admin/shop")
public class ShopManageController {

    private final ShopManageService shopManageService;

    @Autowired
    public ShopManageController(ShopManageService shopManageService) {
        this.shopManageService = shopManageService;
    }

    @PostMapping("")
    public void createShop(@RequestBody @Valid CreateShopDTO createShopDTO) {
         shopManageService.createShop(createShopDTO);
    }

    @GetMapping("")
    public ShopVO findShopByName(@RequestParam("name") String name) {
        if (StringUtils.isNullOrEmpty(name)) {
            throw new HttpException("店铺名称不能为空");
        }
        return shopManageService.findShopByName(name);
    }

    @DeleteMapping("{id}")
    public void removeShopById(@PathVariable Integer id) {
        if (id == null || id <= 0) {
            throw new HttpException("无效的店铺id");
        }
        shopManageService.removeShopById(id);
    }

    @PostMapping("/user")
    public void createShopAdminUser(@RequestBody @Valid CreateShopAdminUserDTO createShopAdminUserDTO) {
        shopManageService.createShopAdminUser(createShopAdminUserDTO);
    }

    @GetMapping("{id}")
    public ShopDetailVO findShopDetailById(@PathVariable Integer id) {
        return shopManageService.findShopDetailById(id);
    }
}
