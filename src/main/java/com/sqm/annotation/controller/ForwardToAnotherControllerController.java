package com.sqm.annotation.controller;

import com.sqm.annotation.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
@RequestMapping("/test")
public class ForwardToAnotherControllerController {
    @RequestMapping("/some.do")
    public ModelAndView doSome(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("forward:other.do");
        return modelAndView;
    }

    @RequestMapping("/other.do")
    public ModelAndView doOther() {
        return new ModelAndView("forward:third.do");
    }

    @RequestMapping("/third.do")
    public ModelAndView doThird(User user) {
        System.out.println("user =" + user);
        return new ModelAndView("forward:/web-resources/forward.jsp");
    }
}
