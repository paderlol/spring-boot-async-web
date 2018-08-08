package com.paderlol.web.async.service;

import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService {

    private final RiskAssessorService riskAssessorService;

    //If a bean has one constructor, you can omit the @Autowired, as shown in the following example:
    public AccountServiceImpl(
            RiskAssessorService riskAssessorService) {
        this.riskAssessorService = riskAssessorService;
    }

    @Override
    public void sayHello() {
        riskAssessorService.assessor();
    }
}
