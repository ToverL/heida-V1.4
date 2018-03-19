package com.oracle.handler;

import com.alibaba.fastjson.JSONObject;
import com.oracle.service.UserService;
import com.oracle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.json.JsonObject;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class LoginHandler {
    @Autowired
    UserService userService;
    @RequestMapping(value = "signin.do",method = RequestMethod.GET)
    @ResponseBody
    public User Login(HttpServletResponse response, User user) throws IOException {
        System.out.println(user);
        //userService.saveUserInfo(user);
        //JSONObject result = new JSONObject();
        //result.put("user",user);
        //response.getWriter().write(result.toJSONString());
        return user;
    }
}
