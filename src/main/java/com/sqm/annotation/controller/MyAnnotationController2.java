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
public class MyAnnotationController2 extends MyAnnotationController {
    @Override
    @RequestMapping("/some/*/some*.do")
    public ModelAndView doSome(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("some");
    }

    @Override
    @RequestMapping("/other/**/*other.do")
    public ModelAndView doOther(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("other");
    }
}
