package com.paderlol.web.async;

import com.paderlol.web.async.service.AccountService;
import com.paderlol.web.async.service.CalculateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
public class AsyncApplication implements CommandLineRunner {

    @Autowired
    private CalculateService calculateService;


    public static void main(String[] args) {
        new SpringApplicationBuilder(AsyncApplication.class).web(WebApplicationType.REACTIVE)
                .run(args);
//        SpringApplication.run(AsyncApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        calculateService.sum(1,2,3,4,5,6,7,8,9,10);
    }
}
