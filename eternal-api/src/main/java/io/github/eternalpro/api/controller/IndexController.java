package io.github.eternalpro.api.controller;

import io.github.eternalpro.model.User;
import io.github.eternalpro.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by gefangshuai on 2015/6/16.
 */
@RestController
@RequestMapping("/")
public class IndexController {

    @Resource
    private UserService userService;

    @RequestMapping
    public List<User> getUsers(){
        return null;
    }
}
