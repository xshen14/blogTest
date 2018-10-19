package com.show.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * 商品类
 *
 * @author xiaosheng Email:$xshen14@aliyun.com
 * @since 2018/10/9 下午11:00
 */
@Getter
@Setter
@ToString
public class Goods {

    private String code;
    private String name;
    private String barcode;
    private String spec;

}
