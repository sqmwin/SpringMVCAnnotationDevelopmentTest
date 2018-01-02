package com.sqm.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
@RequestMapping(value = "/test")
public class RegistController {
    @RequestMapping(value = "/regist.do", method = RequestMethod.POST)
    //保证请求中的参数顺序与参数name与处理器处理方法的参数列表的参数顺序与参数名一致
    public ModelAndView regist(@RequestParam(value = "myusername", required = true, defaultValue = "默认用户名") String username, @RequestParam(value = "mypassword", required = true, defaultValue = "默认密码") String password) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myusername", username);
        modelAndView.addObject("mypassword", password);
        modelAndView.setViewName("regist");
        return modelAndView;
    }
}
