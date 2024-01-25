package com.insurance.insurance.controller;

import com.insurance.insurance.payload.PolicyDto;
import com.insurance.insurance.service.PolicyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/policy")
public class PolicyController {
    private PolicyService policyService;

    public PolicyController(PolicyService policyService) {
        this.policyService = policyService;
    }

    // http://localhost:8080/api/policy?insuranceId=1
    @PostMapping
    public ResponseEntity<PolicyDto> createPolicy(
            @RequestBody PolicyDto policyDto,
            @RequestParam long insuranceId
    ) {
        PolicyDto policyDtos = policyService.createPolicy(policyDto, insuranceId);
        return new ResponseEntity<>(policyDtos, HttpStatus.CREATED);
    }
}
