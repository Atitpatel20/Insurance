package com.insurance.insurance.payload;

import lombok.Data;

@Data
public class PolicyDto {
    private long id;
    private String policyNumber;
    private String coverageDetails;
}
