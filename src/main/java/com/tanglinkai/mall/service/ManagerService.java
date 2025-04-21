package com.tanglinkai.mall.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tanglinkai.mall.entity.po.Manager;

public interface ManagerService extends IService<Manager> {
    /**
     * 新增管理员
     * @param manager
     */
    void addAccount(Manager manager);

    /**
     * 账号登录
     * @param account
     * @param password
     * @return
     */
    Manager login(String account, String password);
}
