package com.tanglinkai.mall.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tanglinkai.mall.contstants.Constants;
import com.tanglinkai.mall.entity.enums.AccountStatusEnums;
import com.tanglinkai.mall.entity.enums.GoodsStatusEnums;
import com.tanglinkai.mall.entity.po.Goods;
import com.tanglinkai.mall.entity.vo.PageBeanVO;
import com.tanglinkai.mall.excpetion.BusinessException;
import com.tanglinkai.mall.mapper.GoodsMapper;
import com.tanglinkai.mall.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;
    @Value("${file.upload-dir}")
    private String uploadDir;
    /**
     * 增加商品
     * @param goods
     */
    @Override
    public void addGoods(Goods goods ,MultipartFile file) {
        //1.判断是否为热售商品
        if (goods.getHottest() == null){
            goods.setHottest(GoodsStatusEnums.NOT_HOT.getStatus());
        }
        //2.判断是否为最新商品
        if (goods.getNewest() == null){
            goods.setNewest(GoodsStatusEnums.NOT_NEW.getStatus());
        }
        //3.保存商品
        //3.1.获取文件名
        String originalFilename = file.getOriginalFilename();
        //3.1 获取文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        //3.2 生成新的文件名
        String newFileName = UUID.randomUUID().toString() + suffix;
        File dest = new File(uploadDir+"\\" +newFileName);
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            throw new BusinessException(Constants.UPLOAD_FAIL);
        }
        //4.保存商品信息
        goods.setImage("http://localhost:8081/" + newFileName);
        goods.setSaleTime(LocalDateTime.now());
        goods.setStatus(AccountStatusEnums.ENABLED.getCode());
        goodsMapper.insert(goods);
    }

    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<Goods> findAll() {
        return goodsMapper.list();
    }

    /**
     * 分页查询商品
     * @param pageNo
     * @return
     */
    @Override
    public PageBeanVO<Goods> findByPage(int pageNo) {

        // 1. 创建分页结果容器
        PageBeanVO<Goods> pageBean = new PageBeanVO<>();
        //2.根据参数进行分页:第一个参数就是页码，第二个表示分页大小
        //对紧跟在这句代码之后的查询就会有分页效果
        PageHelper.startPage(pageNo, Constants.PAGE_SIZE_2);
        //3. 执行查询
        List<Goods> list = goodsMapper.list();
        // 4. 包装分页结果
        PageInfo<Goods> pageInfo = new PageInfo<>(list);
        // 5. 组装返回数据
        pageBean.setData(pageInfo.getList());      // 当前页数据列表
        pageBean.setTotalPage(pageInfo.getPages());// 总页数
        pageBean.setTotal((int)pageInfo.getTotal()); // 总记录数
        pageBean.setPage(pageNo);                 // 当前页码
        pageBean.setPageSize( Constants.PAGE_SIZE_2);                  // 每页条数
        pageBean.setPageCount(pageInfo.getList().size()); // 当前页实际条数
        return pageBean;
    }
}
