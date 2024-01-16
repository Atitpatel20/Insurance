package com.insurance.insurance.service.implement;

import com.insurance.insurance.entity.Insurance;
import com.insurance.insurance.exception.ResourceNotFoundException;
import com.insurance.insurance.payload.InsuranceDto;
import com.insurance.insurance.repository.InsuranceRepository;
import com.insurance.insurance.service.InsuranceService;
import org.springframework.stereotype.Service;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private InsuranceRepository insuranceRepository;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository) {
        this.insuranceRepository = insuranceRepository;
    }

    @Override
    public InsuranceDto createInsurance(InsuranceDto insuranceDto) {
        Insurance insurances= new Insurance();
        insurances.setCustomerName(insuranceDto.getCustomerName());
        insurances.setEmail(insuranceDto.getEmail());
        insurances.setMobileNumber(insuranceDto.getMobileNumber());
        insurances.setVehicleNumber(insuranceDto.getVehicleNumber());

        Insurance saveDeatiles = insuranceRepository.save(insurances);
        InsuranceDto dto= new InsuranceDto();
        dto.setCustomerName(saveDeatiles.getCustomerName());
        dto.setEmail(saveDeatiles.getEmail());
        dto.setMobileNumber(saveDeatiles.getMobileNumber());
        dto.setVehicleNumber(saveDeatiles.getVehicleNumber());
        return dto;
    }
    @Override
    public InsuranceDto getDetailesById(long id) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("information not found with id: " +id)
        );
        InsuranceDto dto= new InsuranceDto();
        dto.setId(insurance.getId());
        dto.setCustomerName(insurance.getCustomerName());
        dto.setEmail(insurance.getEmail());
        dto.setVehicleNumber(insurance.getVehicleNumber());
        dto.setMobileNumber(insurance.getMobileNumber());
        return dto;
    }
}
