package com.insurance.insurance.service.implement;

import com.insurance.insurance.entity.Insurance;
import com.insurance.insurance.entity.Policy;
import com.insurance.insurance.payload.PolicyDto;
import com.insurance.insurance.repository.InsuranceRepository;
import com.insurance.insurance.repository.PolicyRepository;
import com.insurance.insurance.service.PolicyService;
import org.hibernate.ResourceClosedException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class PolicyServiceImpl implements PolicyService {
    private InsuranceRepository insuranceRepository;
    private PolicyRepository policyRepository;
    private ModelMapper modelMapper;

    public PolicyServiceImpl(InsuranceRepository insuranceRepository, PolicyRepository policyRepository, ModelMapper modelMapper) {
        this.insuranceRepository = insuranceRepository;
        this.policyRepository = policyRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public PolicyDto createPolicy(PolicyDto policyDto, long insuranceId) {
        Insurance insurance = insuranceRepository.findById(insuranceId).orElseThrow(
                () -> new ResourceClosedException("Policy not found with id:" + insuranceId)
        );
        Policy policy = mapToEntity(policyDto);
//        Policy policy= new Policy();
//        policy.setPolicyNumber(policyDto.getPolicyNumber());
//        policy.setCoverageDetails(policyDto.getCoverageDetails());
//        policy.setInsurance(insurance);
        Policy savedPolicy = policyRepository.save(policy);
//        PolicyDto dto= new PolicyDto();
//        dto.setId(savedPolicy.getId());
//        dto.setPolicyNumber(savedPolicy.getPolicyNumber());
//        dto.setCoverageDetails(savedPolicy.getCoverageDetails());
        return mapToDto(savedPolicy);
    }

    @Override
    public void deletePolicy(long id) {
        policyRepository.deleteById(id);
    }

    @Override
    public PolicyDto updatePolicy(long id, PolicyDto policyDto, long insuranceId) {
        Insurance insurance = insuranceRepository.findById(insuranceId).orElseThrow(
                () -> new ResourceClosedException("Insurance not found with id" + insuranceId)
        );
        Policy policy = policyRepository.findById(id).orElseThrow(
                () -> new ResourceClosedException("policy not found with id"+id)
        );
        Policy p = mapToEntity(policyDto);
        p.setId(policy.getId());
        p.setInsurance(insurance);
        Policy update = policyRepository.save(p);
        return mapToDto(update);
    }

    PolicyDto mapToDto(Policy policy) {
        PolicyDto dto = modelMapper.map(policy, PolicyDto.class);
        return dto;
    }
    Policy mapToEntity(PolicyDto policyDto) {
        Policy policy = modelMapper.map(policyDto, Policy.class);
        return policy;
    }

}
