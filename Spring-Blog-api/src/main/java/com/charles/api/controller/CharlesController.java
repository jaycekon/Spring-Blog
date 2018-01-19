package com.charles.api.controller;

import com.charles.api.model.Charles;
import com.charles.api.repository.CharlesRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 用户管理APi 接口
 *
 * 2018/1/15 19:58
 */
@RestController
@RequestMapping(value = "/charles")
public class CharlesController {

    @Autowired
    private CharlesRepository repository;

    @ApiOperation(value = "获取图书列表", notes = "获取图书列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public Flux<Charles> findList() {
        return Flux.fromIterable(repository.findAll());
    }
}
