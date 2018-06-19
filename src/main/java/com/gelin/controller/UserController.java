/*
package com.gelin.controller;

import com.gelin.domain.PageBeans;
import com.gelin.domain.User;
import com.gelin.services.UserServices;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

*/
/**
 * Created by 葛林 on 2017/6/29.
 *//*

@Controller
@RequestMapping("/aaa")
public class UserController {

    @Resource
    private UserServices userServices;

    @GetMapping("/bbb")
    public String getHome(){
        return "home";
    }

    @GetMapping("/fff")
    public String getIndex(){
        return "index";
    }

    @RequestMapping("/ccc")
    @ResponseBody
    public String getName(){
        return userServices.getName();
    }

    @RequestMapping("/ddd")
    @ResponseBody
    public String insertUser(User user){
        user=new User("aaa",25,"123");
        userServices.insertUser(user);
        return userServices.getName();
    }

    @PostMapping("/eee")
    @ResponseBody
    public PageBeans<User> getUserList(Integer current){
        return userServices.getPage(current);
    }


}
*/
