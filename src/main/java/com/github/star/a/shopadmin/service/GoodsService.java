package com.github.star.a.shopadmin.service;

import com.github.star.a.shopadmin.dao.GoodsDao;
import com.github.star.a.shopadmin.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsService {

    private final GoodsDao goodsDao;

    @Autowired
    public GoodsService(GoodsDao goodsDao) {
        this.goodsDao = goodsDao;
    }

    public List<GoodsVO> getGoodsList(String goodsName, String categoryId) {
        return goodsDao.getGoodsList(goodsName, categoryId);
    }
}
