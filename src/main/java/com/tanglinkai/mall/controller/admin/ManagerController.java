package com.tanglinkai.mall.controller.admin;

import com.tanglinkai.mall.controller.baseControler.ABaseController;
import com.tanglinkai.mall.contstants.Constants;
import com.tanglinkai.mall.entity.enums.AccountStatusEnums;
import com.tanglinkai.mall.entity.po.Manager;
import com.tanglinkai.mall.service.ManagerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Slf4j
@Controller
@RequestMapping("admin/manager")
public class ManagerController extends ABaseController {
    @Autowired
    private ManagerService managerService;

    /**
     * 添加管理员页面视图
     * @return
     */
    @GetMapping("add")
    public ModelAndView add() {
        return getSuccessResponseVO("manager_add");
    }

    /**
     * 提交添加管理员的表单数据并保存到数据库
     * @param manager
     * @return
     */
    @PostMapping("add")
    public ModelAndView add(Manager manager) {
        manager.setStatus(AccountStatusEnums.ENABLED.getCode());
        managerService.addAccount(manager);
        return getSuccessResponseVO( "success");
    }

    /**
     * 展示所有管理员
     * @param model
     * @return
     */
    @GetMapping("/list")
    public ModelAndView  list(Model model) {
        List<Manager> managers = managerService.list();
        model.addAttribute(Constants.MANAGERS_KEY, managers);
        return getSuccessResponseVO("manager_list");
    }

    /**
     * 根据id查询管理员信息
     * @param id
     * @param model
     * @return
     */

    @GetMapping("update/{id}")
    public ModelAndView  update(@PathVariable int id, Model model) {
        Manager manager = managerService.getById(id);
        model.addAttribute(Constants.MANAGER_KEY, manager);
       return getSuccessResponseVO("manager_update");
    }

    /**
     * 编辑管理员信息
     * @param manager
     * @return
     */
    @PostMapping("update")
    public ModelAndView  update(Manager manager) {
        log.debug("manager:{}", manager);
        managerService.updateById(manager);
        return getSuccessResponseVO("redirect:/admin/manager/list");
    }

    /**
     *
     * 根据id删除管理员
     * @param id
     * @return
     */
    @GetMapping("del/{id}")
    public ModelAndView del(@PathVariable int id){
        managerService.removeById(id);
        return getSuccessResponseVO("redirect:/admin/manager/list");
    }
}