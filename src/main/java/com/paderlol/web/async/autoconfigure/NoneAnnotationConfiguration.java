package com.paderlol.web.async.autoconfigure;

import com.paderlol.web.async.controller.Pet;
import org.springframework.context.annotation.Bean;

public class NoneAnnotationConfiguration {

    @Bean
    public Pet pet() {
        return new Pet(1, "2");
    }

}
