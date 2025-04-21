package com.tanglinkai.mall.controller.admin;

import com.tanglinkai.mall.controller.baseControler.ABaseController;
import com.tanglinkai.mall.contstants.Constants;
import com.tanglinkai.mall.entity.po.Manager;
import com.tanglinkai.mall.excpetion.BusinessException;
import com.tanglinkai.mall.service.ManagerService;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller("adminController")
@Slf4j
@RequestMapping("admin")
public class LoginController extends ABaseController {

    @Autowired
    private ManagerService managerService;

    /**
     * 登录
     * @param account
     * @param password
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(String account, String password, Model model, HttpSession session) {
        log.info("账号:{},密码:{}",account,password);
        Manager login = managerService.login(account, password);
        if (login == null){
            model.addAttribute(Constants.MODEL_KEY,Constants.ACCOUNT_OR_PASSWORD_ERROR);
            return getBusinessErrorResponseVO(new BusinessException(Constants.ACCOUNT_OR_PASSWORD_ERROR), "login");

        }
        session.setAttribute(Constants.MANAGER_KEY,login);
        return getSuccessResponseVO("index");
    }
}
