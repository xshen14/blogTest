package com.show.controller;

import com.show.entity.Goods;
import com.show.entity.PageBean;
import com.show.service.GoodsService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 商品资料
 *
 * @author xiaosheng Email:$xshen14@aliyun.com
 * @since 2018/10/9 下午10:58
 */

@Api(value = "/goods")
@Controller
@RequestMapping(value = "/goods")
public class GoodsController {
    @Autowired
    GoodsService goodsService;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "查询商品所有信息")
    @ApiResponses({@ApiResponse(code = 401,message = "未授权"),@ApiResponse(code = 403,message = "禁止"),@ApiResponse(code = 404,message = "未找到")})
    public List<Goods> findGoodsAll(){
        return goodsService.findGoodsAll();
    }

    @RequestMapping(value = "{id}",method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 400,message = "错误请求"),@ApiResponse(code = 401,message = "未授权"),@ApiResponse(code = 403,message = "禁止"),@ApiResponse(code = 404,message = "未找到")})
    @ResponseBody
    @ApiOperation(value = "查询单个商品信息")
    public List<Goods> selectGoodsById(@ApiParam(value = "商品ID", required = true) @PathVariable("id") String id) {
        return goodsService.selectGoodsById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ApiResponses({@ApiResponse(code = 201,message = "已创建"),@ApiResponse(code = 401,message = "未授权"),@ApiResponse(code = 403,message = "禁止"),@ApiResponse(code = 404,message = "未找到")})
    @ResponseBody
    @ApiOperation(value = "新增单个商品信息")
    public int insertGoods(@ModelAttribute Goods goods){
        return goodsService.insertGoods(goods);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ApiResponses({@ApiResponse(code = 201,message = "已创建"),@ApiResponse(code = 401,message = "未授权"),@ApiResponse(code = 403,message = "禁止"),@ApiResponse(code = 404,message = "未找到")})
    @ResponseBody
    @ApiOperation(value = "修改单个商品信息")
    public int updateGoodsById(Goods goods){
        return goodsService.updateGoodsById(goods);
    }

    @RequestMapping(value = "{id}",method = RequestMethod.DELETE)
    @ApiResponses({@ApiResponse(code = 204,message = "无内容"),@ApiResponse(code = 401,message = "未授权"),@ApiResponse(code = 403,message = "禁止")})
    @ResponseBody
    @ApiOperation(value = "删除单个商品信息")
    public int deleteGoodsById(@ApiParam(value = "商品ID", required = true) @PathVariable("id") String id){
        return goodsService.deleteGoodsById(id);
    }

    @RequestMapping(value = "/page/{currentPage},{pageSize}",method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 401,message = "未授权"),@ApiResponse(code = 403,message = "禁止"),@ApiResponse(code = 404,message = "未找到")})
    @ResponseBody
    @ApiOperation(value = "查询商品分页信息")
    public PageBean<Goods> findGoodsAllPage(@ApiParam(value = "商品页数", required = true) @PathVariable("currentPage") int currentPage,
                                            @ApiParam(value = "每页行数", required = true) @PathVariable("pageSize") int pageSize){
        return goodsService.findByPage(currentPage,pageSize);
    }

    @RequestMapping(value = "/count",method = RequestMethod.GET)
    @ApiResponses({@ApiResponse(code = 401,message = "未授权"),@ApiResponse(code = 403,message = "禁止"),@ApiResponse(code = 404,message = "未找到")})
    @ResponseBody
    @ApiOperation(value = "查询商品总数信息")
    public int selectGoodsCount(){
        return goodsService.selectGoodsCount();
    }

    @RequestMapping(value = "/insertGoodsList", method = RequestMethod.POST)
    @ApiResponses({@ApiResponse(code = 201,message = "已创建"),@ApiResponse(code = 401,message = "未授权"),@ApiResponse(code = 403,message = "禁止"),@ApiResponse(code = 404,message = "未找到")})
    @ResponseBody
    @ApiOperation(value = "新增多个商品信息")
    public int insertGoodsList(@ModelAttribute List<Goods> goodsList){
        return goodsService.insertGoodsList(goodsList);
    }
}
