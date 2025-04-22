package com.tanglinkai.mall.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tanglinkai.mall.entity.po.Category;
import com.tanglinkai.mall.mapper.CategoryMapper;
import com.tanglinkai.mall.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}
