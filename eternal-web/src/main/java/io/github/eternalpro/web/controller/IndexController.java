package io.github.eternalpro.web.controller;

import io.github.eternalpro.model.User;
import io.github.eternalpro.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
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
    public String index(Model model) {
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "index";
    }
}
