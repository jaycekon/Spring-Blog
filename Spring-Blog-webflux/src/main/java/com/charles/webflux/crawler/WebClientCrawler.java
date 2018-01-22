package com.charles.webflux.crawler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * TODO 加点注释
 *
 * @author <a href="mailto:weijie_huang"> weijie_huang </a>
 * 2018/1/22 21:20
 */
public class WebClientCrawler {


    private static Logger logger = LoggerFactory.getLogger(WebClientCrawler.class);

    public static void main(String[] args) {
        crawlClient();
    }


    /**
     * 抓取百度首页，直接输出结果
     */
    private static void crawlIndex() {
        Mono<String> resp = WebClient.create()
                .method(HttpMethod.GET)
                .uri("http://www.baidu.com/")
                .retrieve()
                .bodyToMono(String.class);

        logger.info("抓取结果:{}", resp.block());

    }

    private static void crawlClient() {
        WebClient webClient = WebClient.create();
        Mono<String> resp = webClient
                .method(HttpMethod.GET)
                .uri("http://www.baidu.com/")
                .retrieve()
                .bodyToMono(String.class);

        logger.info("抓取结果:{}", resp.block());
    }

}
