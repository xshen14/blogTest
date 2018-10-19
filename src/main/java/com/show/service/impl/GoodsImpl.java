package com.show.service.impl;

import com.show.dao.GoodsDao;
import com.show.entity.Goods;
import com.show.entity.PageBean;
import com.show.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 商品的实现方法
 *
 * @author xiaosheng Email:$xshen14@aliyun.com
 * @since 2018/10/9 下午11:10
 */
@Service
public class GoodsImpl implements GoodsService {
    @Autowired
    GoodsDao goodsDao;

    @Override
    public List<Goods> findGoodsAll() {
        return goodsDao.findAll();
    }

    @Override
    public List<Goods> selectGoodsById(String id) {
        return goodsDao.selectGoodsById(id);
    }

    @Override
    public int insertGoods(Goods goods) {
        return goodsDao.insertGoods(goods);
    }

    @Override
    public int updateGoodsById(Goods goods) {
        return goodsDao.updateGoodsById(goods);
    }

    @Override
    public int deleteGoodsById(String id) {
        return goodsDao.deleteGoodsById(id);
    }

    @Override
    public PageBean<Goods> findByPage(int currentPage,int pageSize) {
        HashMap<String,Object> map = new HashMap<String, Object>();
        PageBean<Goods> pageBean = new PageBean<Goods>();

        //封装当前页数
        pageBean.setCurrPage(currentPage);
        //每页显示页数
        //int pageSize = 5;
        pageBean.setPageSize(pageSize);
        //封装总记录数
        int totalCount = goodsDao.selectGoodsCount();
        pageBean.setTotalCount(totalCount);
        //封装总页数
        double d = totalCount;
        Double num = Math.ceil(d/pageSize);
        pageBean.setTotalPage(num.intValue());

        map.put("start",(currentPage-1) * pageSize);
        map.put("size",pageBean.getPageSize());
        //封装每页显示的数据
        List<Goods> lists = goodsDao.findByPage(map);
        pageBean.setLists(lists);

        return pageBean;
    }

    @Override
    public int selectGoodsCount() {
        return goodsDao.selectGoodsCount();
    }

    @Override
    public int insertGoodsList(List<Goods> goodsList) {
        return goodsDao.insertGoodsList(goodsList);
    }
}
