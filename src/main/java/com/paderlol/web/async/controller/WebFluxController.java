package com.paderlol.web.async.controller;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@RestController
@RequestMapping("/web-flux")
@Slf4j
public class WebFluxController {

    @GetMapping(value = "/fetch-value")
    public Mono<String> fetchValue() {
        log.info("主线程接收请求");
        return Mono.fromCallable(() -> {
            log.info("副线程接收请求");
            TimeUnit.SECONDS.sleep(2);
            return "fetch-value";
        }).subscribeOn(Schedulers.elastic());
    }
}
