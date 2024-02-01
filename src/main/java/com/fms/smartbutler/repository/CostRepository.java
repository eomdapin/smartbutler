package com.fms.smartbutler.repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Cost;

public interface CostRepository extends JpaRepository<Cost, Long>{
	Optional<Cost> findByBuild_BuildIdAndDate(Long buildId, LocalDate date);
	List<Cost> findByBuild_BuildIdOrderByDateDesc(Long buildId);
}
