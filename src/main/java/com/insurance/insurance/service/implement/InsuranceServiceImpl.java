package com.insurance.insurance.service.implement;

import com.insurance.insurance.entity.Insurance;
import com.insurance.insurance.exception.ResourceNotFoundException;
import com.insurance.insurance.payload.InsuranceDto;
import com.insurance.insurance.repository.InsuranceRepository;
import com.insurance.insurance.service.InsuranceService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InsuranceServiceImpl implements InsuranceService {

    private InsuranceRepository insuranceRepository;
    private ModelMapper modelMapper;

    public InsuranceServiceImpl(InsuranceRepository insuranceRepository,ModelMapper modelMapper) {
        this.insuranceRepository = insuranceRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public InsuranceDto createInsurance(InsuranceDto insuranceDto) {
        Insurance insurances = mapToEntity(insuranceDto);

        Insurance saveDeatiles = insuranceRepository.save(insurances);

        InsuranceDto dto = mapToDto(saveDeatiles);
        return dto;
    }

    @Override
    public InsuranceDto getDetailesById(long id) {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("information not found with id: " + id)
        );
        InsuranceDto dto = mapToDto(insurance);
        return dto;
    }

    @Override
    public List<InsuranceDto> getAllRecords(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending() : Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNo, pageSize,sort);
        Page<Insurance> pageInsurances = insuranceRepository.findAll(pageable);
        List<Insurance> insurances = pageInsurances.getContent();
        List<InsuranceDto> dtos = insurances.stream().map(i -> mapToDto(i)).collect(Collectors.toList());
        return dtos;
    }

    InsuranceDto mapToDto(Insurance insurance) {
        InsuranceDto dto = modelMapper.map(insurance, InsuranceDto.class);
//        InsuranceDto dto = new InsuranceDto();
//        dto.setId(insurance.getId());
//        dto.setCustomerName(insurance.getCustomerName());
//        dto.setVehicleNumber(insurance.getVehicleNumber());
//        dto.setEmail(insurance.getEmail());
//        dto.setMobileNumber(insurance.getMobileNumber());
        return dto;
    }

    Insurance mapToEntity(InsuranceDto insuranceDtoDto) {
        Insurance insurance = modelMapper.map(insuranceDtoDto, Insurance.class);
//        Insurance insurance = new Insurance();
//        insurance.setId(insuranceDtoDto.getId());
//        insurance.setCustomerName(insuranceDtoDto.getCustomerName());
//        insurance.setVehicleNumber(insuranceDtoDto.getVehicleNumber());
//        insurance.setEmail(insuranceDtoDto.getEmail());
//        insurance.setMobileNumber(insuranceDtoDto.getMobileNumber());
        return insurance;
    }
}
