package com.insurance.insurance.controller;

import com.insurance.insurance.payload.InsuranceDto;
import com.insurance.insurance.service.InsuranceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    // http://localhost:8080/api/insurances?pageNo=0&pageSize=3
    @GetMapping
    public List<InsuranceDto> getAllRecords(
            @RequestParam(name="pageNo",required = false,defaultValue = "0")int pageNo,
            @RequestParam(name="pageSize",required = false,defaultValue = "0")int pageSize
    ){
        List<InsuranceDto> dtos=insuranceService.getAllRecords(pageNo,pageSize);
        return dtos;
    }
}
