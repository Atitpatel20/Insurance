package com.insurance.insurance.controller;

import com.insurance.insurance.payload.InsuranceDto;
import com.insurance.insurance.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/{id}")
    public ResponseEntity<InsuranceDto> getDetailesById(@PathVariable long id){
        InsuranceDto dto = insuranceService.getDetailesById(id);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }
}
