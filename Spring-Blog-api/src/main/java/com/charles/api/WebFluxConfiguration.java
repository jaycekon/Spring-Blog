package com.charles.api;

import com.charles.api.model.Charles;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * webflux 配置类
 * Created by Jaycekon on 2018/1/14.
 */
@Configuration
public class WebFluxConfiguration {

    /**
     * 通过Spring boot 的actors /beans 来查看RouterFunction
     *
     * @return
     */
    @Bean
    public RouterFunction helloworld() {
        RequestPredicate requestPredicate = RequestPredicates.GET("/webflux");
        HandlerFunction handlerFunction = new HandlerFunction() {
            /**
             *  处理请求
             * @param request
             * @return
             */
            @Override
            public Mono handle(ServerRequest request) {
                return ServerResponse.ok().body(Mono.just("hello webflux"), String.class);
            }
        };

        RouterFunction temp = route(requestPredicate, handlerFunction);
        return temp;
    }


    @Bean
    public Charles init() {
        Charles charles = new Charles();
        charles.setName("Jaycekon");
        charles.setId(1);
        return charles;
    }
}

