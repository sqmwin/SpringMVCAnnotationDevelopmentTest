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
public class ForwardController {
    @RequestMapping("/forward.do")
    public ModelAndView fordward(User user) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("forward:/web-resources/forward.jsp");
        return modelAndView;
    }
}
