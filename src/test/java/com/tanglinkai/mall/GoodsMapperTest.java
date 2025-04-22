package com.tanglinkai.mall;

import com.tanglinkai.mall.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class GoodsMapperTest {
    @Autowired
    private GoodsMapper goodsMapper;

    @Test
    void testList() {
        goodsMapper.list().forEach(System.out::println);
    }
}
