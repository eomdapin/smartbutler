package com.fms.smartbutler.repository;

/**
* @author 정시운
* @editDate 2024-01-31 ~ 2024-02-02
*/

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Estimate;

public interface EstimateRepository extends JpaRepository<Estimate, Long> {
	List<Estimate> findAllByConfirm(int confirm);
	Page<Estimate> findAllByOrderByEstimateIdDesc(Pageable pageable);
}
