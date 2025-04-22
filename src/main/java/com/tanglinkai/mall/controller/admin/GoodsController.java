package com.tanglinkai.mall.controller.admin;

import com.tanglinkai.mall.controller.baseControler.ABaseController;
import com.tanglinkai.mall.contstants.Constants;
import com.tanglinkai.mall.entity.po.Category;
import com.tanglinkai.mall.entity.po.Goods;
import com.tanglinkai.mall.service.CategoryService;
import com.tanglinkai.mall.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("admin/goods")
public class GoodsController extends ABaseController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private GoodsService goodsService;

    /**
     * 跳转到商品添加页面
     * @param model
     * @return
     */
    @GetMapping("add")
    public ModelAndView add(Model model) {
        //查询所有的类别
        List<Category> categories = categoryService.list();
        model.addAttribute(Constants.CATEGORIES_KEY, categories);
        return getSuccessResponseVO("goods_add");
    }

    /**
     * 增加商品
     * @param goods
     * @return
     */
    @PostMapping("add")
    public ModelAndView addGoods(Goods goods) {
        log.debug("Goods:{}", goods);
        goodsService.addGoods(goods);
        return getSuccessResponseVO("ok");
    }
}
