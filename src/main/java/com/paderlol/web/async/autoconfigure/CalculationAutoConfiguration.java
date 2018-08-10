package com.paderlol.web.async.autoconfigure;

import com.paderlol.web.async.annotation.EnableCalculation;
import com.paderlol.web.async.autoconfigure.condition.ConditionalOnSystemProperty;
import com.paderlol.web.async.controller.Pet;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ConditionalOnSystemProperty(name = "jdkVersion", value = "jdkVersion")
@EnableCalculation
public class CalculationAutoConfiguration {




}
