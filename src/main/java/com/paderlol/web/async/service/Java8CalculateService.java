package com.paderlol.web.async.service;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Java8CalculateService implements CalculateService {

    @Override
    public Integer sum(Integer... values) {
        log.info("Java8 Lambda 求和:");
        return Arrays.stream(values).reduce(0, Integer::sum);
    }


}
