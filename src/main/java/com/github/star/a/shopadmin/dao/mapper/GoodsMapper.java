package com.github.star.a.shopadmin.dao.mapper;

import com.github.star.a.shopadmin.vo.GoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface GoodsMapper {

    List<GoodsVO> getGoodsList(@Param("goodsName") String goodsName, @Param("categoryId") String categoryId);
}
