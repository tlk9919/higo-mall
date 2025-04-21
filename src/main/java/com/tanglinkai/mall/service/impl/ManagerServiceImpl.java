package com.tanglinkai.mall.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanglinkai.mall.contstants.Constants;
import com.tanglinkai.mall.entity.enums.AccountStatusEnums;
import com.tanglinkai.mall.entity.po.Manager;
import com.tanglinkai.mall.excpetion.AccountExistException;
import com.tanglinkai.mall.mapper.ManagerMapper;
import com.tanglinkai.mall.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
    @Autowired
    private ManagerMapper managerMapper;

    /**
     * 账号注册
     *
     * @param manager
     */
    @Override
    public void addAccount(Manager manager) {
        //1.判断账号是否存在，存在抛出异常
        //1.1构建查询条件
        LambdaQueryWrapper<Manager> account = new LambdaQueryWrapper<Manager>()
                .eq(Manager::getAccount, manager.getAccount());


        Long count = managerMapper.selectCount(account);
        //2.创建用户

        // 2.保存
        if (count > Constants.ZREO) {
            throw new AccountExistException(Constants.Account_EXIST + manager.getAccount());
        }
        managerMapper.insert(manager);
    }

    /**
     * 账号登录
     *
     * @param account
     * @param password
     * @return
     */
    @Override
    public Manager login(String account, String password) {
        //1.构建查询条件
        LambdaQueryWrapper<Manager> lambdaQueryWrapper = new LambdaQueryWrapper<Manager>()
                .eq(Manager::getAccount, account)
                .eq(Manager::getPassword, password);
        //1.1如果账号状态为0，则账号被禁用
        Manager manager = managerMapper.selectOne(lambdaQueryWrapper);

        if (manager != null && AccountStatusEnums.DISABLED.getCode().equals(manager.getStatus())) {
            throw new AccountExistException(Constants.ACCOUNT_STATUS_ERROR);
        }
        //2.返回
        return manager;
    }

}
