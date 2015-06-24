package io.github.eternalpro.web.controller;

import io.github.eternalpro.model.User;
import io.github.eternalpro.service.UserService;
import io.github.eternalpro.web.core.annotation.Pjax;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

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

        return "index";
    }

    @Pjax
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(HttpServletRequest request){
        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String registerUser(User user, BindingResult result, RedirectAttributes redirectAttributes) {
        if (result.hasErrors()) {
            return "redirect: /signup";
        }else{
            user.setPassword(new String(DigestUtils.md5Hex(user.getPassword())));
            userService.saveUser(user);
            redirectAttributes.addFlashAttribute("success", "注册成功，请登录！");
            return "redirect: /signin";
        }
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
