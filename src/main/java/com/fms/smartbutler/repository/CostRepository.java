package com.fms.smartbutler.repository;

/**
* @author 엄다빈
* @editDate 2024-01-30 ~ 2024-01-31
*/

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Cost;

public interface CostRepository extends JpaRepository<Cost, Long>{
	Optional<Cost> findByBuild_BuildIdAndDate(Long buildId, LocalDate date);
	List<Cost> findByBuild_BuildIdOrderByDateDesc(Long buildId);
}
