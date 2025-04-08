package com.tanglinkai.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanglinkai.mall.entity.Manager;
import com.tanglinkai.mall.mapper.ManagerMapper;
import com.tanglinkai.mall.service.ManagerService;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager> implements ManagerService {
}
