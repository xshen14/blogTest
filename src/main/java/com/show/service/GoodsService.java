package com.show.service;

import com.show.entity.Goods;
import com.show.entity.PageBean;

import java.util.List;
import java.util.Map;

/**
 * 商品的实现接口
 *
 * @author xiaosheng Email:$xshen14@aliyun.com
 * @since 2018/10/9 下午11:09
 */
public interface GoodsService {
    List<Goods> findGoodsAll();
    List<Goods> selectGoodsById(String id);
    int insertGoods(Goods goods);
    int updateGoodsById(Goods goods);
    int deleteGoodsById(String id);
    PageBean<Goods> findByPage(int currentPage,int pageSize);
    int selectGoodsCount();
    int insertGoodsList(List<Goods> goodsList);
}
