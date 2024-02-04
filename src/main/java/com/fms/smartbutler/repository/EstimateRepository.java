package com.fms.smartbutler.repository;

/**
* @author 정시운
* @editDate 2024-01-31 ~ 2024-02-02
*/

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Estimate;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {

}
