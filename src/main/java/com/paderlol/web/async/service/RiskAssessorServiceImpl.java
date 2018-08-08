package com.paderlol.web.async.service;

import org.springframework.stereotype.Service;

@Service
public class RiskAssessorServiceImpl implements RiskAssessorService {


    @Override
    public void assessor() {
        System.out.println("调用服务RiskAssessorService");
    }
}
