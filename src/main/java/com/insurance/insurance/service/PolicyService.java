package com.insurance.insurance.service;

import com.insurance.insurance.payload.PolicyDto;

public interface PolicyService {
    PolicyDto createPolicy(PolicyDto policyDto, long insuranceId);
}
