package com.paderlol.web.async.annotation;


import com.paderlol.web.async.autoconfigure.NoneAnnotationConfiguration;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.context.annotation.Import;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({ CalculationConfigurationSelector.class, NoneAnnotationConfiguration.class })
public @interface EnableCalculation {

}
