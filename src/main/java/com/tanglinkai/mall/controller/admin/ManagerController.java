package com.tanglinkai.mall.controller.admin;

import com.tanglinkai.mall.entity.Manager;
import com.tanglinkai.mall.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("admin/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @RequestMapping("add")
    public String add(Manager manager){
        manager.setStatus("y");
        managerService.save(manager);

        return "success";
    }
}
