package com.fms.smartbutler.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Estimate;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {
	List<Estimate> findAllByConfirm(int confirm);
}
