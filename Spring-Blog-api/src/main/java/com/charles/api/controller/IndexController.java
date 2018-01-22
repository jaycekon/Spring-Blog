package com.charles.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

/**
 * Created by Jaycekon on 2018/1/14.
 */
@ApiIgnore
@Controller
public class IndexController {


    @RequestMapping(value = "hello")
    public String index(Model model) {
        model.addAttribute("name", "黄伟杰");
        return "hello";
    }

}
