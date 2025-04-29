package com.tanglinkai.mall.controller.admin;

import com.tanglinkai.mall.controller.baseControler.ABaseController;
import com.tanglinkai.mall.contstants.Constants;
import com.tanglinkai.mall.entity.po.Category;
import com.tanglinkai.mall.entity.po.Goods;
import com.tanglinkai.mall.entity.vo.PageBeanVO;
import com.tanglinkai.mall.excpetion.BusinessException;
import com.tanglinkai.mall.service.CategoryService;
import com.tanglinkai.mall.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
     *
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
     * 新增商品
     *
     * @param goods
     * @param file
     * @return
     */
    @PostMapping("add")
    public ModelAndView add(Goods goods, MultipartFile file) {

        goodsService.addGoods(goods,file);
        return getSuccessResponseVO("ok");
    }

    /**
     *
     * @param model
     * @return
     */
    @GetMapping("list")
    public ModelAndView list(Model model){
        List<Goods> all = goodsService.findAll();
        model.addAttribute(Constants.GOODSES_KEY, all);

        return getSuccessResponseVO("goods_list");
    }

    /**
     * 分页查询
     * @param pageNo
     * @param model
     * @return
     */
    @GetMapping("listbypage")
    public ModelAndView listByPage(Integer pageNo, Model model) {
        //1. 处理页码参数
        //   默认显示第一页，当pageNo为null或非法值时使用默认值
        int page = 1;
        if (pageNo != null) {
            page = pageNo;
        }
        PageBeanVO<Goods> pageVo = goodsService.findByPage(page);
        model.addAttribute(Constants.PAGEBEAN_KEY, pageVo);
        return getSuccessResponseVO("goods_list");
    }
}
