package com.chinasofti.security.controller;


import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.chinasofti.security.entity.User;


@Controller
public class LoginController {
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    
    @RequestMapping("/main")
    public String main() {
        return "main";
    }
    
    
    /** 
     * @Description 我们和shiro框架的交互完全通过Subject这个类去交互,用它完成登录,注销,获取当前的用户对象等操作:
     * @return String 返回类型  
     * @throws 
     */
    @RequestMapping(value="/loginUser")
    public String loginUser(String username, String password,
            HttpSession session) {
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(
                username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            //在这里掉到了shiro中进行登录校验,如果权限校验没有通过就不会往下走
            subject.login(usernamePasswordToken); //完成登录
            User user = (User)subject.getPrincipal();
            session.setAttribute("user", user);
            return "main";
        }
        catch (Exception e) {
            return "login";//返回登录页面
        }
        
    }
    
    @RequestMapping("/logOut")
    public String logOut(HttpSession session) {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "login";
    }
}
