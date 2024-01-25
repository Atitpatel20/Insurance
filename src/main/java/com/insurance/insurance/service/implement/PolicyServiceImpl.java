package com.insurance.insurance.service.implement;

import com.insurance.insurance.entity.Insurance;
import com.insurance.insurance.entity.Policy;
import com.insurance.insurance.payload.PolicyDto;
import com.insurance.insurance.repository.InsuranceRepository;
import com.insurance.insurance.repository.PolicyRepository;
import com.insurance.insurance.service.PolicyService;
import org.hibernate.ResourceClosedException;
import org.springframework.stereotype.Service;

@Service
public class PolicyServiceImpl implements PolicyService {
    private InsuranceRepository insuranceRepository;
    private PolicyRepository policyRepository;

    public PolicyServiceImpl(InsuranceRepository insuranceRepository, PolicyRepository policyRepository) {
        this.insuranceRepository = insuranceRepository;
        this.policyRepository = policyRepository;
    }

    @Override
    public PolicyDto createPolicy(PolicyDto policyDto, long insuranceId) {
        Insurance insurance = insuranceRepository.findById(insuranceId).orElseThrow(
                () -> new ResourceClosedException("Policy not found with id:" + insuranceId)
        );
        Policy policy= new Policy();
        policy.setPolicyNumber(policyDto.getPolicyNumber());
        policy.setCoverageDetails(policyDto.getCoverageDetails());
        policy.setInsurance(insurance);
        Policy savedPolicy = policyRepository.save(policy);
        PolicyDto dto= new PolicyDto();
        dto.setId(savedPolicy.getId());
        dto.setPolicyNumber(savedPolicy.getPolicyNumber());
        dto.setCoverageDetails(savedPolicy.getCoverageDetails());
        return dto;
    }
}
