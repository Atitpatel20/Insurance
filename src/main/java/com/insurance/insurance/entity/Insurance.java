package com.insurance.insurance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "insurances")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String customerName;
    private String email;
    private String vehicleNumber;
    private long mobileNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "insurance")
    private List<Policy> policies;
}
