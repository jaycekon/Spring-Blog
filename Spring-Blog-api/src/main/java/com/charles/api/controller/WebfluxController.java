package com.charles.api.controller;

import com.charles.api.model.Charles;
import com.charles.api.repository.CharlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collection;

/**
 * Created by Jaycekon on 2018/1/14.
 */
@Controller
public class WebfluxController {

    @Autowired
    private CharlesRepository charlesRepository;
    @Autowired
    private Charles charles;

    @RequestMapping(value = "charles")
    @ResponseBody
    public Mono<Charles> index() {
        return Mono.just(charles);

    }


    @PostMapping("/save")
    @ResponseBody
    public Mono<Charles> save(Charles charles) {
        return Mono.just(charlesRepository.save(charles));
    }

    @GetMapping("/list")
    @ResponseBody
    public Flux<Charles> list() {
        Collection<Charles> charles = charlesRepository.findAll();
        return Flux.fromIterable(charles);
    }
}
