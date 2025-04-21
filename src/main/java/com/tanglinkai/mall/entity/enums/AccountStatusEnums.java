package com.tanglinkai.mall.entity.enums;

public enum AccountStatusEnums {
    ENABLED("1"),  // 启用
    DISABLED("0");  // 禁用

    private final String code;

    AccountStatusEnums(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
