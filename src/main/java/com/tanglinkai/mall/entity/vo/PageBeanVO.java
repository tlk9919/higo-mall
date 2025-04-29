package com.tanglinkai.mall.entity.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageBeanVO<T> {
    private List<T> data;   //每页的数据
    private int total;      //总数
    private int page;       //页码
    private int pageSize;   //每页数据大小，分页大小
    private int totalPage;  //总页数
    private int pageCount; // 每页数据的实际数量
}