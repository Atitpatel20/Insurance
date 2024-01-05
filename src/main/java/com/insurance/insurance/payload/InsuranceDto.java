package com.insurance.insurance.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class InsuranceDto {
    private long id;
    private String customerName;
    private String email;
    private String vehicleNumber;
    private long mobileNumber;
}
