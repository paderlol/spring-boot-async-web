package com.paderlol.web.async.controller;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

@RestController
@RequestMapping("servlet-async")
@Slf4j
public class ServletAsyncController {

    private static final ExecutorService threadPool = Executors.newCachedThreadPool();


    @GetMapping(value = "/fetch-value/{field}", produces = "application/stream+json")
    public DeferredResult<String> fetchValue(@PathVariable("field") Optional<String> field) {
        field.ifPresent(value -> log.info("测试参数Optional {}", value));
        DeferredResult<String> deferredResult = new DeferredResult(10L);
        log.info("主线程接收请求");
        CompletableFuture.supplyAsync(() -> {
            log.info("副线程接收请求");

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "fetch-value-servlet";
        }, threadPool).whenCompleteAsync((result, throwable) -> deferredResult.setResult(result));
        log.info("Servlet thread released");

        return deferredResult;
    }
}
