package com.tanglinkai.mall.controller.baseControler;


import com.tanglinkai.mall.entity.enums.ResponseCodeEnum;
import com.tanglinkai.mall.excpetion.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
public class ABaseController {

    protected static final String STATUS_SUCCESS = "success";
    protected static final String STATUS_ERROR = "error";

    /**
     * 成功响应
     */
    protected <T> ModelAndView getSuccessResponseVO(T data) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("status", STATUS_SUCCESS);
        mav.addObject("code", ResponseCodeEnum.CODE_200.getCode());
        mav.addObject("info", ResponseCodeEnum.CODE_200.getMsg());
        mav.addObject("data", data);

        // 如果 data 是一个 String，且它是视图名称，则直接设置视图名称
        if (data instanceof String) {
            mav.setViewName((String) data);
        }

        return mav;
    }

    /**
     * 业务异常响应
     */
    protected <T> ModelAndView getBusinessErrorResponseVO(BusinessException e,String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("status", STATUS_ERROR);
        mav.addObject("code", e.getCode() != null ? e.getCode() : ResponseCodeEnum.CODE_600.getCode());
        mav.addObject("info", e.getMessage());
        return mav;
    }

    /**
     * 服务器错误响
     */
    protected <T> ModelAndView getServerErrorResponseVO(T data, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        mav.addObject("status", STATUS_ERROR);
        mav.addObject("code", ResponseCodeEnum.CODE_500.getCode());
        mav.addObject("info", ResponseCodeEnum.CODE_500.getMsg());
        mav.addObject("data", data);

        return mav;
    }

}



