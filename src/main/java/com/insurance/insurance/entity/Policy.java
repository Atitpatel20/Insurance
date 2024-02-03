package com.insurance.insurance.entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "policies")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String policyNumber;
    private String coverageDetails;

    @ManyToOne
    @JoinColumn(name = "insurance_id")
    private Insurance insurance;
}
