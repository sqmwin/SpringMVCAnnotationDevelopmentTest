package com.sqm.annotation.controller;

import com.sqm.annotation.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
public class ReturnController {
    @RequestMapping(value = "/return-string.do", method = RequestMethod.POST)
    public String returnString(HttpServletRequest request, User user) throws Exception {
        request.setAttribute("myUser", user);
        return "string";
    }

    //请求转发,携带request,response与vo对象
    @RequestMapping("/return-void.do")
    public void returnVoid(HttpServletRequest request, HttpServletResponse response, User user) throws Exception {
        request.setAttribute("myUser", user);
        request.getRequestDispatcher("/web-resources/void.jsp").forward(request, response);
    }

    //返回Object
    @RequestMapping("/test/return-number.do")
    @ResponseBody
    public Object returnObject() {
        return 123.456;
    }
}

