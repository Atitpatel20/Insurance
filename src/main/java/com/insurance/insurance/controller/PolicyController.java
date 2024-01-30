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
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePolicy(@PathVariable long id){
        policyService.deletePolicy(id);
        return new ResponseEntity<>("Policy is deleted",HttpStatus.OK);
    }
    // http://localhost:8080/api/policy/1/insurance/1
    @PutMapping("/{id}/insurance/{insuranceId}")
    public ResponseEntity<PolicyDto>updatePolicy(@PathVariable long id,@RequestBody PolicyDto policyDto,@PathVariable long insuranceId ){
        PolicyDto dtos=policyService.updatePolicy(id,policyDto,insuranceId);
        return new ResponseEntity<>(dtos,HttpStatus.OK);
    }
}
