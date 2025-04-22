package com.tanglinkai.mall.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tanglinkai.mall.entity.po.Goods;


import java.util.List;

public interface GoodsMapper extends BaseMapper<Goods> {
    /**
     * 查询商品列表
     * @return
     */
    List<Goods> list();
}
