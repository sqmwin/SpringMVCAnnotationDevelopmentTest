package com.sqm.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
public class PathController {
    @RequestMapping("/{pname}/{age}/regist.do")
    public ModelAndView regist(@PathVariable("pname")String name,@PathVariable int age) throws Exception {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("myname", name);
        modelAndView.addObject("myage", age);
        modelAndView.setViewName("regist");
        return modelAndView;
    }
}
