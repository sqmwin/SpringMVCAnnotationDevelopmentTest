package com.sqm.annotation.controller;

import com.sqm.annotation.vo.User;
import com.sqm.annotation.vo.UserInformation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
public class UserController {
    @RequestMapping(value = "/regist.do",method = RequestMethod.POST)
    public ModelAndView regist(User user) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myUser", user);
        modelAndView.setViewName("regist");
        return modelAndView;
    }
}
