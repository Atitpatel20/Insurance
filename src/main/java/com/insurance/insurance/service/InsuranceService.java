package com.insurance.insurance.service;

import com.insurance.insurance.payload.InsuranceDto;

import java.util.List;

public interface InsuranceService {
    InsuranceDto createInsurance(InsuranceDto insuranceDto);

    InsuranceDto getDetailesById(long id);

    List<InsuranceDto> getAllRecords();
}
