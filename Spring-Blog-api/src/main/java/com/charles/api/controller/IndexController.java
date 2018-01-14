package com.charles.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Jaycekon on 2018/1/14.
 */
@Controller
public class IndexController {


    @RequestMapping(value = "hello")
    public String index(Model model) {
        model.addAttribute("name", "Dear");
        return "hello";
    }


    @RequestMapping(value = "index")
    @ResponseBody
    public String hello() {
        return "hello world!";
    }
}
