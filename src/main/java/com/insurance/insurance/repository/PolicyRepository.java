package com.insurance.insurance.repository;

import com.insurance.insurance.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PolicyRepository extends JpaRepository<Policy,Long> {
}
