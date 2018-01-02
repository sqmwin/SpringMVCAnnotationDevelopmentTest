package com.sqm.annotation.controller;

import com.sqm.annotation.vo.User;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * @author sqm
 * @version 1.0
 */
@Controller
public class AjaxController {
    //处理器接收ajax请求的参数,可以逐个接收也可以以对象的方式整体接收
    @RequestMapping("/my-ajax.do")
    public void doAjax(HttpServletResponse response, User user) throws Exception {
        //将数据存放到map中
        Map<String, Object> map = new HashMap<>();
        map.put("myusername", user.getMyusername());
        map.put("mypassword", user.getMypassword());
        map.put("name", user.getUserInformation().getName());
        map.put("age", user.getUserInformation().getAge());
        //将map转换为JSON,JSON转为字符串
        JSONObject myJson = JSONObject.fromObject(map);
        String jsonString = myJson.toString();
        //将数据发回客户端
        response.setCharacterEncoding("utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.print(jsonString);
        printWriter.close();
    }
}
