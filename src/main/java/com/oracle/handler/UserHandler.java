package com.oracle.handler;

import com.oracle.service.UserService;
import com.oracle.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserHandler {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value ="Info.do",method = RequestMethod.GET)
    public User getUserInfo(User user){
        User user1=userService.getUserInfo(user);
        return user1;
    }


//    @ResponseBody
//    @RequestMapping(value ="login.do",method = RequestMethod.GET)
//    public User Login(User user){
//        userService.saveUserInfo(user);
//        System.out.println(user);
//        return user;
//    }

}
