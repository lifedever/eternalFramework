package io.github.eternalpro.web.controller;

import io.github.eternalpro.model.User;
import io.github.eternalpro.service.UserService;
import io.github.eternalpro.web.core.annotation.Pjax;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/6/19.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Resource
    private UserService userService;

    @Pjax
    @RequestMapping
    public String index(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "admin/index";
    }
}
