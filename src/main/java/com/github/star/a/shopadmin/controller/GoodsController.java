package com.github.star.a.shopadmin.controller;

import com.github.star.a.shopadmin.service.GoodsService;
import com.github.star.a.shopadmin.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shop-admin/goods")
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @GetMapping("/list")
    public List<GoodsVO> getGoodsList(@RequestParam(value = "goodsName", required = false) String goodsName,
                                      @RequestParam(value = "categoryId", required = false) String categoryId) {
        return goodsService.getGoodsList(goodsName, categoryId);
    }
}
