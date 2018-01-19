package com.charles.webflux.congifuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.*;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * 2018/1/15 9:56
 */
@Configuration
public class HelloWorldConfiguration {


    @Bean
    public RouterFunction helloworld(){
        RequestPredicate requestPredicate = RequestPredicates.GET("/charles");
        HandlerFunction<ServerResponse> handlerFunction =
                request -> ServerResponse.ok().body(fromObject("Hello World"));


        return route(requestPredicate, handlerFunction);

    }


}
