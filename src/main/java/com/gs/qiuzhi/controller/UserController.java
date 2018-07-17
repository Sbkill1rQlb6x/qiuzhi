package com.gs.qiuzhi.controller;


import com.gs.qiuzhi.pojo.User;
import com.gs.qiuzhi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
        m.addAttribute("users", users);
        return "user2";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "home";
    }

    @RequestMapping("/index.do")
    public String index() {
        return "home";
    }

    @RequestMapping("/testGit")
    public String git() {
        return "home";
    }


    @RequestMapping("/loginView.do")
    public String loginView() {
        return "login";
    }

    @RequestMapping("/registerView.do")
    public String registerView() {
        return "register";
    }

    @RequestMapping("personView")
    public String personView(){
        return "person";
    }

    @RequestMapping("/updatePassView.do")
    public String updatePassView(){
        return "updatePass";
    }

    @RequestMapping("/updatePassView2.do")
    public String updatePassView2(){
        return "updatePass2";
    }

    @RequestMapping("/klDetail.do")
    public String klDetall(){
        return "klDetail";
    }

    @RequestMapping("/klSort.do")
    public String getPage(String page){
        return "klSort";
    }

    @RequestMapping("/klManagement.do")
    public String klManagement(){
        return "klManagement";
    }

    @RequestMapping("/adminIndex.do")
    public String adminIndex(){
        return "admin/adminIndex";
    }

    @RequestMapping("userManagement.do")
    public String userManagement(){
        return "admin/userManagement";
    }

    @RequestMapping("adManagement.do")
    public String adManagement(){
        return "admin/adManagement";
    }

    @RequestMapping("kwManagement.do")
    public String kwManagement(){
        return "admin/kwManagement";
    }

    @RequestMapping("addKW.do")
    public String addKW(){
        return "admin/addKW";
    }

    @RequestMapping("addKL.do")
    public String addKL(){
        return "addKL";
    }

}
