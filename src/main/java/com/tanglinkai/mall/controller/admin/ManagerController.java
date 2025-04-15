package com.tanglinkai.mall.controller.admin;

import com.tanglinkai.mall.entity.Manager;
import com.tanglinkai.mall.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
@RequestMapping("admin")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("login")
    public String login(){
        return "login";
    }
}
