package com.gelin.controller;

import com.gelin.domain.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;

/**
 * Created by 葛林 on 2017/7/3.
 */
@Controller
public class ShiroController {

    @RequestMapping("/login")
    public String login() {
        return "index";
    }

    @RequestMapping("/loginUser")
    public String loginUser(String username, String password, HttpSession session, boolean rememberMe) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password, rememberMe);
        usernamePasswordToken.setRememberMe(true);
        Subject subject = SecurityUtils.getSubject();
        subject.login(usernamePasswordToken);//完成登录
        if (subject.isAuthenticated()) {
            User user = (User) subject.getPrincipal();//得到对象
            session.setAttribute("user", user);
            session.setAttribute("aaa", "666");
            session.setAttribute("bbb", "777");
            List<String> list = Arrays.asList("1", "2", "3", "4");
            session.setAttribute("list", list);
            return "/Shiro";
        } else {
            usernamePasswordToken.clear();
            return "redirect:index";
        }
    }

    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
//        session.removeAttribute("user");
        return "index";
    }
}
