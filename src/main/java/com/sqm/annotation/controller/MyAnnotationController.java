package com.sqm.annotation.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
@RequestMapping("/test")
public class MyAnnotationController {
    @RequestMapping("/my-annotation-controller.do")
    public ModelAndView doSome(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("p", "/test/my-annotation-controller/doSome");
        modelAndView.setViewName("view");
        return modelAndView;
    }
    @RequestMapping("/my-controller.do")
    public ModelAndView doOther(HttpServletRequest request, HttpServletResponse response) throws Exception{
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("p", "/test/my-annotation-controller/doOther");
        modelAndView.setViewName("view");
        return modelAndView;
    }
}
