package com.yzy.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    /*@GetMapping("/login")
    public String login(){
        return "/login";
    }*/

    @PostMapping("/userLogin")
    public String userLogin(String username, String password, Model model, HttpSession session){
        //模拟登录数据
        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            session.setAttribute("username",username);
            return "redirect:/main";
        }else {
            model.addAttribute("msg","用户名或密码错误");
            return "login";
        }
    }
}
