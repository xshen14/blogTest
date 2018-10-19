package com.show.dao;

import com.show.entity.Goods;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品Dao层
 *
 * @author xiaosheng Email:$xshen14@aliyun.com
 * @since 2018/10/9 下午11:07
 */
public interface GoodsDao {
    List<Goods> findAll();
    List<Goods> selectGoodsById(String id);
    int insertGoods(Goods goods);
    int updateGoodsById(Goods goods);
    int deleteGoodsById(String id);
    List<Goods> findByPage(HashMap<String,Object> map);
    int selectGoodsCount();
    int insertGoodsList(List<Goods> goodsList);

}
