package io.github.eternalpro.web.controller;

import io.github.eternalpro.model.User;
import io.github.eternalpro.service.UserService;
import io.github.eternalpro.web.core.annotation.Pjax;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gefangshuai on 2015/6/15.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String index(HttpServletRequest request, Model model) {

        return "index";
    }

    @Pjax
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(HttpServletRequest request){
        return "signup";
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public String login(String username, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject currentUser = SecurityUtils.getSubject();
        currentUser.login(token);
        return "redirect:/";
    }

    @Pjax
    @RequestMapping("/signin")
    public String signin() {
        return "signin";
    }

    @RequestMapping("/logout")
    public String logout(){
        SecurityUtils.getSubject().logout();
        return "redirect:/";
    }
}
