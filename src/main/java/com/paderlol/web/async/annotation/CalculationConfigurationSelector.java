package com.paderlol.web.async.annotation;

import com.paderlol.web.async.service.Java7CalculateService;
import com.paderlol.web.async.service.Java8CalculateService;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

public class CalculationConfigurationSelector implements ImportSelector {

    public static final String JAVA_8 = "Java8";

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        String jdkVersion = System.getProperty("jdkVersion");

        if(JAVA_8.equals(jdkVersion)){
            return new String[]{ Java8CalculateService.class.getName()};
        }
         return new String[]{ Java7CalculateService.class.getName()};
    }
}
