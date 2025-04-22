package com.tanglinkai.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tanglinkai.mall.entity.po.Goods;

public interface GoodsService  {
    /**
     * 新增商品
     * @param goods
     */
    void addGoods(Goods goods);
}
