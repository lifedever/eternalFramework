package io.github.eternalpro.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by gefangshuai on 2015/6/15.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping
    public String index() {
        return "index";
    }
}
