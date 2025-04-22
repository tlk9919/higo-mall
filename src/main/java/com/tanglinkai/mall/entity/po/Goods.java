package com.tanglinkai.mall.entity.po;


import com.tanglinkai.mall.entity.enums.GoodsStatusEnums;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Goods {
    private int id;
    private String name;
    private String no;
    private Integer categoryId;
    private Integer stock;
    private BigDecimal marketPrice;
    private BigDecimal salePrice;
    private String image;
    private String description;
    private String hottest;
    private String newest;
    private LocalDateTime saleTime;
    private String status;
}
