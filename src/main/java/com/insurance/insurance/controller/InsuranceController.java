package com.insurance.insurance.controller;

import com.insurance.insurance.payload.InsuranceDto;
import com.insurance.insurance.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/insurances")
public class InsuranceController {
    private InsuranceService insuranceService;

    public InsuranceController(InsuranceService insuranceService) {
        this.insuranceService = insuranceService;
    }
    @PostMapping
    public ResponseEntity<InsuranceDto>createInsurance(@RequestBody InsuranceDto insuranceDto){
        InsuranceDto insurance = insuranceService.createInsurance(insuranceDto);
        return new ResponseEntity<>(insurance, HttpStatus.CREATED);
    }

}
