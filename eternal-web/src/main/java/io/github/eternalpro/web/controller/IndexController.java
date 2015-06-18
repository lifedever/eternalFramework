package io.github.eternalpro.web.controller;

import io.github.eternalpro.model.User;
import io.github.eternalpro.service.UserService;
import io.github.eternalpro.web.core.annotation.Pjax;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by gefangshuai on 2015/6/15.
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @Resource
    private UserService userService;

    @RequestMapping
    public String index(HttpServletRequest request, Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }

    @Pjax
    @RequestMapping("/signup")
    public String signup(HttpServletRequest request){
        return "signup";
    }

    @Pjax
    @RequestMapping("/signin")
    public String signin() {
        return "signin";
    }
}
