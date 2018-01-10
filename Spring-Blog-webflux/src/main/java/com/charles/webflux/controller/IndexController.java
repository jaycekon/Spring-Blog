package com.charles.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jaycekon on 2018/1/10.
 */
@RestController
public class IndexController {

    @GetMapping("index")
    public String index() {
        return "hello world!";
    }
}
