package com.github.star.a.shopadmin.dao;

import com.github.star.a.shopadmin.dao.mapper.GoodsMapper;
import com.github.star.a.shopadmin.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GoodsDao {

    private final GoodsMapper goodsMapper;

    @Autowired
    public GoodsDao(GoodsMapper goodsMapper) {
        this.goodsMapper = goodsMapper;
    }


    public List<GoodsVO> getGoodsList(String goodsName, String categoryId) {
        return goodsMapper.getGoodsList(goodsName, categoryId);
    }
}
