package com.tanglinkai.mall.service;

import com.tanglinkai.mall.entity.po.Goods;
import com.tanglinkai.mall.entity.vo.PageBeanVO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface GoodsService  {
    /**
     * 新增商品
     * @param goods
     */
    void addGoods(Goods goods, MultipartFile file);

    /**
     * 查询所有商品
     * @return
     */
    List<Goods> findAll();

    /**
     * 分页查询商品
     * @param pageNo
     * @return
     */
    PageBeanVO<Goods> findByPage(int pageNo);
}
