package com.tanglinkai.mall.service.impl;

import com.tanglinkai.mall.entity.enums.AccountStatusEnums;
import com.tanglinkai.mall.entity.enums.GoodsStatusEnums;
import com.tanglinkai.mall.entity.po.Goods;
import com.tanglinkai.mall.mapper.GoodsMapper;
import com.tanglinkai.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Override
    public void addGoods(Goods goods) {
        //1.判断是否为热售商品
        if (goods.getHottest() == null){
            goods.setHottest(GoodsStatusEnums.NOT_HOT.getStatus());
        }
        //2.判断是否为最新商品
        if (goods.getNewest() == null){
            goods.setNewest(GoodsStatusEnums.NOT_NEW.getStatus());
        }
        //3.保存商品
        goods.setSaleTime(LocalDateTime.now());
        goods.setStatus(AccountStatusEnums.ENABLED.getCode());
        goods.setImage("default.jpg");
        goodsMapper.insert(goods);
    }
}
