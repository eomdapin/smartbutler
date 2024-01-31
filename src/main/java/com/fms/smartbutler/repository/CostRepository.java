package com.fms.smartbutler.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fms.smartbutler.domain.Cost;

public interface CostRepository extends JpaRepository<Cost, Long>{
	Optional<Cost> findByBuild_BuildIdAndDate(Long buildId, String date);
}
