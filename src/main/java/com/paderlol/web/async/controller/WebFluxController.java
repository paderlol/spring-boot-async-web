package com.paderlol.web.async.controller;

import java.util.concurrent.TimeUnit;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
            return "fetch-value-dev-tool";
        }).subscribeOn(Schedulers.elastic());
    }

    @PostMapping("/owners/{ownerId}/pets/{petId}/edit")
    public Mono<String> processSubmit(@Valid @ModelAttribute("pet") Mono<Pet> petMono) {
        return petMono
                .flatMap(pet ->{
                    System.out.println(pet);
                    return Mono.just("ss");
                } )
                .onErrorResume(ex -> Mono.just("ss"));
    }
}
