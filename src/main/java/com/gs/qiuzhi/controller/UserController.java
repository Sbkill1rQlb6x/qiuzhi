package com.gs.qiuzhi.controller;



import com.gs.qiuzhi.pojo.User;
import com.gs.qiuzhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 控制器
 */
@Controller

public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/testMybatis")
    public String listUser(Model m) {
        List<User> users = userService.findAll();
        m.addAttribute("users",users);
        return "user2";
    }

    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }


}
