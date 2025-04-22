package com.tanglinkai.mall.entity.enums;

public enum GoodsStatusEnums {
    HOT("y"),        // 热门
    NOT_HOT("n"),    // 不热门
    NEW("y"),        // 新品
    NOT_NEW("n");    // 不是新品

    private final String status;

    GoodsStatusEnums(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}

