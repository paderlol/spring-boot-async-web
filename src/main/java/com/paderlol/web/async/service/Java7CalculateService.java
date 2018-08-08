package com.paderlol.web.async.service;

import lombok.extern.slf4j.Slf4j;

/**
 * Java7 求和方式
 */
@Slf4j
public class Java7CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        log.info("Java8 Lambda 求和");
        int sum = 0;
        for (int i = 0; i < values.length; i++) {
            sum += values[i];
        }
        return sum;
    }
}
